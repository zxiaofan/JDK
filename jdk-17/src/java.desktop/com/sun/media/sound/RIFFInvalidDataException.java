/*
 * Copyright (c) 2007, 2021, Oracle and/or its affiliates. All rights reserved.
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

package com.sun.media.sound;

import java.io.Serial;

/**
 * This exception is used when a RIFF file contains illegal or unexpected data.
 *
 * @author Karl Helgason
 */
public final class RIFFInvalidDataException extends InvalidDataException {

    /**
     * Use serialVersionUID from JDK 1.7 for interoperability.
     */
    @Serial
    private static final long serialVersionUID = 1L;

    public RIFFInvalidDataException() {
        super("Invalid Data!");
    }

    public RIFFInvalidDataException(String s) {
        super(s);
    }
}
