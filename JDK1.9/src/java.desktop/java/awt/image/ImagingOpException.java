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
 * The {@code ImagingOpException} is thrown if one of the
 * {@link BufferedImageOp} or {@link RasterOp} filter methods cannot
 * process the image.
 */
public class ImagingOpException extends java.lang.RuntimeException {
    private static final long serialVersionUID = 8026288481846276658L;

    /**
     * Constructs an {@code ImagingOpException} object with the
     * specified message.
     * @param s the message to generate when a
     * {@code ImagingOpException} is thrown
     */
    public ImagingOpException(String s) {
        super (s);
    }
}
