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
 *   DrawLine
 *   1) draw solid color single width line onto destination surface
 *   2) must accept output area [x, y, dx, dy]
 *      from within the surface description data for clip rect
 */
public class DrawLine extends GraphicsPrimitive
{
    public static final String methodSignature = "DrawLine(...)".toString();

    public static final int primTypeID = makePrimTypeID();

    public static DrawLine locate(SurfaceType srctype,
                                  CompositeType comptype,
                                  SurfaceType dsttype)
    {
        return (DrawLine) GraphicsPrimitiveMgr.locate(primTypeID,
                                                      srctype, comptype, dsttype);
    }

    protected DrawLine(SurfaceType srctype,
                       CompositeType comptype,
                       SurfaceType dsttype)
    {
        super(methodSignature, primTypeID, srctype, comptype, dsttype);
    }

    public DrawLine(long pNativePrim,
                    SurfaceType srctype,
                    CompositeType comptype,
                    SurfaceType dsttype)
    {
        super(pNativePrim, methodSignature, primTypeID, srctype, comptype, dsttype);
    }

    /**
     *   All DrawLine implementors must have this invoker method
     */
    public native void DrawLine(SunGraphics2D sg2d, SurfaceData dest,
                                int x1, int y1, int x2, int y2);

    public GraphicsPrimitive traceWrap() {
        return new TraceDrawLine(this);
    }

    private static class TraceDrawLine extends DrawLine {
        DrawLine target;

        public TraceDrawLine(DrawLine target) {
            super(target.getSourceType(),
                  target.getCompositeType(),
                  target.getDestType());
            this.target = target;
        }

        public GraphicsPrimitive traceWrap() {
            return this;
        }

        public void DrawLine(SunGraphics2D sg2d, SurfaceData dest,
                             int x1, int y1, int x2, int y2)
        {
            tracePrimitive(target);
            target.DrawLine(sg2d, dest, x1, y1, x2, y2);
        }
    }
}
