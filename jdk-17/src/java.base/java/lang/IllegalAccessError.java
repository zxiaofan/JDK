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
 * Thrown if an application attempts to access or modify a field, or
 * to call a method that it does not have access to.
 * <p>
 * Normally, this error is caught by the compiler; this error can
 * only occur at run time if the definition of a class has
 * incompatibly changed.
 *
 * @since   1.0
 */
public class IllegalAccessError extends IncompatibleClassChangeError {
    @java.io.Serial
    private static final long serialVersionUID = -8988904074992417891L;

    /**
     * Constructs an {@code IllegalAccessError} with no detail message.
     */
    public IllegalAccessError() {
        super();
    }

    /**
     * Constructs an {@code IllegalAccessError} with the specified
     * detail message.
     *
     * @param   s   the detail message.
     */
    public IllegalAccessError(String s) {
        super(s);
    }
}
