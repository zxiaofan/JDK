/*
 * Copyright (c) 1999, 2017, Oracle and/or its affiliates. All rights reserved.
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

package com.sun.jdi;

/**
 * Thrown to indicate that an unexpected internal error has
 * occurred.
 *
 * @author Gordon Hirsch
 * @since  1.3
 */
public class InternalException extends RuntimeException {

    private static final long serialVersionUID = -9171606393104480607L;

    private int errorCode;

    public InternalException() {
        super();
        this.errorCode = 0;
    }

    public InternalException(String s) {
        super(s);
        this.errorCode = 0;
    }

    public InternalException(int errorCode) {
        super();
        this.errorCode = errorCode;
    }

    public InternalException(String s, int errorCode) {
        super(s);
        this.errorCode = errorCode;
    }

    public int errorCode() {
        return errorCode;
    }
}
