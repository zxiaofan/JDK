/*
 * Copyright (c) 2003, 2020, Oracle and/or its affiliates. All rights reserved.
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

package java.lang.reflect;


/**
 * Thrown when a syntactically malformed signature attribute is
 * encountered by a reflective method that needs to interpret the generic
 * signature information for a class or interface, method or constructor.
 *
 * @since 1.5
 */
public class GenericSignatureFormatError extends ClassFormatError {
    @java.io.Serial
    private static final long serialVersionUID = 6709919147137911034L;

    /**
     * Constructs a new {@code GenericSignatureFormatError}.
     *
     */
    public GenericSignatureFormatError() {
        super();
    }

    /**
     * Constructs a new {@code GenericSignatureFormatError} with the
     * specified message.
     *
     * @param message the detail message, may be {@code null}
     */
    public GenericSignatureFormatError(String message) {
        super(message);
    }
}
