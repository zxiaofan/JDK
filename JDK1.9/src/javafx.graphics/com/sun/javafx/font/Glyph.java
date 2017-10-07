/*
 * Copyright (c) 2013, Oracle and/or its affiliates. All rights reserved.
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

package com.sun.javafx.font;

import com.sun.javafx.geom.RectBounds;
import com.sun.javafx.geom.Shape;

public interface Glyph {
    public int getGlyphCode();
    /* These 3 are user space values */
    public RectBounds getBBox();
    public float getAdvance();
    public Shape getShape();
    /* The rest are in device space */
    public byte[] getPixelData();

    /**
     * Returns the glyph mask at the subpixel position specified by subPixel.
     *
     * @see FontStrike#getQuantizedPosition(com.sun.javafx.geom.Point2D)
     */
    public byte[] getPixelData(int subPixel);
    public float getPixelXAdvance();
    public float getPixelYAdvance();
    public boolean isLCDGlyph();

    /* These 4 methods should only be called after either getPixelData() or
     * getPixelData(int subPixel) is invoked. This ensures the returned value
     * is correct for the requested subpixel position. */
    public int getWidth();
    public int getHeight();
    public int getOriginX();
    public int getOriginY();
}
