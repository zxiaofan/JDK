/*
 * Copyright (c) 2001, 2021, Oracle and/or its affiliates. All rights reserved.
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

package javax.print.attribute;

import java.io.Serial;

/**
 * Thrown to indicate that the requested operation cannot be performed because
 * the set is unmodifiable.
 *
 * @author Phil Race
 * @since 1.4
 */
public class UnmodifiableSetException extends RuntimeException {

    /**
     * Use serialVersionUID from JDK 1.4 for interoperability.
     */
    @Serial
    private static final long serialVersionUID = 2255250308571511731L;

    /**
     * Constructs an {@code UnsupportedOperationException} with no detail
     * message.
     */
    public UnmodifiableSetException() {
    }

    /**
     * Constructs an {@code UnmodifiableSetException} with the specified detail
     * message.
     *
     * @param  message the detail message
     */
    public UnmodifiableSetException(String message) {
        super(message);
    }
}
