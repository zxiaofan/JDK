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
 * Exception thrown when a BER encoding/decoding error occurs.
 *
 * <p><b>This API is a Sun Microsystems internal API  and is subject 
 * to change without notice.</b></p>
 * @version     %I%     %G%
 * @author      Sun Microsystems, Inc
 *
 * @since 1.5
 */

public class BerException extends Exception {

  public static final int BAD_VERSION=1;

  private int errorType= 0;

  public BerException() {
    errorType= 0;
  }

  public BerException(int x) {
    errorType= x;
  }

  public boolean isInvalidSnmpVersion() {
    if (errorType == BAD_VERSION) 
      return true;
    else
      return false;
  }
}
