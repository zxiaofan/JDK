/*
 * Copyright (c) 2007, Oracle and/or its affiliates. All rights reserved.
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

import java.io.IOException;

/**
 * This exception is used when a file contains illegal or unexpected data.
 *
 * @author Karl Helgason
 */
public class InvalidDataException extends IOException {

    private static final long serialVersionUID = 1L;

    public InvalidDataException() {
        super("Invalid Data!");
    }

    public InvalidDataException(String s) {
        super(s);
    }
}
