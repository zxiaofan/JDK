/*
 * Copyright (c) 2001, 2021, Oracle and/or its affiliates. All rights reserved.
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

import java.awt.Composite;

import sun.java2d.SurfaceData;
import sun.java2d.pipe.Region;

/**
 * ScaledBlit
 * 1) copies rectangle of pixels from one surface to another
 *    while scaling the pixels to meet the sizes specified
 * 2) performs compositing of colors based upon a Composite
 *    parameter
 *
 * precise behavior is undefined if the source surface
 * and the destination surface are the same surface
 * with overlapping regions of pixels
 */

public class ScaledBlit extends GraphicsPrimitive
{
    public static final String methodSignature = "ScaledBlit(...)".toString();

    public static final int primTypeID = makePrimTypeID();

    private static RenderCache blitcache = new RenderCache(20);

    public static ScaledBlit locate(SurfaceType srctype,
                              CompositeType comptype,
                              SurfaceType dsttype)
    {
        return (ScaledBlit)
            GraphicsPrimitiveMgr.locate(primTypeID,
                                        srctype, comptype, dsttype);
    }

    public static ScaledBlit getFromCache(SurfaceType src,
                                          CompositeType comp,
                                          SurfaceType dst)
    {
        Object o = blitcache.get(src, comp, dst);
        if (o != null) {
            return (ScaledBlit) o;
        }
        ScaledBlit blit = locate(src, comp, dst);
        if (blit == null) {
            /*
            System.out.println("blit loop not found for:");
            System.out.println("src:  "+src);
            System.out.println("comp: "+comp);
            System.out.println("dst:  "+dst);
            */
        } else {
            blitcache.put(src, comp, dst, blit);
        }
        return blit;
    }

    protected ScaledBlit(SurfaceType srctype,
                   CompositeType comptype,
                   SurfaceType dsttype)
    {
        super(methodSignature, primTypeID, srctype, comptype, dsttype);
    }

    public ScaledBlit(long pNativePrim,
                      SurfaceType srctype,
                      CompositeType comptype,
                      SurfaceType dsttype)
    {
        super(pNativePrim, methodSignature, primTypeID,
              srctype, comptype, dsttype);
    }

    public native void Scale(SurfaceData src, SurfaceData dst,
                             Composite comp, Region clip,
                             int sx1, int sy1,
                             int sx2, int sy2,
                             double dx1, double dy1,
                             double dx2, double dy2);

    public GraphicsPrimitive traceWrap() {
        return new TraceScaledBlit(this);
    }

    private static class TraceScaledBlit extends ScaledBlit {
        ScaledBlit target;

        public TraceScaledBlit(ScaledBlit target) {
            super(target.getSourceType(),
                  target.getCompositeType(),
                  target.getDestType());
            this.target = target;
        }

        public GraphicsPrimitive traceWrap() {
            return this;
        }

        public void Scale(SurfaceData src, SurfaceData dst,
                          Composite comp, Region clip,
                          int sx1, int sy1,
                          int sx2, int sy2,
                          double dx1, double dy1,
                          double dx2, double dy2)
        {
            tracePrimitive(target);
            target.Scale(src, dst, comp, clip,
                         sx1, sy1, sx2, sy2,
                         dx1, dy1, dx2, dy2);
        }
    }
}
