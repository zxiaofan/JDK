/*
 * Copyright (c) 1997, 2018, Oracle and/or its affiliates. All rights reserved.
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

import sun.java2d.SunGraphics2D;

/**
 * This interface defines the set of calls that pipeline objects
 * can use to pass on responsibility for filling various basic
 * geometric figures defined by explicit integer coordinates.
 * Typically this interface will be used for communication when
 * the coordinates of the rendering have been narrowed down to
 * actual device pixels, or for communication of untransformed
 * coordinates when the coordinates were specified using integers.
 * This interface does not cover all of the rendering calls that
 * are possible in Graphics since many of the rendering calls can
 * be transformed into one or more variants of these calls.
 */
public interface PixelFillPipe {
    public void fillRect(SunGraphics2D sg,
                         int x, int y, int width, int height);


    public void fillRoundRect(SunGraphics2D sg,
                              int x, int y, int width, int height,
                              int arcWidth, int arcHeight);

    public void fillOval(SunGraphics2D sg,
                         int x, int y, int width, int height);

    public void fillArc(SunGraphics2D sg,
                        int x, int y, int width, int height,
                        int startAngle, int arcAngle);

    public void fillPolygon(SunGraphics2D sg,
                            int[] xPoints, int[] yPoints,
                            int nPoints);
}
