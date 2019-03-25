/*
 * Copyright (c) 1997, 2007, Oracle and/or its affiliates. All rights reserved.
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

import java.awt.Rectangle;
import java.awt.Shape;
import sun.java2d.SunGraphics2D;

/**
 * This interface defines the set of calls used by a rendering pipeline
 * based on an AATileGenerator to communicate the alpha tile sequence
 * to the output (compositing) stages of the pipeline.
 */
public interface CompositePipe {
    public Object startSequence(SunGraphics2D sg, Shape s, Rectangle dev,
                                int[] abox);

    public boolean needTile(Object context, int x, int y, int w, int h);

    public void renderPathTile(Object context,
                               byte[] atile, int offset, int tilesize,
                               int x, int y, int w, int h);

    public void skipTile(Object context, int x, int y);

    public void endSequence(Object context);
}
