/*
 * Copyright (c) 1997, 2012, Oracle and/or its affiliates. All rights reserved.
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

package javax.activation;

import java.io.IOException;

/**
 * Signals that the requested operation does not support the
 * requested data type.
 *
 * @see javax.activation.DataHandler
 *
 * @since 1.6
 */

public class UnsupportedDataTypeException extends IOException {
    /**
     * Constructs an UnsupportedDataTypeException with no detail
     * message.
     */
    public UnsupportedDataTypeException() {
        super();
    }

    /**
     * Constructs an UnsupportedDataTypeException with the specified
     * message.
     *
     * @param s The detail message.
     */
    public UnsupportedDataTypeException(String s) {
        super(s);
    }
}
