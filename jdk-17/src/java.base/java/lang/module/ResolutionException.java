/*
 * Copyright (c) 2014, 2019, Oracle and/or its affiliates. All rights reserved.
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

package java.lang.module;

/**
 * Thrown when resolving a set of modules, or resolving a set of modules with
 * service binding, fails.
 *
 * @see Configuration
 * @since 9
 */
public class ResolutionException extends RuntimeException {
    @java.io.Serial
    private static final long serialVersionUID = -1031186845316729450L;

    /**
     * Constructs a {@code ResolutionException} with no detail message.
     */
    public ResolutionException() { }

    /**
     * Constructs a {@code ResolutionException} with the given detail
     * message.
     *
     * @param msg
     *        The detail message; can be {@code null}
     */
    public ResolutionException(String msg) {
        super(msg);
    }

    /**
     * Constructs an instance of this exception with the given cause.
     *
     * @param cause
     *        The cause; can be {@code null}
     */
    public ResolutionException(Throwable cause) {
        super(cause);
    }

    /**
     * Constructs a {@code ResolutionException} with the given detail message
     * and cause.
     *
     * @param msg
     *        The detail message; can be {@code null}
     * @param cause
     *        The cause; can be {@code null}
     */
    public ResolutionException(String msg, Throwable cause) {
        super(msg, cause);
    }

}
