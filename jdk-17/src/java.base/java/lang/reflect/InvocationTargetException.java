/*
 * Copyright (c) 1996, 2020, Oracle and/or its affiliates. All rights reserved.
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

package java.lang.reflect;

/**
 * InvocationTargetException is a checked exception that wraps
 * an exception thrown by an invoked method or constructor.
 *
 * @see Method
 * @see Constructor
 * @since 1.1
 */
public class InvocationTargetException extends ReflectiveOperationException {
    /**
     * Use serialVersionUID from JDK 1.1.X for interoperability
     */
    @java.io.Serial
    private static final long serialVersionUID = 4085088731926701167L;

    /**
     * This field holds the target if the
     * InvocationTargetException(Throwable target) constructor was
     * used to instantiate the object
     *
     * @serial
     *
     */
    private Throwable target;

    /**
     * Constructs an {@code InvocationTargetException} with
     * {@code null} as the target exception.
     */
    protected InvocationTargetException() {
        super((Throwable)null);  // Disallow initCause
    }

    /**
     * Constructs a InvocationTargetException with a target exception.
     *
     * @param target the target exception
     */
    public InvocationTargetException(Throwable target) {
        super((Throwable)null);  // Disallow initCause
        this.target = target;
    }

    /**
     * Constructs a InvocationTargetException with a target exception
     * and a detail message.
     *
     * @param target the target exception
     * @param s      the detail message
     */
    public InvocationTargetException(Throwable target, String s) {
        super(s, null);  // Disallow initCause
        this.target = target;
    }

    /**
     * Get the thrown target exception.
     *
     * @apiNote
     * This method predates the general-purpose exception chaining facility.
     * The {@link Throwable#getCause()} method is now the preferred means of
     * obtaining this information.
     *
     * @return the thrown target exception (cause of this exception).
     */
    public Throwable getTargetException() {
        return target;
    }

    /**
     * Returns the cause of this exception (the thrown target exception,
     * which may be {@code null}).
     *
     * @return  the cause of this exception.
     * @since   1.4
     */
    @Override
    public Throwable getCause() {
        return target;
    }
}
