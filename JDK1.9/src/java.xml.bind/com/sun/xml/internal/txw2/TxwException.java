/*
 * Copyright (c) 2005, 2012, Oracle and/or its affiliates. All rights reserved.
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

package com.sun.xml.internal.txw2;

/**
 * Signals errors in the TXW processing.
 */
public class TxwException extends RuntimeException {
    public TxwException(String message) {
        super(message);
    }

    public TxwException(Throwable cause) {
        super(cause);
    }

    public TxwException(String message, Throwable cause) {
        super(message, cause);
    }

    private static final long serialVersionUID = 1L;
}
