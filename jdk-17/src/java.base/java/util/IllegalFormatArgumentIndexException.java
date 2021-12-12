/*
 * Copyright (c) 2020, Oracle and/or its affiliates. All rights reserved.
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
 * Unchecked exception thrown when the argument index is not within the valid
 * range of supported argument index values. If an index value isn't
 * representable by an {@code int} type, then the value
 * {@code Integer.MIN_VALUE} will be used in the exception.
 *
 * @since 16
 */
class IllegalFormatArgumentIndexException extends IllegalFormatException {

    @java.io.Serial
    private static final long serialVersionUID = 4191767811181838112L;

    private final int illegalIndex;

    /**
     * Constructs an instance of this class with the specified argument index
     * @param index The value of a corresponding illegal argument index.
     */
    IllegalFormatArgumentIndexException(int index) {
        illegalIndex = index;
    }

    /**
     * Gets the value of the illegal index.
     * Returns {@code Integer.MIN_VALUE} if the illegal index is not
     * representable by an {@code int}.
     * @return the illegal index value
     */
    int getIndex() {
        return illegalIndex;
    }

    @Override
    public String getMessage() {
        int index = getIndex();

        if (index == Integer.MIN_VALUE) {
           return "Format argument index: (not representable as int)";
        }

        return String.format("Illegal format argument index = %d", getIndex());
    }

}
