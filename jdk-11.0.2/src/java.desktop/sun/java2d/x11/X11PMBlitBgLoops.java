/*
 * Copyright (c) 2001, 2008, Oracle and/or its affiliates. All rights reserved.
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

package sun.java2d.x11;

import sun.awt.SunToolkit;
import sun.java2d.loops.GraphicsPrimitive;
import sun.java2d.loops.GraphicsPrimitiveMgr;
import sun.java2d.loops.CompositeType;
import sun.java2d.loops.SurfaceType;
import sun.java2d.loops.BlitBg;
import sun.java2d.SurfaceData;
import sun.java2d.pipe.Region;
import java.awt.Color;
import java.awt.Composite;

/**
 * X11PMBlitBgLoops
 *
 * This class accelerates Blits between two surfaces of types *PM.  Since
 * the onscreen surface is of that type and some of the offscreen surfaces
 * may be of that type (if they were created via X11OffScreenImage), then
 * this type of BlitBg will accelerated double-buffer copies between those
 * two surfaces.
*/
public class X11PMBlitBgLoops extends BlitBg {

    public static void register()
    {
        GraphicsPrimitive[] primitives = {
            new X11PMBlitBgLoops(X11SurfaceData.IntBgrX11_BM,
                                 X11SurfaceData.IntBgrX11),
            new X11PMBlitBgLoops(X11SurfaceData.IntRgbX11_BM,
                                 X11SurfaceData.IntRgbX11),
            new X11PMBlitBgLoops(X11SurfaceData.ThreeByteBgrX11_BM,
                                 X11SurfaceData.ThreeByteBgrX11),
            new X11PMBlitBgLoops(X11SurfaceData.ThreeByteRgbX11_BM,
                                 X11SurfaceData.ThreeByteRgbX11),
            new X11PMBlitBgLoops(X11SurfaceData.ByteIndexedX11_BM,
                                 X11SurfaceData.ByteIndexedOpaqueX11),
            new X11PMBlitBgLoops(X11SurfaceData.ByteGrayX11_BM,
                                 X11SurfaceData.ByteGrayX11),
            new X11PMBlitBgLoops(X11SurfaceData.Index8GrayX11_BM,
                                 X11SurfaceData.Index8GrayX11),
            new X11PMBlitBgLoops(X11SurfaceData.UShort555RgbX11_BM,
                                 X11SurfaceData.UShort555RgbX11),
            new X11PMBlitBgLoops(X11SurfaceData.UShort565RgbX11_BM,
                                 X11SurfaceData.UShort565RgbX11),
            new X11PMBlitBgLoops(X11SurfaceData.UShortIndexedX11_BM,
                                 X11SurfaceData.UShortIndexedX11),
            new X11PMBlitBgLoops(X11SurfaceData.IntRgbX11_BM,
                                 X11SurfaceData.IntArgbPreX11),
            new X11PMBlitBgLoops(X11SurfaceData.IntBgrX11_BM,
                                 X11SurfaceData.FourByteAbgrPreX11),
        };
        GraphicsPrimitiveMgr.register(primitives);
    }

    public X11PMBlitBgLoops(SurfaceType srcType, SurfaceType dstType)
    {
        super(srcType, CompositeType.SrcNoEa, dstType);
    }

    @Override
    public void BlitBg(SurfaceData src, SurfaceData dst,
                       Composite comp, Region clip, int bgColor,
                       int sx, int sy,
                       int dx, int dy,
                       int w, int h)
    {
        SunToolkit.awtLock();
        try {
            int pixel = dst.pixelFor(bgColor);
            X11SurfaceData x11sd = (X11SurfaceData)dst;
            // use false for needExposures since we clip to the pixmap
            long xgc = x11sd.getBlitGC(clip, false);
            nativeBlitBg(src.getNativeOps(), dst.getNativeOps(),
                         xgc, pixel,
                         sx, sy, dx, dy, w, h);
        } finally {
            SunToolkit.awtUnlock();
        }
    }

    /**
     * This native method is where all of the work happens in the
     * accelerated Blit.
     */
    private native void nativeBlitBg(long srcData, long dstData,
                                     long xgc, int pixel,
                                     int sx, int sy,
                                     int dx, int dy,
                                     int w, int h);
}
