/*
 * Copyright (c) 1997, 2014, Oracle and/or its affiliates. All rights reserved.
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

package java.awt.geom;

/**
 * The {@code NoninvertibleTransformException} class represents
 * an exception that is thrown if an operation is performed requiring
 * the inverse of an {@link AffineTransform} object but the
 * {@code AffineTransform} is in a non-invertible state.
 */

public class NoninvertibleTransformException extends java.lang.Exception {
    private static final long serialVersionUID = 6137225240503990466L;

    /**
     * Constructs an instance of
     * {@code NoninvertibleTransformException}
     * with the specified detail message.
     * @param   s     the detail message
     * @since   1.2
     */
    public NoninvertibleTransformException(String s) {
        super (s);
    }
}
