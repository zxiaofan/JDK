/*
 * Copyright (c) 1994, 2019, Oracle and/or its affiliates. All rights reserved.
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
 * Thrown by {@code String} methods to indicate that an index is either negative
 * or greater than the size of the string.  For some methods such as the
 * {@link String#charAt charAt} method, this exception also is thrown when the
 * index is equal to the size of the string.
 *
 * @see java.lang.String#charAt(int)
 * @since 1.0
 */
public class StringIndexOutOfBoundsException extends IndexOutOfBoundsException {
    @java.io.Serial
    private static final long serialVersionUID = -6762910422159637258L;

    /**
     * Constructs a {@code StringIndexOutOfBoundsException} with no detail
     * message.
     */
    public StringIndexOutOfBoundsException() {
        super();
    }

    /**
     * Constructs a {@code StringIndexOutOfBoundsException} with the specified
     * detail message.
     *
     * @param s the detail message.
     */
    public StringIndexOutOfBoundsException(String s) {
        super(s);
    }

    /**
     * Constructs a new {@code StringIndexOutOfBoundsException} class with an
     * argument indicating the illegal index.
     *
     * <p>The index is included in this exception's detail message.  The
     * exact presentation format of the detail message is unspecified.
     *
     * @param index the illegal index.
     */
    public StringIndexOutOfBoundsException(int index) {
        super("String index out of range: " + index);
    }
}
