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

package com.sun.xml.internal.ws.api.model;
/**
 * Type of java exception as defined by JAXWS 2.0 JSR 224.
 *
 * Tells whether the exception class is a userdefined or a WSDL exception.
 * A WSDL exception class follows the pattern defined in JSR 224. According to that
 * a WSDL exception class must have:
 *
 * <code>public WrapperException()String message, FaultBean){}</code>
 *
 * and accessor method
 *
 * <code>public FaultBean getFaultInfo();</code>
 *
 * @author Vivek Pandey
 */
public enum ExceptionType {
    WSDLException(0), UserDefined(1);

    ExceptionType(int exceptionType){
        this.exceptionType = exceptionType;
    }

    public int value() {
        return exceptionType;
    }
    private final int exceptionType;
}
