/*
 * Copyright (c) 1996, 2020, Oracle and/or its affiliates. All rights reserved.
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

package java.io;

/**
 * Superclass of all exceptions specific to Object Stream classes.
 *
 * @since   1.1
 */
public abstract class ObjectStreamException extends IOException {

    @java.io.Serial
    private static final long serialVersionUID = 7260898174833392607L;

    /**
     * Create an ObjectStreamException with the specified argument.
     *
     * @param message the detailed message for the exception
     */
    protected ObjectStreamException(String message) {
        super(message);
    }

    /**
     * Create an ObjectStreamException.
     */
    protected ObjectStreamException() {
        super();
    }
}
