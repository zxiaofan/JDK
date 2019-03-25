/*
 * Copyright (c) 1998, 2002, Oracle and/or its affiliates. All rights reserved.
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

package sun.java2d.loops;

import java.awt.image.ColorModel;
import java.awt.Color;
import java.awt.Composite;
import java.awt.CompositeContext;
import java.awt.RenderingHints;
import sun.java2d.SurfaceData;
import sun.java2d.SunCompositeContext;

/**
 * Bitwise XOR Composite class.
 */

public final class XORComposite implements Composite {

    Color xorColor;
    int xorPixel;
    int alphaMask;

    public XORComposite(Color xorColor, SurfaceData sd) {
        this.xorColor = xorColor;

        SurfaceType sType = sd.getSurfaceType();

        this.xorPixel = sd.pixelFor(xorColor.getRGB());
        this.alphaMask = sType.getAlphaMask();
    }

    public Color getXorColor() {
        return xorColor;
    }

    public int getXorPixel() {
        return xorPixel;
    }

    public int getAlphaMask() {
        return alphaMask;
    }

    public CompositeContext createContext(ColorModel srcColorModel,
                                          ColorModel dstColorModel,
                                          RenderingHints hints) {
        return new SunCompositeContext(this, srcColorModel, dstColorModel);
    }
}
