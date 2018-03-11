/*
 * Copyright (c) 1994, 2008, Oracle and/or its affiliates. All rights reserved.
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

package java.util;

/**
 * Thrown by the <code>nextElement</code> method of an
 * <code>Enumeration</code> to indicate that there are no more
 * elements in the enumeration.
 *
 * @author  unascribed
 * @see     java.util.Enumeration
 * @see     java.util.Enumeration#nextElement()
 * @since   JDK1.0
 */
public
class NoSuchElementException extends RuntimeException {
    private static final long serialVersionUID = 6769829250639411880L;

    /**
     * Constructs a <code>NoSuchElementException</code> with <tt>null</tt>
     * as its error message string.
     */
    public NoSuchElementException() {
        super();
    }

    /**
     * Constructs a <code>NoSuchElementException</code>, saving a reference
     * to the error message string <tt>s</tt> for later retrieval by the
     * <tt>getMessage</tt> method.
     *
     * @param   s   the detail message.
     */
    public NoSuchElementException(String s) {
        super(s);
    }
}
