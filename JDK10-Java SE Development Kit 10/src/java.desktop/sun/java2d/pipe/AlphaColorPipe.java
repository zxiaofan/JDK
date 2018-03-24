/*
 * Copyright (c) 1997, 2011, Oracle and/or its affiliates. All rights reserved.
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
 * This class implements a CompositePipe that renders path alpha tiles
 * into a destination that supports direct alpha compositing of a solid
 * color, according to one of the rules in the AlphaComposite class.
 */
public class AlphaColorPipe implements CompositePipe, ParallelogramPipe {
    public AlphaColorPipe() {
    }

    public Object startSequence(SunGraphics2D sg, Shape s, Rectangle dev,
                                int[] abox) {
        return sg;
    }

    public boolean needTile(Object context, int x, int y, int w, int h) {
        return true;
    }

    public void renderPathTile(Object context,
                               byte[] atile, int offset, int tilesize,
                               int x, int y, int w, int h) {
        SunGraphics2D sg = (SunGraphics2D) context;

        sg.alphafill.MaskFill(sg, sg.getSurfaceData(), sg.composite,
                              x, y, w, h,
                              atile, offset, tilesize);
    }

    public void skipTile(Object context, int x, int y) {
        return;
    }

    public void endSequence(Object context) {
        return;
    }

    public void fillParallelogram(SunGraphics2D sg,
                                  double ux1, double uy1,
                                  double ux2, double uy2,
                                  double x, double y,
                                  double dx1, double dy1,
                                  double dx2, double dy2)
    {
        sg.alphafill.FillAAPgram(sg, sg.getSurfaceData(), sg.composite,
                                 x, y, dx1, dy1, dx2, dy2);
    }

    public void drawParallelogram(SunGraphics2D sg,
                                  double ux1, double uy1,
                                  double ux2, double uy2,
                                  double x, double y,
                                  double dx1, double dy1,
                                  double dx2, double dy2,
                                  double lw1, double lw2)
    {
        sg.alphafill.DrawAAPgram(sg, sg.getSurfaceData(), sg.composite,
                                 x, y, dx1, dy1, dx2, dy2, lw1, lw2);
    }
}
