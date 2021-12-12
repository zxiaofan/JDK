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
 * DrawParallelogram
 * 1) fill the area between the 4 edges of an outer parallelogram
 *    (as specified by an origin and 2 delta vectors)
 *    but also outside the 4 edges of an inner parallelogram
 *    (as specified by proportional amounts of the outer delta vectors)
 */
public class DrawParallelogram extends GraphicsPrimitive
{
    public static final String methodSignature =
        "DrawParallelogram(...)".toString();

    public static final int primTypeID = makePrimTypeID();

    public static DrawParallelogram locate(SurfaceType srctype,
                                           CompositeType comptype,
                                           SurfaceType dsttype)
    {
        return (DrawParallelogram)
            GraphicsPrimitiveMgr.locate(primTypeID,
                                        srctype, comptype, dsttype);
    }

    protected DrawParallelogram(SurfaceType srctype,
                                CompositeType comptype,
                                SurfaceType dsttype)
    {
        super(methodSignature, primTypeID,
              srctype, comptype, dsttype);
    }

    public DrawParallelogram(long pNativePrim,
                             SurfaceType srctype,
                             CompositeType comptype,
                             SurfaceType dsttype)
    {
        super(pNativePrim, methodSignature, primTypeID,
              srctype, comptype, dsttype);
    }

    /**
     * All DrawParallelogram implementors must have this invoker method
     */
    public native void DrawParallelogram(SunGraphics2D sg, SurfaceData dest,
                                         double x, double y,
                                         double dx1, double dy1,
                                         double dx2, double dy2,
                                         double lw1, double lw2);

    public GraphicsPrimitive traceWrap() {
        return new TraceDrawParallelogram(this);
    }

    private static class TraceDrawParallelogram extends DrawParallelogram {
        DrawParallelogram target;

        public TraceDrawParallelogram(DrawParallelogram target) {
            super(target.getSourceType(),
                  target.getCompositeType(),
                  target.getDestType());
            this.target = target;
        }

        public GraphicsPrimitive traceWrap() {
            return this;
        }

        public void DrawParallelogram(SunGraphics2D sg2d, SurfaceData dest,
                                      double x, double y,
                                      double dx1, double dy1,
                                      double dx2, double dy2,
                                      double lw1, double lw2)
        {
            tracePrimitive(target);
            target.DrawParallelogram(sg2d, dest,
                                     x, y, dx1, dy1, dx2, dy2, lw1, lw2);
        }
    }
}
