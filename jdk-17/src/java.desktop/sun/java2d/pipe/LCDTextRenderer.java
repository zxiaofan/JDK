/*
 * Copyright (c) 2005, Oracle and/or its affiliates. All rights reserved.
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
 * A delegate pipe of SG2D for drawing LCD text with
 * a solid source colour to an opaque destination.
 */

public class LCDTextRenderer extends GlyphListLoopPipe {

    protected void drawGlyphList(SunGraphics2D sg2d, GlyphList gl) {
        drawGlyphList(sg2d, gl, SunHints.INTVAL_TEXT_ANTIALIAS_LCD_HRGB);

    }
}
