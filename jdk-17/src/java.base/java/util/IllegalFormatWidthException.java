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
 * Unchecked exception thrown when the format width is a negative value other
 * than {@code -1} or is otherwise unsupported. If a given format width is not
 * representable by an {@code int} type, then the value
 * {@code Integer.MIN_VALUE} will be used in the exception.
 *
 * @since 1.5
 */
public class IllegalFormatWidthException extends IllegalFormatException {

    @java.io.Serial
    private static final long serialVersionUID = 16660902L;

    private int w;

    /**
     * Constructs an instance of this class with the specified width.
     *
     * @param  w
     *         The width
     */
    public IllegalFormatWidthException(int w) {
        this.w = w;
    }

    /**
     * Returns the width. If the width is not representable by an {@code int},
     * then returns {@code Integer.MIN_VALUE}.
     *
     * @return  The width
     */
    public int getWidth() {
        return w;
    }

    public String getMessage() {
        return Integer.toString(w);
    }
}
