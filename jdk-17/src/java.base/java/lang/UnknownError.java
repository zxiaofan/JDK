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
 * Thrown when an unknown but serious exception has occurred in the
 * Java Virtual Machine.
 *
 * @since   1.0
 */
public class UnknownError extends VirtualMachineError {
    @java.io.Serial
    private static final long serialVersionUID = 2524784860676771849L;

    /**
     * Constructs an {@code UnknownError} with no detail message.
     */
    public UnknownError() {
        super();
    }

    /**
     * Constructs an {@code UnknownError} with the specified detail
     * message.
     *
     * @param   s   the detail message.
     */
    public UnknownError(String s) {
        super(s);
    }
}
