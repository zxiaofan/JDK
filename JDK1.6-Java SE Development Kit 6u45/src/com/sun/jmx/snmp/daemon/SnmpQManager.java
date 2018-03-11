/*
 * %Z%file      %M%
 * %Z%author    Sun Microsystems, Inc.
 * %Z%version   %I%
 * %Z%date      %D%
 *
 * Copyright (c) 2006, Oracle and/or its affiliates. All rights reserved.
 * ORACLE PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 *
 */

package com.sun.jmx.snmp.daemon;

import java.util.Vector;
import java.io.Serializable;

// import debug stuff
//
import com.sun.jmx.trace.Trace;

/**
 * This class implements a server queue manager.
 * This class is for internal use.
 */

final class SnmpQManager implements Serializable {

    // VARIABLES
    //----------
        
    private SendQ  newq ;
    private WaitQ  waitq ;

    private ThreadGroup queueThreadGroup = null ;
    private Thread requestQThread = null ;
    private Thread timerQThread = null ;

    static String dbgTag = "SnmpQManager";
    
    
    // CONSTRUCTORS
    //-------------
    
    SnmpQManager() {
        newq = new SendQ(20, 5) ;
        waitq = new WaitQ(20, 5) ;

        queueThreadGroup = new ThreadGroup("Qmanager Thread Group") ;
    
        // TIME BOMB HERE
        startQThreads() ;
    }
    
    public void startQThreads() {
        if (timerQThread == null || timerQThread.isAlive() == false) {
            timerQThread   = new SnmpTimerServer(queueThreadGroup, this) ;
        }
        if (requestQThread == null || requestQThread.isAlive() == false) {
            requestQThread = new SnmpSendServer(queueThreadGroup, this) ;
        }
    }

    public void stopQThreads() {
        
        ((SnmpTimerServer)timerQThread).isBeingDestroyed = true;
        waitq.isBeingDestroyed = true;
        ((SnmpSendServer)requestQThread).isBeingDestroyed = true;
        newq.isBeingDestroyed = true;
        
        if (timerQThread != null && timerQThread.isAlive() == true) {   
            ((SnmpTimerServer)timerQThread).stopTimerServer();
        }
        waitq = null;
        timerQThread = null;
        
        if (requestQThread != null && requestQThread.isAlive() == true) {            
            ((SnmpSendServer)requestQThread).stopSendServer();
        }
        newq = null;
        requestQThread = null;
    }
    
    public void addRequest(SnmpInformRequest reqc) {
        newq.addRequest(reqc) ;
        return ;
    }

    public void addWaiting(SnmpInformRequest reqc) {
        waitq.addWaiting(reqc) ;
        return ;
    }

    public Vector getAllOutstandingRequest(long range) {
        return newq.getAllOutstandingRequest(range) ;
    }

    public SnmpInformRequest getTimeoutRequests() {
        return waitq.getTimeoutRequests() ;
    }

    public void removeRequest(SnmpInformRequest reqc) {
        newq.removeElement(reqc) ;
        waitq.removeElement(reqc) ;
    }

    public SnmpInformRequest removeRequest(long reqid) {
        SnmpInformRequest reqc = null ;

        if ((reqc = newq.removeRequest(reqid)) == null) 
            reqc = waitq.removeRequest(reqid) ;
	
        return reqc ;
    }

    // TRACES & DEBUG
    //---------------
    
    static boolean isTraceOn() {
        return Trace.isSelected(Trace.LEVEL_TRACE, Trace.INFO_ADAPTOR_SNMP);
    }

    static void trace(String clz, String func, String info) {
        Trace.send(Trace.LEVEL_TRACE, Trace.INFO_ADAPTOR_SNMP, clz, func, info);
    }

    static void trace(String func, String info) {
        SnmpQManager.trace(dbgTag, func, info);
    }
    
    static boolean isDebugOn() {
        return Trace.isSelected(Trace.LEVEL_DEBUG, Trace.INFO_ADAPTOR_SNMP);
    }

    static void debug(String clz, String func, String info) {
        Trace.send(Trace.LEVEL_DEBUG, Trace.INFO_ADAPTOR_SNMP, clz, func, info);
    }

    static void debug(String clz, String func, Throwable exception) {
        Trace.send(Trace.LEVEL_DEBUG, Trace.INFO_ADAPTOR_SNMP, clz, func, exception);
    }
    
    static void debug(String func, String info) {
        SnmpQManager.debug(dbgTag, func, info);
    }
    
    static void debug(String func, Throwable exception) {
        SnmpQManager.debug(dbgTag, func, exception);
    }
    
}

/**
 * This vector manages the inform requests to be sent to the manager.
 */
class SendQ extends Vector {
    
    SendQ(int initialCapacity, int capacityIncr) {
        super(initialCapacity , capacityIncr) ;
    }

    private synchronized void notifyClients() {
        this.notifyAll() ;
    }

