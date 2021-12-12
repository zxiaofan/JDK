/*
 * Copyright (c) 2003, 2019, Oracle and/or its affiliates. All rights reserved.
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
 * Unchecked exception thrown when the precision is a negative value other than
 * {@code -1}, the conversion does not support a precision, or the value is
 * otherwise unsupported. If the precision is not representable by an
 * {@code int} type, then the value {@code Integer.MIN_VALUE} will be used
 * in the exception.
 *
 * @since 1.5
 */
public class IllegalFormatPrecisionException extends IllegalFormatException {

    @java.io.Serial
    private static final long serialVersionUID = 18711008L;

    private int p;

    /**
     * Constructs an instance of this class with the specified precision.
     *
     * @param  p
     *         The precision
     */
    public IllegalFormatPrecisionException(int p) {
        this.p = p;
    }

    /**
     * Returns the precision. If the precision isn't representable by an
     * {@code int}, then will return {@code Integer.MIN_VALUE}.
     *
     * @return  The precision
     */
    public int getPrecision() {
        return p;
    }

    public String getMessage() {
        return Integer.toString(p);
    }
}
