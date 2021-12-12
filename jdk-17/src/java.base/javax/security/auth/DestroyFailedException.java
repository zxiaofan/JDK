/*
 * Copyright (c) 1999, 2019, Oracle and/or its affiliates. All rights reserved.
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

package javax.security.auth;

/**
 * Signals that a {@code destroy} operation failed.
 *
 * <p> This exception is thrown by credentials implementing
 * the {@code Destroyable} interface when the {@code destroy}
 * method fails.
 *
 * @since 1.4
 */
public class DestroyFailedException extends Exception {

    @java.io.Serial
    private static final long serialVersionUID = -7790152857282749162L;

    /**
     * Constructs a DestroyFailedException with no detail message. A detail
     * message is a String that describes this particular exception.
     */
    public DestroyFailedException() {
        super();
    }

    /**
     * Constructs a DestroyFailedException with the specified detail
     * message.  A detail message is a String that describes this particular
     * exception.
     *
     * @param msg the detail message.
     */
    public DestroyFailedException(String msg) {
        super(msg);
    }
}
