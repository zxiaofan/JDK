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


package com.sun.jmx.snmp;



/**
 * Represents a <CODE>get-bulk</CODE> PDU as defined in RFC 1448.
 * <P>
 * You will not usually need to use this class, except if you
 * decide to implement your own 
 * {@link com.sun.jmx.snmp.SnmpPduFactory SnmpPduFactory} object.
 * <P>
 * The <CODE>SnmpPduBulk</CODE> extends {@link com.sun.jmx.snmp.SnmpPduPacket SnmpPduPacket}
 * and defines attributes specific to the <CODE>get-bulk</CODE> PDU (see RFC 1448).
 *
 * <p><b>This API is a Sun Microsystems internal API  and is subject 
 * to change without notice.</b></p>
 */

public class SnmpPduBulk extends SnmpPduPacket 
    implements SnmpPduBulkType {

    /**
     * The <CODE>non-repeaters</CODE> value.
     * @serial
     */
    public int            nonRepeaters ;
  

    /**
     * The <CODE>max-repetitions</CODE> value.
     * @serial
     */
    public int            maxRepetitions ;


    /**
     * Builds a new <CODE>get-bulk</CODE> PDU.
     * <BR><CODE>type</CODE> and <CODE>version</CODE> fields are initialized with
     * {@link com.sun.jmx.snmp.SnmpDefinitions#pduGetBulkRequestPdu pduGetBulkRequestPdu}
     * and {@link com.sun.jmx.snmp.SnmpDefinitions#snmpVersionTwo snmpVersionTwo}.
     */
    public SnmpPduBulk() {
  	type = pduGetBulkRequestPdu ;
	version = snmpVersionTwo ;
    }
    /**
     * Implements the <CODE>SnmpPduBulkType</CODE> interface.
     *
     * @since 1.5
     */
    public void setMaxRepetitions(int i) { 
	maxRepetitions = i;
    }
    /**
     * Implements the <CODE>SnmpPduBulkType</CODE> interface.
     *
     * @since 1.5
     */
    public void setNonRepeaters(int i) {
	nonRepeaters = i;
    }
    /**
     * Implements the <CODE>SnmpPduBulkType</CODE> interface.
     *
     * @since 1.5
     */
    public int getMaxRepetitions() { return maxRepetitions; }
    /**
     * Implements the <CODE>SnmpPduBulkType</CODE> interface.
     *
     * @since 1.5
     */
    public int getNonRepeaters() { return nonRepeaters; }
    /**
     * Implements the <CODE>SnmpAckPdu</CODE> interface.
     *
     * @since 1.5
     */
    public SnmpPdu getResponsePdu() {
	SnmpPduRequest result = new SnmpPduRequest();
	result.address = address;
	result.port = port;
	result.version = version;
	result.community = community;
	result.type = SnmpDefinitions.pduGetResponsePdu;
	result.requestId = requestId;
	result.errorStatus = SnmpDefinitions.snmpRspNoError;
	result.errorIndex = 0;
	
 	return result;
    }
}




