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
 * Thrown when the Java Virtual Machine attempts to read a class
 * file and determines that the file is malformed or otherwise cannot
 * be interpreted as a class file.
 *
 * @since   1.0
 */
public class ClassFormatError extends LinkageError {
    @java.io.Serial
    private static final long serialVersionUID = -8420114879011949195L;

    /**
     * Constructs a {@code ClassFormatError} with no detail message.
     */
    public ClassFormatError() {
        super();
    }

    /**
     * Constructs a {@code ClassFormatError} with the specified
     * detail message.
     *
     * @param   s   the detail message.
     */
    public ClassFormatError(String s) {
        super(s);
    }
}
