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

package com.sun.javafx.font.freetype;

import com.sun.javafx.font.Glyph;
import com.sun.javafx.geom.RectBounds;
import com.sun.javafx.geom.Shape;

class FTGlyph implements Glyph {
    FTFontStrike strike;
    int glyphCode;
    byte[] buffer;
    FT_Bitmap bitmap;
    int bitmap_left;
    int bitmap_top;
    float advanceX;
    float advanceY;
    float userAdvance;
    boolean lcd;

    FTGlyph(FTFontStrike strike, int glyphCode, boolean drawAsShape) {
        this.strike = strike;
        this.glyphCode = glyphCode;
    }

    @Override
    public int getGlyphCode() {
        return glyphCode;
    }

    private void init() {
        if (bitmap != null) return;
        strike.initGlyph(this);
    }

    @Override
    public RectBounds getBBox() {
        float[] bb = new float[4];
        FTFontFile fontResource = strike.getFontResource();
        fontResource.getGlyphBoundingBox(glyphCode, strike.getSize(), bb);
        return new RectBounds(bb[0], bb[1], bb[2], bb[3]);
    }

    @Override
    public float getAdvance() {
        init();
        return userAdvance;
    }

    @Override
    public Shape getShape() {
        return strike.createGlyphOutline(glyphCode);
    }

    @Override
    public byte[] getPixelData() {
        init();
        return buffer;
    }

    @Override
    public byte[] getPixelData(int subPixel) {
        init();
        return buffer;
    }

    @Override
    public float getPixelXAdvance() {
        init();
        return advanceX;
    }

    @Override
    public float getPixelYAdvance() {
        init();
        return advanceY;
    }

    @Override
    public int getWidth() {
        init();
        /* Note: In Freetype the width is byte based */
        return bitmap != null ? bitmap.width : 0;
    }

    @Override
    public int getHeight() {
        init();
        return bitmap != null ? bitmap.rows : 0;
    }

    @Override
    public int getOriginX() {
        init();
        return bitmap_left;
    }

    @Override
    public int getOriginY() {
        init();
        return -bitmap_top; /* Inverted coordinates system */
    }

    @Override
    public boolean isLCDGlyph() {
        return lcd;
    }

}
