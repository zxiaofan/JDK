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
 * Indicates that one or more deserialized objects failed validation
 * tests.  The argument should provide the reason for the failure.
 *
 * @see ObjectInputValidation
 * @since 1.1
 *
 * @since   1.1
 */
public class InvalidObjectException extends ObjectStreamException {

    @java.io.Serial
    private static final long serialVersionUID = 3233174318281839583L;

    /**
     * Constructs an {@code InvalidObjectException}.
     * @param reason Detailed message explaining the reason for the failure.
     *
     * @see ObjectInputValidation
     */
    public  InvalidObjectException(String reason) {
        super(reason);
    }
}
