/*
 * Copyright (c) 1998, 2021, Oracle and/or its affiliates. All rights reserved.
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
 * @author Jim Graham
 * @author Charlton Innovations, Inc.
 */

package sun.java2d.loops;

import sun.java2d.SunGraphics2D;
import sun.java2d.SurfaceData;
import sun.java2d.pipe.SpanIterator;

/**
 * FillSpans
 * 1) draw solid color onto destination surface
 * 2) rectangular areas to fill come from SpanIterator
 */
public class FillSpans extends GraphicsPrimitive
{
    public static final String methodSignature = "FillSpans(...)".toString();

    public static final int primTypeID = makePrimTypeID();

    public static FillSpans locate(SurfaceType srctype,
                                   CompositeType comptype,
                                   SurfaceType dsttype)
    {
        return (FillSpans)
            GraphicsPrimitiveMgr.locate(primTypeID,
                                        srctype, comptype, dsttype);
    }

    protected FillSpans(SurfaceType srctype,
                        CompositeType comptype,
                        SurfaceType dsttype)
    {
        super(methodSignature, primTypeID, srctype, comptype, dsttype);
    }

    public FillSpans(long pNativePrim,
                     SurfaceType srctype,
                     CompositeType comptype,
                     SurfaceType dsttype)
    {
        super(pNativePrim, methodSignature, primTypeID, srctype, comptype, dsttype);
    }

    private native void FillSpans(SunGraphics2D sg2d, SurfaceData dest,
                                  int pixel, long pIterator, SpanIterator si);

    /**
     * All FillSpan implementors must have this invoker method
     */
    public void FillSpans(SunGraphics2D sg2d, SurfaceData dest,
                          SpanIterator si)
    {
        FillSpans(sg2d, dest, sg2d.pixel, si.getNativeIterator(), si);
    }

    public GraphicsPrimitive traceWrap() {
        return new TraceFillSpans(this);
    }

    private static class TraceFillSpans extends FillSpans {
        FillSpans target;

        public TraceFillSpans(FillSpans target) {
            super(target.getSourceType(),
                  target.getCompositeType(),
                  target.getDestType());
            this.target = target;
        }

        public GraphicsPrimitive traceWrap() {
            return this;
        }

        public void FillSpans(SunGraphics2D sg2d, SurfaceData dest,
                              SpanIterator si)
        {
            tracePrimitive(target);
            target.FillSpans(sg2d, dest, si);
        }
    }
}
