/*
 * Copyright (c) 2010, Oracle and/or its affiliates. All rights reserved.
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

package sun.java2d.xr;

/**
 * Class to efficiently store glyph information for laid out glyphs,
 * passed to native or java backend.
 *
 * @author Clemens Eisserer
 */
public class GrowableEltArray extends GrowableIntArray {
    private static final int ELT_SIZE = 4;
    GrowableIntArray glyphs;

    public GrowableEltArray(int initialSize)
    {
        super(ELT_SIZE, initialSize);
        glyphs = new GrowableIntArray(1, initialSize*8);
    }

    public final int getCharCnt(int index) {
        return array[getCellIndex(index) + 0];
    }

    public final void setCharCnt(int index, int cnt) {
        array[getCellIndex(index) + 0] = cnt;
    }

    public final int getXOff(int index) {
        return array[getCellIndex(index) + 1];
    }

    public final void setXOff(int index, int xOff) {
        array[getCellIndex(index) + 1] = xOff;
    }

    public final int getYOff(int index) {
        return array[getCellIndex(index) + 2];
    }

    public final void setYOff(int index, int yOff) {
        array[getCellIndex(index) + 2] = yOff;
    }

    public final int getGlyphSet(int index) {
        return array[getCellIndex(index) + 3];
    }

    public final void setGlyphSet(int index, int glyphSet) {
        array[getCellIndex(index) + 3] = glyphSet;
    }

    public GrowableIntArray getGlyphs() {
        return glyphs;
    }

    public void clear() {
        glyphs.clear();
        super.clear();
    }
}
