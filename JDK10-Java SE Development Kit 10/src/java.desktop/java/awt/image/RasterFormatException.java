/*
 * Copyright (c) 1997, 2014, Oracle and/or its affiliates. All rights reserved.
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

package java.awt.image;


/**
 * The {@code RasterFormatException} is thrown if there is
 * invalid layout information in the {@link Raster}.
 */
public class RasterFormatException extends java.lang.RuntimeException {
    private static final long serialVersionUID = 96598996116164315L;

    /**
     * Constructs a new {@code RasterFormatException} with the
     * specified message.
     * @param s the message to generate when a
     * {@code RasterFormatException} is thrown
     */
    public RasterFormatException(String s) {
        super (s);
    }
}
