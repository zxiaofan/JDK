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
 * Thrown when a stack overflow occurs because an application
 * recurses too deeply.
 *
 * @since   1.0
 */
public class StackOverflowError extends VirtualMachineError {
    @java.io.Serial
    private static final long serialVersionUID = 8609175038441759607L;

    /**
     * Constructs a {@code StackOverflowError} with no detail message.
     */
    public StackOverflowError() {
        super();
    }

    /**
     * Constructs a {@code StackOverflowError} with the specified
     * detail message.
     *
     * @param   s   the detail message.
     */
    public StackOverflowError(String s) {
        super(s);
    }
}
