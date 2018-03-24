/*
 * Copyright (c) 2009, 2013, Oracle and/or its affiliates. All rights reserved.
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
package com.sun.nio.sctp;

/**
 * Unchecked exception thrown when an attempt is made to invoke the
 * {@code receive} method of {@link SctpChannel} or {@link SctpMultiChannel}
 * from a notification handler.
 *
 * @since 1.7
 */
public class IllegalReceiveException extends IllegalStateException {
    private static final long serialVersionUID = 2296619040988576224L;

    /**
     * Constructs an instance of this class.
     */
    public IllegalReceiveException() { }

    /**
     * Constructs an instance of this class with the specified message.
     *
     * @param  msg
     *         The String that contains a detailed message
     */
    public IllegalReceiveException(String msg) {
        super(msg);
    }
}

