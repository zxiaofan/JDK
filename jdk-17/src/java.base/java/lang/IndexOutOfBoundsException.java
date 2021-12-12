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
 * Thrown to indicate that an index of some sort (such as to an array, to a
 * string, or to a vector) is out of range.
 * <p>
 * Applications can subclass this class to indicate similar exceptions.
 *
 * @author Frank Yellin
 * @since 1.0
 */
public class IndexOutOfBoundsException extends RuntimeException {
    @java.io.Serial
    private static final long serialVersionUID = 234122996006267687L;

    /**
     * Constructs an {@code IndexOutOfBoundsException} with no detail message.
     */
    public IndexOutOfBoundsException() {
        super();
    }

    /**
     * Constructs an {@code IndexOutOfBoundsException} with the specified detail
     * message.
     *
     * @param s the detail message
     */
    public IndexOutOfBoundsException(String s) {
        super(s);
    }

    /**
     * Constructs a new {@code IndexOutOfBoundsException} class with an
     * argument indicating the illegal index.
     *
     * <p>The index is included in this exception's detail message.  The
     * exact presentation format of the detail message is unspecified.
     *
     * @param index the illegal index.
     * @since 9
     */
    public IndexOutOfBoundsException(int index) {
        super("Index out of range: " + index);
    }

    /**
     * Constructs a new {@code IndexOutOfBoundsException} class with an
     * argument indicating the illegal index.
     *
     * <p>The index is included in this exception's detail message.  The
     * exact presentation format of the detail message is unspecified.
     *
     * @param index the illegal index.
     * @since 16
     */
    public IndexOutOfBoundsException(long index) {
        super("Index out of range: " + index);
    }
}
