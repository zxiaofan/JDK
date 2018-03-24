/*
 * Copyright (c) 1997, 2013, Oracle and/or its affiliates. All rights reserved.
 * ORACLE PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 */

package com.sun.xml.internal.ws.spi.db;

/**
 * Signals an error in Databinding.
 *
 * @author shih-chang.chen@oracle.com
 */
public class DatabindingException extends RuntimeException {
        public DatabindingException() {}
    public DatabindingException(String message) { super(message); }
    public DatabindingException(Throwable cause) { super(cause); }
    public DatabindingException(String message, Throwable cause) { super(message, cause); }
}
