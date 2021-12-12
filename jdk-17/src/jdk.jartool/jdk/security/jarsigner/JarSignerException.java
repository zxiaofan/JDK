/*
 * Copyright (c) 2015, Oracle and/or its affiliates. All rights reserved.
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

package jdk.security.jarsigner;

/**
 * This exception is thrown when {@link JarSigner#sign} fails.
 *
 * @since 9
 */
public class JarSignerException extends RuntimeException {

    private static final long serialVersionUID = -4732217075689309530L;

    /**
     * Constructs a new {@code JarSignerException} with the specified detail
     * message and cause.
     * <p>
     * Note that the detail message associated with
     * {@code cause} is <i>not</i> automatically incorporated in
     * this {@code JarSignerException}'s detail message.
     *
     * @param message the detail message (which is saved for later retrieval
     *      by the {@link #getMessage()} method).
     * @param cause the cause (which is saved for later retrieval by the
     *      {@link #getCause()} method).  (A {@code null} value is permitted,
     *      and indicates that the cause is nonexistent or unknown.)
     */
    public JarSignerException(String message, Throwable cause) {
        super(message, cause);
    }
}

