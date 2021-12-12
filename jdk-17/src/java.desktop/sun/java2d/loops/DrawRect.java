/*
 * Copyright (c) 1997, 2021, Oracle and/or its affiliates. All rights reserved.
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
 * @author Charlton Innovations, Inc.
 */

package sun.java2d.loops;

import sun.java2d.SunGraphics2D;
import sun.java2d.SurfaceData;

/**
 *   DrawRect
 *   1) draw single-width line rectangle onto destination surface
 *   2) must accept output area [x, y, dx, dy]
 *      from within the surface description data for clip rect
 */
public class DrawRect extends GraphicsPrimitive
{
    public static final String methodSignature = "DrawRect(...)".toString();

    public static final int primTypeID = makePrimTypeID();

    public static DrawRect locate(SurfaceType srctype,
                                  CompositeType comptype,
                                  SurfaceType dsttype)
    {
        return (DrawRect)
            GraphicsPrimitiveMgr.locate(primTypeID,
                                        srctype, comptype, dsttype);
    }

    protected DrawRect(SurfaceType srctype,
                       CompositeType comptype,
                       SurfaceType dsttype)
    {
        super(methodSignature, primTypeID, srctype, comptype, dsttype);
    }

    public DrawRect(long pNativePrim,
                    SurfaceType srctype,
                    CompositeType comptype,
                    SurfaceType dsttype)
    {
        super(pNativePrim, methodSignature, primTypeID, srctype, comptype, dsttype);
    }

    /**
     *   All DrawRect implementors must have this invoker method
     */
    public native void DrawRect(SunGraphics2D sg2d, SurfaceData dest,
                                int x1, int y1, int w, int h);

    public GraphicsPrimitive traceWrap() {
        return new TraceDrawRect(this);
    }

    private static class TraceDrawRect extends DrawRect {
        DrawRect target;

        public TraceDrawRect(DrawRect target) {
            super(target.getSourceType(),
                  target.getCompositeType(),
                  target.getDestType());
            this.target = target;
        }

        public GraphicsPrimitive traceWrap() {
            return this;
        }

        public void DrawRect(SunGraphics2D sg2d, SurfaceData dest,
                             int x1, int y1, int w, int h)
        {
            tracePrimitive(target);
            target.DrawRect(sg2d, dest, x1, y1, w, h);
        }
    }
}
