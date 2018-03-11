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

import java.util.Enumeration;
import java.util.Vector;

// import debug stuff
//
import com.sun.jmx.trace.Trace;

/**
 * This class starts a thread which picks up a session from the queue
 * and prepares the inform request protocol data unit (PDU) packet and sends
 * it to the manager. The request is then added to the wait queue and
 * marked as one that is waiting for a response.
 */

final class SnmpSendServer extends Thread {
	
	// VARIABLES
    //----------
    
	private int intervalRange = 5 * 1000 ;
	private Vector readyPool ;

    SnmpQManager snmpq = null ;
    String dbgTag = "SnmpSendServer";
    
    // This boolean is used to stop handling requests while the corresponding SnmpQManager
    // is being destroyed.
    //
    boolean isBeingDestroyed = false;
	
    // CONSTRUCTORS
    //-------------
	
    public SnmpSendServer(ThreadGroup grp, SnmpQManager q) {
		super(grp, "SnmpSendServer") ;
		snmpq = q ;
		start() ;
	}

    public synchronized void stopSendServer() {
        
        if (isAlive()) {
            interrupt();
            try {
                // Wait until the thread die.
                //
                join();
            } catch (InterruptedException e) {
                // Ignore...
            }
        }
    }
	
	public void run () {
        Thread.currentThread().setPriority(Thread.NORM_PRIORITY);
        
        if (isTraceOn()) {
            trace("run", "Thread Started");
        }

		while (true) {
			try {
				prepareAndSendRequest() ;
                if (isBeingDestroyed == true)
                    break;
            } catch (Exception anye) {
                if (isDebugOn()) {
                    debug("run", "Exception in send server");
                    debug("run", anye);
                }
			} catch (ThreadDeath td) {
				// This is not good but Netscape does kill all threads when 
				// the pagecontext changes.
                if (isDebugOn()) {
                    debug("run", "Exiting... Fatal error");
                }
				throw td ;
			} catch (OutOfMemoryError ome) {
                if (isDebugOn()) {
                    debug("run", "Out of memory");
                }			  
			} catch (Error err) {
                if (isDebugOn()) {
                    debug("run", err);
                }
				throw err ;
			}
		}
	}

    private void prepareAndSendRequest() {
												
        if (readyPool == null || readyPool.isEmpty()) {
            // wait to be signaled by the an active request.
            if (isTraceOn()) {
                trace("prepareAndSendRequest", "Blocking for inform requests");
            }			  
            readyPool = snmpq.getAllOutstandingRequest(intervalRange) ;
            if (isBeingDestroyed == true)
                return;
        } else {
            if (isDebugOn()) {
                debug("prepareAndSendRequest", "Inform requests from a previous block left unprocessed. Will try again");
            }			  
        }

        if (isTraceOn()) {
            trace("prepareAndSendRequest", "List of inform requests to send : " + reqListToString(readyPool));
        }			  
        
        synchronized(this) {
            if (readyPool.size() < 2) {
                // Fire all requests as independent requests.
                fireRequestList(readyPool) ;
                return ;
            }
        
            while (!readyPool.isEmpty()) {
                SnmpInformRequest req = (SnmpInformRequest) readyPool.lastElement() ;
                if (req != null && req.inProgress()) {
                    fireRequest(req) ;
                }
                readyPool.removeElementAt(readyPool.size() - 1) ;
            }
            readyPool.removeAllElements() ;
        }
    }

	/**
	 * This will fire the specified request.
	 */
	void fireRequest(SnmpInformRequest req) {
		if (req != null && req.inProgress())  {
            if (isTraceOn()) {
                trace("fireRequest", "Firing inform request directly. -> " + req.getRequestId());
            }			  
            req.action() ;
		}
	}

    void fireRequestList(Vector reqList) {
        // Fire all requests as independent requests.
        while (!reqList.isEmpty()) {
            SnmpInformRequest req = (SnmpInformRequest) reqList.lastElement() ;
            if (req != null && req.inProgress())
                fireRequest(req) ;
            reqList.removeElementAt(reqList.size() - 1) ;
        }
    }

	final String reqListToString(Vector vec) {
		StringBuffer s = new StringBuffer(vec.size() * 100) ;

		Enumeration dbge = vec.elements() ;
		while (dbge.hasMoreElements()) {
			SnmpInformRequest reqc = (SnmpInformRequest) dbge.nextElement() ;
            s.append("InformRequestId -> ") ;
			s.append(reqc.getRequestId()) ;
            s.append(" / Destination -> ") ;
			s.append(reqc.getAddress()) ;
            s.append(". ") ;
		}
		String str = s.toString() ;
		s = null ;
		return str ;
	}

    // TRACES & DEBUG
    //---------------
    
    boolean isTraceOn() {
        return Trace.isSelected(Trace.LEVEL_TRACE, Trace.INFO_ADAPTOR_SNMP);
    }

    void trace(String clz, String func, String info) {
        Trace.send(Trace.LEVEL_TRACE, Trace.INFO_ADAPTOR_SNMP, clz, func, info);
    }

    void trace(String func, String info) {
        trace(dbgTag, func, info);
    }
    
    boolean isDebugOn() {
        return Trace.isSelected(Trace.LEVEL_DEBUG, Trace.INFO_ADAPTOR_SNMP);
    }

    void debug(String clz, String func, String info) {
        Trace.send(Trace.LEVEL_DEBUG, Trace.INFO_ADAPTOR_SNMP, clz, func, info);
    }

    void debug(String clz, String func, Throwable exception) {
        Trace.send(Trace.LEVEL_DEBUG, Trace.INFO_ADAPTOR_SNMP, clz, func, exception);
    }

    void debug(String func, String info) {
        debug(dbgTag, func, info);
    }
    
    void debug(String func, Throwable exception) {
        debug(dbgTag, func, exception);
    }
}
