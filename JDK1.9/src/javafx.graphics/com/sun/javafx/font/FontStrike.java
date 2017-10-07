/*
 * Copyright (c) 2010, 2013, Oracle and/or its affiliates. All rights reserved.
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

import com.sun.javafx.scene.text.GlyphList;
import com.sun.javafx.geom.Point2D;
import com.sun.javafx.geom.Shape;
import com.sun.javafx.geom.transform.BaseTransform;

public interface FontStrike {
    public FontResource getFontResource();
    public float getSize();
    public BaseTransform getTransform();
    public boolean drawAsShapes();

    /**
     * Modifies the point argument to the quantized position suitable for the
     * underlying glyph rasterizer.
     * The return value is the sub pixel index which should be passed to
     * {@link Glyph#getPixelData(int)} in order to obtain the correct glyph mask
     * for the given point.
     */
    public int getQuantizedPosition(Point2D point);
    public Metrics getMetrics();
    public Glyph getGlyph(char symbol);
    public Glyph getGlyph(int glyphCode);
    public void clearDesc(); // for cache management.
    public int getAAMode();

    /* These are all user space values */
    public float getCharAdvance(char ch);
    public Shape getOutline(GlyphList gl,
                            BaseTransform transform);
}
