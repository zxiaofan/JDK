/*
 * Copyright (c) 2010, Oracle and/or its affiliates. All rights reserved.
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

import java.awt.Color;
import java.awt.Transparency;
import sun.java2d.SurfaceData;
import sun.java2d.SurfaceDataProxy;
import sun.java2d.loops.CompositeType;

/**
 * The proxy class contains the logic if to replace a SurfaceData with a
 * cached X11 Pixmap and the code to create the accelerated surfaces.
 */
public class XRSurfaceDataProxy extends SurfaceDataProxy implements Transparency {

    public static SurfaceDataProxy createProxy(SurfaceData srcData,
            XRGraphicsConfig dstConfig) {

        /*Don't cache already native surfaces*/
        if (srcData instanceof XRSurfaceData) {
            return UNCACHED;
        }

        return new XRSurfaceDataProxy(dstConfig, srcData.getTransparency());
    }

    XRGraphicsConfig xrgc;
    int transparency;

    public XRSurfaceDataProxy(XRGraphicsConfig x11gc) {
        this.xrgc = x11gc;
    }

    @Override
    public SurfaceData validateSurfaceData(SurfaceData srcData,
            SurfaceData cachedData, int w, int h) {
        if (cachedData == null) {
            try {
                cachedData = XRSurfaceData.createData(xrgc, w, h,
                                                      xrgc.getColorModel(), null, 0,
                                                      getTransparency(), true);
            } catch (OutOfMemoryError oome) {
            }
        }
        return cachedData;
    }

    public XRSurfaceDataProxy(XRGraphicsConfig x11gc, int transparency) {
        this.xrgc = x11gc;
        this.transparency = transparency;
    }

    //TODO: Is that really ok?
    @Override
    public boolean isSupportedOperation(SurfaceData srcData, int txtype,
            CompositeType comp, Color bgColor) {
        return (bgColor == null || transparency == Transparency.TRANSLUCENT);
    }

    public int getTransparency() {
        return transparency;
    }
}
