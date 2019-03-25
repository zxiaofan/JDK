/*
 * Copyright (c) 2000, 2014, Oracle and/or its affiliates. All rights reserved.
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

package sun.font;

import java.awt.Rectangle;
import java.awt.font.FontRenderContext;
import java.awt.font.GlyphVector;
import sun.awt.SunHints;
import sun.awt.SunToolkit;
import sun.java2d.SunGraphics2D;
import sun.java2d.SurfaceData;
import sun.java2d.pipe.GlyphListPipe;
import sun.java2d.pipe.Region;
import sun.java2d.loops.FontInfo;
import sun.java2d.loops.GraphicsPrimitive;
import sun.java2d.x11.X11SurfaceData;

/**
 * A delegate pipe of SG2D for drawing text with
 * a solid source colour to an X11 drawable destination.
 */
public class X11TextRenderer extends GlyphListPipe {
    /*
     * Override super class method to call the AA pipe if
     * AA is specified in the GlyphVector's FontRenderContext
     */
    public void drawGlyphVector(SunGraphics2D sg2d, GlyphVector g,
                                float x, float y)
    {
        FontRenderContext frc = g.getFontRenderContext();
        FontInfo info = sg2d.getGVFontInfo(g.getFont(), frc);
        switch (info.aaHint) {
        case SunHints.INTVAL_TEXT_ANTIALIAS_OFF:
            super.drawGlyphVector(sg2d, g, x, y);
            return;
        case SunHints.INTVAL_TEXT_ANTIALIAS_ON:
             SurfaceData.aaTextRenderer.drawGlyphVector(sg2d, g, x, y);
            return;
        case SunHints.INTVAL_TEXT_ANTIALIAS_LCD_HRGB:
        case SunHints.INTVAL_TEXT_ANTIALIAS_LCD_VRGB:
             SurfaceData.lcdTextRenderer.drawGlyphVector(sg2d, g, x, y);
            return;
        default:
        }
    }

    native void doDrawGlyphList(long dstData, long xgc,
                                Region clip, GlyphList gl);

    protected void drawGlyphList(SunGraphics2D sg2d, GlyphList gl) {
        SunToolkit.awtLock();
        try {
            X11SurfaceData x11sd = (X11SurfaceData)sg2d.surfaceData;
            Region clip = sg2d.getCompClip();
            long xgc = x11sd.getRenderGC(clip, SunGraphics2D.COMP_ISCOPY,
                                         null, sg2d.pixel);
            doDrawGlyphList(x11sd.getNativeOps(), xgc, clip, gl);
        } finally {
            SunToolkit.awtUnlock();
        }
    }

    public X11TextRenderer traceWrap() {
        return new Tracer();
    }

    public static class Tracer extends X11TextRenderer {
        void doDrawGlyphList(long dstData, long xgc,
                             Region clip, GlyphList gl)
        {
            GraphicsPrimitive.tracePrimitive("X11DrawGlyphs");
            super.doDrawGlyphList(dstData, xgc, clip, gl);
        }
    }
}
