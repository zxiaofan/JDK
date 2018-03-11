/*
 * %Z%file      %M%
 * %Z%author    Sun Microsystems, Inc.
 * %Z%version   %I%
 * %Z%lastedit      %E%
 *
 * Copyright (c) 2006, Oracle and/or its affiliates. All rights reserved.
 * ORACLE PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 *
 */


package com.sun.jmx.snmp.daemon;



// java import
//
import java.io.*;

// jmx import
//
import javax.management.MBeanServer;
import javax.management.ObjectName;

// jmx RI import
//
import com.sun.jmx.trace.Trace;

/**
 * The <CODE>ClientHandler</CODE> class is the base class of each
 * adaptor.<p>
 */

abstract class ClientHandler implements Runnable {

    public ClientHandler(CommunicatorServer server, int id, MBeanServer f, ObjectName n) {
        adaptorServer = server ;
        requestId = id ;
        mbs = f ;
        objectName = n ;
        interruptCalled = false ;
        dbgTag = makeDebugTag() ;
	//if (mbs == null ){
	//thread = new Thread (this) ;
	thread =  createThread(this);

	//} else {
	//thread = mbs.getThreadAllocatorSrvIf().obtainThread(objectName,this) ;
	//}
        // Note: the thread will be started by the subclass.
    }

    // thread service
    Thread createThread(Runnable r) {
	return new Thread(this);
    }

    public void interrupt() {
        if (isTraceOn()) {
            trace("interrupt","start") ;
        }
        interruptCalled = true ;
	if (thread != null) {
            thread.interrupt() ;
	}
        if (isTraceOn()) {
            trace("interrupt","end") ;
        }
    }
  
  
    public void join() {
	if (thread != null) {
        try {
            thread.join() ;
        }
        catch(InterruptedException x) {
        }
	}
    }
  
    public void run() {

        try {
            //
            // Notify the server we are now active
            //
            adaptorServer.notifyClientHandlerCreated(this) ;

            //
            // Call protocol specific sequence
            //
            doRun() ;
        }
        finally {
            //
            // Now notify the adaptor server that the handler is terminating.
            // This is important because the server may be blocked waiting for
            // a handler to terminate.
            //
            adaptorServer.notifyClientHandlerDeleted(this) ;
        }
    }  
  
    //
    // The protocol-dependent part of the request
    //
    public abstract void doRun() ;  
  
    protected CommunicatorServer adaptorServer = null ;
    protected int requestId = -1 ;
    protected MBeanServer mbs = null ;
    protected ObjectName objectName = null ;
    protected Thread thread = null ;
    protected boolean interruptCalled = false ;
    protected String dbgTag = null ;

    protected boolean isTraceOn() {
        return Trace.isSelected(Trace.LEVEL_TRACE, Trace.INFO_ADAPTOR_SNMP);
    }

    protected void trace(String clz, String func, String info) {
        Trace.send(Trace.LEVEL_TRACE, Trace.INFO_ADAPTOR_SNMP, clz, func, info);
    }

    protected boolean isDebugOn() {
        return Trace.isSelected(Trace.LEVEL_DEBUG, Trace.INFO_ADAPTOR_SNMP);
    }

    protected void debug(String clz, String func, String info) {
        Trace.send(Trace.LEVEL_DEBUG, Trace.INFO_ADAPTOR_SNMP, clz, func, info);
    }

    protected void trace(String func, String info) {
        trace(dbgTag, func, info);
    }

    protected void debug(String func, String info) {
        debug(dbgTag, func, info);
    }

    protected String makeDebugTag() {
        return "ClientHandler[" + adaptorServer.getProtocol() + ":" + adaptorServer.getPort() + "][" + requestId + "]";
    }
}
