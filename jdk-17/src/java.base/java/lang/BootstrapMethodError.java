/*
 * Copyright (c) 2008, 2019, Oracle and/or its affiliates. All rights reserved.
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
 * Thrown to indicate that an {@code invokedynamic} instruction or a dynamic
 * constant failed to resolve its bootstrap method and arguments,
 * or for {@code invokedynamic} instruction the bootstrap method has failed to
 * provide a
 * {@linkplain java.lang.invoke.CallSite call site} with a
 * {@linkplain java.lang.invoke.CallSite#getTarget target}
 * of the correct {@linkplain java.lang.invoke.MethodHandle#type() method type},
 * or for a dynamic constant the bootstrap method has failed to provide a
 * constant value of the required type.
 *
 * @author John Rose, JSR 292 EG
 * @since 1.7
 */
public class BootstrapMethodError extends LinkageError {
    @java.io.Serial
    private static final long serialVersionUID = 292L;

    /**
     * Constructs a {@code BootstrapMethodError} with no detail message.
     */
    public BootstrapMethodError() {
        super();
    }

    /**
     * Constructs a {@code BootstrapMethodError} with the specified
     * detail message.
     *
     * @param s the detail message.
     */
    public BootstrapMethodError(String s) {
        super(s);
    }

    /**
     * Constructs a {@code BootstrapMethodError} with the specified
     * detail message and cause.
     *
     * @param s the detail message.
     * @param cause the cause, may be {@code null}.
     */
    public BootstrapMethodError(String s, Throwable cause) {
        super(s, cause);
    }

    /**
     * Constructs a {@code BootstrapMethodError} with the specified
     * cause.
     *
     * @param cause the cause, may be {@code null}.
     */
    public BootstrapMethodError(Throwable cause) {
        // cf. Throwable(Throwable cause) constructor.
        super(cause == null ? null : cause.toString());
        initCause(cause);
    }
}
