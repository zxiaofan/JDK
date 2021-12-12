/*
 * Copyright (c) 1994, 2020, Oracle and/or its affiliates. All rights reserved.
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
 * Thrown if the Java Virtual Machine cannot find an appropriate
 * native-language definition of a method declared {@code native}.
 *
 * @see     java.lang.Runtime
 * @since   1.0
 */
public class UnsatisfiedLinkError extends LinkageError {
    @java.io.Serial
    private static final long serialVersionUID = -4019343241616879428L;

    /**
     * Constructs an {@code UnsatisfiedLinkError} with no detail message.
     */
    public UnsatisfiedLinkError() {
        super();
    }

    /**
     * Constructs an {@code UnsatisfiedLinkError} with the
     * specified detail message.
     *
     * @param   s   the detail message.
     */
    public UnsatisfiedLinkError(String s) {
        super(s);
    }
}
