/*
 * Copyright (c) 2005, 2016, Oracle and/or its affiliates. All rights reserved.
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

package sun.java2d.pipe;

import sun.awt.SunHints;
import sun.java2d.SunGraphics2D;
import sun.font.GlyphList;

/**
 * A delegate pipe of SG2D which implements redispatching of
 * for the src mode loops in the drawGlyphVector case where
 * the installed loop may not match the glyphvector.
 */

public abstract class GlyphListLoopPipe extends GlyphListPipe
    implements LoopBasedPipe
{
    protected void drawGlyphList(SunGraphics2D sg2d, GlyphList gl,
                                 int aaHint) {
        int prevLimit = 0;
        boolean isColor = false;
        int len = gl.getNumGlyphs();
        gl.startGlyphIteration();
        if (GlyphList.canContainColorGlyphs()) {
            for (int i = 0; i < len; i++) {
                boolean newIsColor = gl.isColorGlyph(i);
                if (newIsColor != isColor) {
                    drawGlyphListSegment(sg2d, gl, prevLimit, i, aaHint,
                            isColor);
                    prevLimit = i;
                    isColor = newIsColor;
                }
            }
        }
        drawGlyphListSegment(sg2d, gl, prevLimit, len, aaHint, isColor);
    }

    private void drawGlyphListSegment(SunGraphics2D sg2d, GlyphList gl,
                                      int fromglyph, int toGlyph,
                                      int aaHint, boolean isColor) {
        if (fromglyph >= toGlyph) return;
        if (isColor) {
            sg2d.loops.drawGlyphListColorLoop.
                    DrawGlyphListColor(sg2d, sg2d.surfaceData,
                            gl, fromglyph, toGlyph);
        } else {
            switch (aaHint) {
                case SunHints.INTVAL_TEXT_ANTIALIAS_OFF:
                    sg2d.loops.drawGlyphListLoop.
                            DrawGlyphList(sg2d, sg2d.surfaceData,
                                    gl, fromglyph, toGlyph);
                    return;
                case SunHints.INTVAL_TEXT_ANTIALIAS_ON:
                    sg2d.loops.drawGlyphListAALoop.
                            DrawGlyphListAA(sg2d, sg2d.surfaceData,
                                    gl, fromglyph, toGlyph);
                    return;
                case SunHints.INTVAL_TEXT_ANTIALIAS_LCD_HRGB:
                case SunHints.INTVAL_TEXT_ANTIALIAS_LCD_VRGB:
                    sg2d.loops.drawGlyphListLCDLoop.
                            DrawGlyphListLCD(sg2d, sg2d.surfaceData,
                                    gl, fromglyph, toGlyph);
                    return;
            }
        }
    }
}
