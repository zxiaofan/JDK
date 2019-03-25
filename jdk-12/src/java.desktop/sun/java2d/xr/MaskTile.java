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

package sun.java2d.xr;

/**
 * Represents a single tile, used to store the rectangles covering the area
 * of the mask where the tile is located.
 *
 * @author Clemens Eisserer
 */
public class MaskTile {
    GrowableRectArray rects;
    DirtyRegion dirtyArea;

    public MaskTile()
    {
        rects = new GrowableRectArray(128);
        dirtyArea = new DirtyRegion();
    }

    public void calculateDirtyAreas()
    {
        for (int i=0; i < rects.getSize(); i++) {
            int x = rects.getX(i);
            int y = rects.getY(i);
            dirtyArea.growDirtyRegion(x, y,
                                      x + rects.getWidth(i),
                                      y + rects.getHeight(i));
        }
    }

    public void reset() {
        rects.clear();
        dirtyArea.clear();
    }

    public void translate(int x, int y) {
        if (rects.getSize() > 0) {
            dirtyArea.translate(x, y);
        }
        rects.translateRects(x, y);
    }

    public GrowableRectArray getRects() {
        return rects;
    }

    public DirtyRegion getDirtyArea() {
        return dirtyArea;
    }
}
