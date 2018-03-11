/*
 * %W% %E%
 *
 * Copyright (c) 2006, Oracle and/or its affiliates. All rights reserved.
 * ORACLE PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */



package java.awt;

import java.awt.image.ColorModel;
import java.awt.image.Raster;
import java.awt.image.WritableRaster;
import sun.awt.image.IntegerComponentRaster;
import java.util.Arrays;

class ColorPaintContext implements PaintContext {
    int color;
    WritableRaster savedTile;

    protected ColorPaintContext(int color, ColorModel cm) {
        this.color = color;
    }

    public void dispose() {
    }

    public ColorModel getColorModel() {
	return ColorModel.getRGBdefault();
    }

    public synchronized Raster getRaster(int x, int y, int w, int h) {
	WritableRaster t = savedTile;

        if (t == null || w > t.getWidth() || h > t.getHeight()) {
            t = getColorModel().createCompatibleWritableRaster(w, h);
	    IntegerComponentRaster icr = (IntegerComponentRaster) t;
	    int[] array = icr.getDataStorage();
	    Arrays.fill(icr.getDataStorage(), color);
		    if (w <= 64 && h <= 64) {
		savedTile = t;
	    }
        }

        return t;
    }
}
