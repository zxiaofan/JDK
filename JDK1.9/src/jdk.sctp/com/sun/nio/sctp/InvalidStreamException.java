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
 * Unchecked exception thrown when an attempt is made to send a
 * message to an invalid stream.
 *
 * @since 1.7
 */
public class InvalidStreamException extends IllegalArgumentException {
    private static final long serialVersionUID = -9172703378046665558L;

    /**
     * Constructs an instance of this class.
     */
    public InvalidStreamException() { }

    /**
     * Constructs an instance of this class with the specified detailed message.
     *
     * @param  msg
     *         The String that contains a detailed message
     */
    public InvalidStreamException(String msg) {
        super(msg);
    }
}

