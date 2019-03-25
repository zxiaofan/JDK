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

/**
 * This exception is used when a reader is used to read file of a format
 * it doesn't unterstand or support.
 *
 * @author Karl Helgason
 */
public class InvalidFormatException extends InvalidDataException {

    private static final long serialVersionUID = 1L;

    public InvalidFormatException() {
        super("Invalid format!");
    }

    public InvalidFormatException(String s) {
        super(s);
    }
}
