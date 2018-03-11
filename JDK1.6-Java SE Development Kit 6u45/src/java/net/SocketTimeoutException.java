/*
 * %W% %E%
 *
 * Copyright (c) 2006, Oracle and/or its affiliates. All rights reserved.
 * ORACLE PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

package java.net;

/**
 * Signals that a timeout has occurred on a socket read or accept.
 *
 * @since   1.4
 */

public class SocketTimeoutException extends java.io.InterruptedIOException {

    /**
     * Constructs a new SocketTimeoutException with a detail 
     * message.
     * @param msg the detail message
     */
    public SocketTimeoutException(String msg) {
	super(msg);
    }

    /**
     * Construct a new SocketTimeoutException with no detailed message.
     */
    public SocketTimeoutException() {}
}
