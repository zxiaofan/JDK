/*
 * %W% %E%
 *
 * Copyright (c) 2006, Oracle and/or its affiliates. All rights reserved.
 * ORACLE PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

package java.util;

/**
 * Thrown by a <code>Scanner</code> to indicate that the token
 * retrieved does not match the pattern for the expected type, or
 * that the token is out of range for the expected type.
 *
 * @author  unascribed
 * @version %I% %G%
 * @see     java.util.Scanner
 * @since   1.5
 */
public
class InputMismatchException extends NoSuchElementException {
    /**
     * Constructs an <code>InputMismatchException</code> with <tt>null</tt> 
     * as its error message string.
     */
    public InputMismatchException() {
	super();
    }

    /**
     * Constructs an <code>InputMismatchException</code>, saving a reference 
     * to the error message string <tt>s</tt> for later retrieval by the 
     * <tt>getMessage</tt> method.
     *
     * @param   s   the detail message.
     */
    public InputMismatchException(String s) {
	super(s);
    }
}
