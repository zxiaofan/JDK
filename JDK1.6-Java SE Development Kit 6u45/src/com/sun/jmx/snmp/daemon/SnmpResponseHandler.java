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

// JAVA imports
//
import java.net.DatagramPacket;

// JMX imports
//
import com.sun.jmx.snmp.SnmpMessage;
import com.sun.jmx.snmp.SnmpPduFactory;
import com.sun.jmx.snmp.SnmpPduPacket;
import com.sun.jmx.snmp.SnmpPduRequest;

// SNMP Runtime imports
//
import com.sun.jmx.trace.Trace;

/**
 * This class is used to handle received inform request responses.
 * This classes parses the SNMP inform response packet to obtain the corresponding inform request.
 */

class SnmpResponseHandler {
    
    // VARIABLES
    //----------
    
    SnmpAdaptorServer adaptor = null;
    SnmpQManager snmpq = null;

    // CONSTRUCTORS
    //-------------
    
    public SnmpResponseHandler(SnmpAdaptorServer adp, SnmpQManager s) {
        adaptor = adp;
        snmpq = s;
    }

    // PUBLIC METHODS
    //---------------
    
    public synchronized void processDatagram(DatagramPacket dgrm) {
        
        byte []data = dgrm.getData();
        int datalen = dgrm.getLength();
        
        if (isTraceOn()) {
            trace("processDatagram", "Received from " + dgrm.getAddress().toString() + " Length = " + datalen +
                  "\nDump : \n" + SnmpMessage.dumpHexBuffer(data, 0, datalen));
        }
	
        try {
            SnmpMessage msg = new SnmpMessage();
            msg.decodeMessage(data, datalen);
            msg.address = dgrm.getAddress();
            msg.port = dgrm.getPort();
            
            // Retreive the PDU factory of the SNMP adaptor to decode the received inform response.
            //
            SnmpPduFactory pduFactory = adaptor.getPduFactory();
            if (pduFactory == null) {
                if (isDebugOn()) {
                    debug("processDatagram", "Dropping packet. Unable to find the pdu factory of the SNMP adaptor server");
                }
            }
            else {
                SnmpPduPacket snmpProt = (SnmpPduPacket)pduFactory.decodeSnmpPdu(msg);
                
                if (snmpProt == null) {
                    if (isDebugOn()) {
                        debug("processDatagram", "Dropping packet. Pdu factory returned a null value");
                    }
                }
                else if (snmpProt instanceof SnmpPduRequest) {
                    
                    SnmpPduRequest pduReq = (SnmpPduRequest)snmpProt;
                    SnmpInformRequest req = snmpq.removeRequest(pduReq.requestId) ;
                    if (req != null) {
                        req.invokeOnResponse(pduReq);
                    } else {
                        if (isDebugOn()) {
                            debug("processDatagram", "Dropping packet. Unable to find corresponding for InformRequestId = " + pduReq.requestId);
                        }
                    }
                }
                else {
                    if (isDebugOn()) {
                        debug("processDatagram", "Dropping packet. The packet does not contain an inform response");
                    }
                }
                snmpProt = null ;
            }
        } catch (Exception e) {
            if (isDebugOn()) {
                debug("processDatagram", "Exception while processsing");
                debug("processDatagram", e);
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

    String dbgTag = "SnmpResponseHandler";
}
