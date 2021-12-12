/*
 * Copyright (c) 1995, 2020, Oracle and/or its affiliates. All rights reserved.
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
 * Thrown by the security manager to indicate a security violation.
 *
 * @see     java.lang.SecurityManager
 * @since   1.0
 */
public class SecurityException extends RuntimeException {

    @java.io.Serial
    private static final long serialVersionUID = 6878364983674394167L;

    /**
     * Constructs a {@code SecurityException} with no detail message.
     */
    public SecurityException() {
        super();
    }

    /**
     * Constructs a {@code SecurityException} with the specified
     * detail message.
     *
     * @param   s   the detail message.
     */
    public SecurityException(String s) {
        super(s);
    }

    /**
     * Creates a {@code SecurityException} with the specified
     * detail message and cause.
     *
     * @param message the detail message (which is saved for later retrieval
     *        by the {@link #getMessage()} method).
     * @param cause the cause (which is saved for later retrieval by the
     *        {@link #getCause()} method).  (A {@code null} value is permitted,
     *        and indicates that the cause is nonexistent or unknown.)
     * @since 1.5
     */
    public SecurityException(String message, Throwable cause) {
        super(message, cause);
    }

    /**
     * Creates a {@code SecurityException} with the specified cause
     * and a detail message of {@code (cause==null ? null : cause.toString())}
     * (which typically contains the class and detail message of
     * {@code cause}).
     *
     * @param cause the cause (which is saved for later retrieval by the
     *        {@link #getCause()} method).  (A {@code null} value is permitted,
     *        and indicates that the cause is nonexistent or unknown.)
     * @since 1.5
     */
    public SecurityException(Throwable cause) {
        super(cause);
    }
}
