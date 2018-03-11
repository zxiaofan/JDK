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
 * This exception is thrown when an <CODE>SnmpLcd</CODE> has no ModelLcd associated to the model.
 * <p><b>This API is a Sun Microsystems internal API  and is subject 
 * to change without notice.</b></p>
 * @since 1.5
 */
public class SnmpUnknownModelLcdException extends Exception {
    /**
     * Constructor. 
     * @param msg The exception msg to display.
     */
    public SnmpUnknownModelLcdException(String msg) {
	super(msg);
    }
}
