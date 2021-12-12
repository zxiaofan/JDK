/*
 * Copyright (c) 2004, 2019, Oracle and/or its affiliates. All rights reserved.
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

package sun.security.util;

/**
 * An exception that denotes that an operation is pending.
 * Currently used by LoginContext.
 *
 */
public class PendingException extends RuntimeException {

    @java.io.Serial
    private static final long serialVersionUID = -5201837247928788640L;

    /**
     * Constructs a PendingException with no detail message. A detail
     * message is a String that describes this particular exception.
     */
    public PendingException() {
        super();
    }

    /**
     * Constructs a PendingException with the specified detail message.
     * A detail message is a String that describes this particular
     * exception.
     *
     * @param msg the detail message.
     */
    public PendingException(String msg) {
        super(msg);
    }
}
