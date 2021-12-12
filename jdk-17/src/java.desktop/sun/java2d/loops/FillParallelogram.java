/*
 * Copyright (c) 2008, 2021, Oracle and/or its affiliates. All rights reserved.
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
 */

package sun.java2d.loops;

import sun.java2d.SunGraphics2D;
import sun.java2d.SurfaceData;

/**
 * FillParallelogram
 * 1) fill the area between the 4 edges of a parallelogram
 *    (as specified by an origin and 2 delta vectors)
 */
public class FillParallelogram extends GraphicsPrimitive
{
    public static final String methodSignature =
        "FillParallelogram(...)".toString();

    public static final int primTypeID = makePrimTypeID();

    public static FillParallelogram locate(SurfaceType srctype,
                                           CompositeType comptype,
                                           SurfaceType dsttype)
    {
        return (FillParallelogram)
            GraphicsPrimitiveMgr.locate(primTypeID,
                                        srctype, comptype, dsttype);
    }

    protected FillParallelogram(SurfaceType srctype,
                                CompositeType comptype,
                                SurfaceType dsttype)
    {
        super(methodSignature, primTypeID,
              srctype, comptype, dsttype);
    }

    public FillParallelogram(long pNativePrim,
                             SurfaceType srctype,
                             CompositeType comptype,
                             SurfaceType dsttype)
    {
        super(pNativePrim, methodSignature, primTypeID,
              srctype, comptype, dsttype);
    }

    /**
     * All FillParallelogram implementors must have this invoker method
     */
    public native void FillParallelogram(SunGraphics2D sg2d, SurfaceData dest,
                                         double x0, double y0,
                                         double dx1, double dy1,
                                         double dx2, double dy2);

    public GraphicsPrimitive traceWrap() {
        return new TraceFillParallelogram(this);
    }

    private static class TraceFillParallelogram extends FillParallelogram {
        FillParallelogram target;

        public TraceFillParallelogram(FillParallelogram target) {
            super(target.getSourceType(),
                  target.getCompositeType(),
                  target.getDestType());
            this.target = target;
        }

        public GraphicsPrimitive traceWrap() {
            return this;
        }

        public void FillParallelogram(SunGraphics2D sg2d, SurfaceData dest,
                                      double x0, double y0,
                                      double dx1, double dy1,
                                      double dx2, double dy2)
        {
            tracePrimitive(target);
            target.FillParallelogram(sg2d, dest, x0, y0, dx1, dy1, dx2, dy2);
        }
    }
}
