/*
 * Copyright (c) 1998, 2018, Oracle and/or its affiliates. All rights reserved.
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

/*
 * @author Charlton Innovations, Inc.
 */

package sun.java2d.pipe;

import sun.java2d.SunGraphics2D;
import java.awt.font.GlyphVector;

/**
 * This interface defines the set of calls that pipeline objects
 * can use to pass on responsibility for drawing various text
 * representations.
 */
public interface TextPipe {
    public void drawString(SunGraphics2D g2d, String s,
                           double x, double y);
    public void drawGlyphVector(SunGraphics2D g2d, GlyphVector g,
                                float x, float y);
    public void drawChars(SunGraphics2D g2d,
                          char[] data, int offset, int length,
                          int x, int y);
}
