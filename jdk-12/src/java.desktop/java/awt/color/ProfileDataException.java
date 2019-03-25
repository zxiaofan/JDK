/*
 * Copyright (c) 1997, 2018, Oracle and/or its affiliates. All rights reserved.
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

package java.awt.color;

/**
 * This exception is thrown when an error occurs in accessing or processing an
 * {@code ICC_Profile} object.
 */
public class ProfileDataException extends java.lang.RuntimeException {

    /**
     * Use serialVersionUID from JDK 1.2 for interoperability.
     */
    private static final long serialVersionUID = 7286140888240322498L;

    /**
     * Constructs a {@code ProfileDataException} with the specified detail
     * message.
     *
     * @param  s the specified detail message
     */
    public ProfileDataException(String s) {
        super(s);
    }
}
