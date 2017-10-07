/*
 * Copyright (c) 1997, 2013, Oracle and/or its affiliates. All rights reserved.
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

package com.sun.javafx.geom;

/**
 * The <code>IllegalPathStateException</code> represents an
 * exception that is thrown if an operation is performed on a path
 * that is in an illegal state with respect to the particular
 * operation being performed, such as appending a path segment
 * to a GeneralPath without an initial moveto.
 *
 * @version     1.19, 05/05/07
 */

public class IllegalPathStateException extends RuntimeException {
    /**
     * Constructs an <code>IllegalPathStateException</code> with no
     * detail message.
     */
    public IllegalPathStateException() {
    }

    /**
     * Constructs an <code>IllegalPathStateException</code> with the
     * specified detail message.
     * @param   s   the detail message
     */
    public IllegalPathStateException(String s) {
        super (s);
    }
}