    public synchronized void addRequest(SnmpInformRequest req) {
                
        long nextPoll = req.getAbsNextPollTime() ;

        int i ;
        for (i = size() ; i > 0 ; i--) {
            if (nextPoll < getRequestAt(i-1).getAbsNextPollTime())
                break ;
        }
        if (i == size()) {
            addElement(req) ;
            notifyClients() ;
        } else
            insertElementAt(req, i) ;
        return ;
    }

    public synchronized boolean waitUntilReady() {
        while (true) {
            if (isBeingDestroyed == true)
                return false;
            long tmp = 0 ;
            if (isEmpty() == false) {
                long currTime = System.currentTimeMillis() ;
                SnmpInformRequest req = (SnmpInformRequest) lastElement() ;
                tmp = req.getAbsNextPollTime() - currTime ;
                if (tmp <= 0) {
                    return true ;
                }
            }
            waitOnThisQueue(tmp) ;
        }
    }

    public synchronized Vector getAllOutstandingRequest(long margin) {
        int i ;
        Vector outreq = new Vector() ;
        while (true) {
            if (waitUntilReady() == true) {
                long refTime = System.currentTimeMillis() + margin ;

                for (i = size() ; i > 0 ; i--) {
                    SnmpInformRequest req = getRequestAt(i-1) ;
                    if (req.getAbsNextPollTime() > refTime) 
                        break ;
                    outreq.addElement(req) ;
                }
			
                if (! outreq.isEmpty()) {
                    elementCount -= outreq.size() ;
                    return outreq ;
                }
            }
            else
                return null;
        }
    }

    public synchronized void waitOnThisQueue(long time) {
        if (time == 0 && !isEmpty()) {
            if (SnmpQManager.isDebugOn()) {
                SnmpQManager.debug("waitOnThisQueue", "[" + Thread.currentThread().toString() + "]:" +
                                   "Fatal BUG :: Blocking on newq permenantly. But size = " + size());
            }
        }

        try {
            this.wait(time) ;
        } catch (InterruptedException e) {
        }
    }

    public SnmpInformRequest getRequestAt(int idx) {
        return (SnmpInformRequest)elementAt(idx) ;
    }
    
    public synchronized SnmpInformRequest removeRequest(long reqid) {
        int max= size() ;
        for (int i = 0 ; i < max ; i++) {
            SnmpInformRequest reqc = getRequestAt(i) ;
            if (reqid == reqc.getRequestId()) {
                removeElementAt(i) ;
                return reqc ;
            }
        }
        return null ;
    }

    // This boolean is used to stop handling requests while the corresponding SnmpQManager
    // is being destroyed.
    //
    boolean isBeingDestroyed = false;
}

/**
 * This vector manages the inform requests to be retried to the manager.
 */
class WaitQ extends Vector {
    
    WaitQ(int initialCapacity, int capacityIncr) {
        super(initialCapacity , capacityIncr) ;
    }

    public synchronized void addWaiting(SnmpInformRequest req) {
        
        long waitTime = req.getAbsMaxTimeToWait() ;
        int i ;
        for (i = size() ; i > 0 ; i--) {
            if (waitTime < getRequestAt(i-1).getAbsMaxTimeToWait())
                break ;
        }
        if (i == size()) {
            addElement(req) ;
            notifyClients() ;
        } else
            insertElementAt(req, i) ;
        return ;
    }

    public synchronized boolean waitUntilReady() {
        while (true) {
            if (isBeingDestroyed == true)
                return false;
            long tmp = 0 ;
            if (isEmpty() == false) {
                long currTime = System.currentTimeMillis() ;
                SnmpInformRequest req = (SnmpInformRequest) lastElement() ;
                tmp = req.getAbsMaxTimeToWait() - currTime ;
                if (tmp <= 0) {
                    return true ;
                }
            }
            waitOnThisQueue(tmp) ;
        }
    }

    public synchronized SnmpInformRequest getTimeoutRequests() {
        if (waitUntilReady() == true) {
            SnmpInformRequest req = (SnmpInformRequest) lastElement() ;
            elementCount-- ;
            return req ;
        }
        else {
            return null;
        }
    }

    private synchronized void notifyClients() {
        this.notifyAll() ;
    }

    public synchronized void waitOnThisQueue(long time) {
        if (time == 0 && !isEmpty()) {
            if (SnmpQManager.isDebugOn()) {
                SnmpQManager.debug("waitOnThisQueue", "[" + Thread.currentThread().toString() + "]:" +
                                   "Fatal BUG :: Blocking on waitq permenantly. But size = " + size());
            }
        }
				
        try {
            this.wait(time) ;
        } catch (InterruptedException e) {
        }
    }

    public SnmpInformRequest getRequestAt(int idx) {
        return (SnmpInformRequest)elementAt(idx) ;
    }

    public synchronized SnmpInformRequest removeRequest(long reqid) {
        int max= size();
        for (int i = 0 ; i < max ; i++) {
            SnmpInformRequest reqc = getRequestAt(i) ;
            if (reqid == reqc.getRequestId()) {
                removeElementAt(i) ;
                return reqc ;
            }
        }
        return null ;
    }

    // This boolean is used to stop handling requests while the corresponding SnmpQManager
    // is being destroyed.
    //
    boolean isBeingDestroyed = false;
}
