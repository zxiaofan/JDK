/*
 * Copyright (c) 2017, 2019, Oracle and/or its affiliates. All rights reserved.
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

package java.lang;

/**
 * Thrown to indicate that a method has been called by an inappropriate caller.
 *
 * @since 9
 * @see StackWalker#getCallerClass
 */
public class IllegalCallerException extends RuntimeException {
    /**
     * Constructs an IllegalCallerException with no detail message.
     */
    public IllegalCallerException() {
        super();
    }

    /**
     * Constructs an IllegalCallerException with the specified detail
     * message.
     *
     * @param s the String that contains a detailed message (can be null)
     */
    public IllegalCallerException(String s) {
        super(s);
    }

    /**
     * Constructs a new exception with the specified detail message and
     * cause.
     *
     * @param  message the detail message (can be null)
     * @param  cause the cause (can be null)
     */
    public IllegalCallerException(String message, Throwable cause) {
        super(message, cause);
    }

    /**
     * Constructs a new exception with the specified cause and a detail
     * message of {@code (cause==null ? null : cause.toString())} (which
     * typically contains the class and detail message of {@code cause}).
     *
     * @param  cause the cause (can be null)
     */
    public IllegalCallerException(Throwable cause) {
        super(cause);
    }

    @java.io.Serial
    static final long serialVersionUID = -2349421918363102232L;
}
