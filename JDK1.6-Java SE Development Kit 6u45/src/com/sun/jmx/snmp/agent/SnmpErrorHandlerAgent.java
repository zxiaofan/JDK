/*
 * @(#)file      SnmpProxyMBean.java
 * @(#)author    Sun Microsystems, Inc.
 * @(#)version   X.XX
 * @(#)date      XX/XX/XX
 *
 * Copyright (c) 2006, Oracle and/or its affiliates. All rights reserved.
 * ORACLE PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 *
 */

package com.sun.jmx.snmp.agent;


// java imports
//
import java.io.Serializable;
import java.util.Enumeration;

// jmx imports
//
import com.sun.jmx.snmp.SnmpStatusException;
import com.sun.jmx.snmp.SnmpDefinitions;
import javax.management.ObjectName;
import javax.management.MBeanServer;
import com.sun.jmx.snmp.SnmpVarBind;

// SNMP Runtime imports
//
import com.sun.jmx.trace.Trace;

/**
 * A simple MIB agent that implements SNMP calls (get, set, getnext and getbulk) in a way that only errors or exceptions are returned. Every call done on this agent fails. Error handling is done according to the manager's SNMP protocol version.
 * <P>It is used by <CODE>SnmpAdaptorServer</CODE> for its default agent behavior. When a received Oid doesn't match, this agent is called to fill the result list with errors.</P>
 * <p><b>This API is a Sun Microsystems internal API  and is subject 
 * to change without notice.</b></p>
 * @since 1.5
 * 
 */

public class SnmpErrorHandlerAgent extends SnmpMibAgent
implements Serializable {

  public SnmpErrorHandlerAgent() {}

    /**
     * Initializes the MIB (with no registration of the MBeans into the 
     * MBean server). Does nothing.
     *
     * @exception IllegalAccessException The MIB cannot be initialized.
     */
    
  public void init() throws IllegalAccessException {
  }

    /**
     * Initializes the MIB but each single MBean representing the MIB 
     * is inserted into the MBean server.
     *
     * @param server The MBean server to register the service with.
     * @param name The object name.
     *
     * @return The passed name paramter.
     *
     * @exception java.lang.Exception
     */

  public ObjectName preRegister(MBeanServer server, ObjectName name) 
    throws Exception {
        return name;
    }
  
    /**
     * Gets the root object identifier of the MIB.
     * <P>The root object identifier is the object identifier uniquely 
     * identifying the MIB.
     *
     * @return The returned oid is null.
     */

  public long[] getRootOid() {
    return null;
  }
  
    /**
     * Processes a <CODE>get</CODE> operation. It will throw an exception for V1 requests or it will set exceptions within the list for V2 requests.
     * 
     * @param inRequest The SnmpMibRequest object holding the list of variable to be retrieved.
     *
     * @exception SnmpStatusException An error occured during the operation.
     */

  public void get(SnmpMibRequest inRequest) throws SnmpStatusException {
    
    if(isDebugOn()) trace("get","Get in Exception");
    
    if(inRequest.getVersion() == SnmpDefinitions.snmpVersionOne)
      throw new SnmpStatusException(SnmpStatusException.noSuchName);
    
    Enumeration l = inRequest.getElements();
    while(l.hasMoreElements()) {
      SnmpVarBind varbind = (SnmpVarBind) l.nextElement(); 
      varbind.setNoSuchObject();
    }
  }

    /**
     * Checks if a <CODE>set</CODE> operation can be performed.
     * If the operation can not be performed, the method should emit a
     * <CODE>SnmpStatusException</CODE>.
     * 
     * @param inRequest The SnmpMibRequest object holding the list of variables to
     *            be set. This list is composed of 
     *            <CODE>SnmpVarBind</CODE> objects.
     *
     * @exception SnmpStatusException The <CODE>set</CODE> operation 
     *    cannot be performed.
     */

  public void check(SnmpMibRequest inRequest) throws SnmpStatusException {

    if(isDebugOn()) trace("check","Check in Exception");

    throw new SnmpStatusException(SnmpDefinitions.snmpRspNotWritable);
  }

    /**
     * Processes a <CODE>set</CODE> operation. Should never be called (check previously called having failed).
     * 
     * @param inRequest The SnmpMibRequest object holding the list of variable to be set.
     *
     * @exception SnmpStatusException An error occured during the operation.
     */

  public void set(SnmpMibRequest inRequest) throws SnmpStatusException {

      if(isDebugOn()) trace("set","Set in Exception, CAN't be called");
      
    throw new SnmpStatusException(SnmpDefinitions.snmpRspNotWritable);
  }

    /**
     * Processes a <CODE>getNext</CODE> operation. It will throw an exception for V1 requests or it will set exceptions within the list for V2 requests..
     * 
     * @param inRequest The SnmpMibRequest object holding the list of variables to be retrieved.
     *
     * @exception SnmpStatusException An error occured during the operation.
     */

  public void getNext(SnmpMibRequest inRequest) throws SnmpStatusException {
    
      if(isDebugOn()) trace("getNext","GetNext in Exception");

    if(inRequest.getVersion() == SnmpDefinitions.snmpVersionOne)
      throw new SnmpStatusException(SnmpStatusException.noSuchName);
    
    Enumeration l = inRequest.getElements();
    while(l.hasMoreElements()) {
      SnmpVarBind varbind = (SnmpVarBind) l.nextElement(); 
      varbind.setEndOfMibView();
    }
  }
  
    /**
     * Processes a <CODE>getBulk</CODE> operation. It will throw an exception if the request is a V1 one or it will set exceptions within the list for V2 ones.
     * 
     * @param inRequest The SnmpMibRequest object holding the list of variable to be retrieved.
     *
     * @exception SnmpStatusException An error occured during the operation.
     */
    
  public void getBulk(SnmpMibRequest inRequest, int nonRepeat, int maxRepeat) 
    throws SnmpStatusException {
      
      if(isDebugOn()) trace("getBulk","GetBulk in Exception");
 
      if(inRequest.getVersion() == SnmpDefinitions.snmpVersionOne) 
	throw new SnmpStatusException(SnmpDefinitions.snmpRspGenErr, 0);
      
      Enumeration l = inRequest.getElements();
      while(l.hasMoreElements()) {
	SnmpVarBind varbind = (SnmpVarBind) l.nextElement(); 
	varbind.setEndOfMibView();
      }
    }
    
    private boolean isDebugOn() {
        return Trace.isSelected(Trace.LEVEL_DEBUG, Trace.INFO_ADAPTOR_SNMP);
    }
    
    private void debug(String clz, String func, String info) {
        Trace.send(Trace.LEVEL_TRACE, Trace.INFO_ADAPTOR_SNMP, clz, func, info);
    }
    
    private void trace(String func, String info) {
        debug(dbgTag, func, info);
    }

    private String dbgTag = "SnmpErrorHandlerAgent";
}


