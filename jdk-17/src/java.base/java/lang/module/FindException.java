/*
 * Copyright (c) 2015, 2019, Oracle and/or its affiliates. All rights reserved.
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
 * Thrown by a {@link ModuleFinder ModuleFinder} when an error occurs finding
 * a module. Also thrown by {@link
 * Configuration#resolve(ModuleFinder,java.util.List,ModuleFinder,java.util.Collection)
 * Configuration.resolve} when resolution fails for observability-related
 * reasons.
 *
 * @since 9
 */

public class FindException extends RuntimeException {
    @java.io.Serial
    private static final long serialVersionUID = -5817081036963388391L;

    /**
     * Constructs a {@code FindException} with no detail message.
     */
    public FindException() {
    }

    /**
     * Constructs a {@code FindException} with the given detail
     * message.
     *
     * @param msg
     *        The detail message; can be {@code null}
     */
    public FindException(String msg) {
        super(msg);
    }

    /**
     * Constructs a {@code FindException} with the given cause.
     *
     * @param cause
     *        The cause; can be {@code null}
     */
    public FindException(Throwable cause) {
        super(cause);
    }

    /**
     * Constructs a {@code FindException} with the given detail message
     * and cause.
     *
     * @param msg
     *        The detail message; can be {@code null}
     * @param cause
     *        The cause; can be {@code null}
     */
    public FindException(String msg, Throwable cause) {
        super(msg, cause);
    }
}
