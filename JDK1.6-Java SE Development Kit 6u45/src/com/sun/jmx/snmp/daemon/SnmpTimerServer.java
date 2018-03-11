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

// import debug stuff
//
import com.sun.jmx.trace.Trace;

/**
 * This class retries any timed out inform requests. This class is for internal use.
 */

final class SnmpTimerServer extends Thread {

	// VARIABLES
    //----------
    
    private SnmpInformRequest req = null ;
	
    SnmpQManager snmpq = null ;
    String dbgTag = "SnmpTimerServer";
    
    // This boolean is used to stop handling requests while the corresponding SnmpQManager
    // is being destroyed.
    //
    boolean isBeingDestroyed = false;
    
    // CONSTRUCTORS
    //-------------
    
    public SnmpTimerServer (ThreadGroup grp, SnmpQManager q) {
        super(grp, "SnmpTimerServer") ;
        setName(dbgTag) ;
        snmpq = q ;
        start() ;
    }

    public synchronized void stopTimerServer() {
                
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
    
    public void run() {
        Thread.currentThread().setPriority(Thread.NORM_PRIORITY);
        
        if (isTraceOn()) {
            trace("run", "Timer Thread started");
        }

        while (true) {
                        
            try {
                if (isTraceOn()) {
                    trace("run", "Blocking for inform requests");
                }
                if (req == null) {
                    req = snmpq.getTimeoutRequests() ;
                }
                if (req != null && req.inProgress()) {
                    if (isTraceOn()) {
                        trace("run", "Handle timeout inform request " + req.getRequestId());
                    }
                    req.action() ;
                    req = null ;
                }
                if (isBeingDestroyed == true)
                    break;
            } catch (Exception e) {
                if (isDebugOn()) {
                    debug("run", e.getMessage());
                }
            } catch (ThreadDeath d) {
                if (isDebugOn()) {
                    debug("run", "Timer server unexpectedly shutting down");
                    debug("run", d);
                }
                throw d ;
            } catch (OutOfMemoryError ome) {
                if (isDebugOn()) {
                    debug("run", "Received OutOfMemory");
                }
                yield();
            } catch (Error err) {
                if (isDebugOn()) {
                    debug("run", "Received Internal error");
                    debug("run", err);
                }
            }
        }
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
