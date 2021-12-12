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
 *   DrawPolygons
 *   1) draw single-width line polygons onto destination surface
 *   2) must accept output area [x, y, dx, dy]
 *      from within the surface description data for clip rect
 */
public class DrawPolygons extends GraphicsPrimitive
{
    public static final String methodSignature = "DrawPolygons(...)".toString();

    public static final int primTypeID = makePrimTypeID();

    public static DrawPolygons locate(SurfaceType srctype,
                                      CompositeType comptype,
                                      SurfaceType dsttype)
    {
        return (DrawPolygons)
            GraphicsPrimitiveMgr.locate(primTypeID,
                                        srctype, comptype, dsttype);
    }

    protected DrawPolygons(SurfaceType srctype,
                           CompositeType comptype,
                           SurfaceType dsttype)
    {
        super(methodSignature, primTypeID, srctype, comptype, dsttype);
    }

    public DrawPolygons(long pNativePrim,
                        SurfaceType srctype,
                        CompositeType comptype,
                        SurfaceType dsttype)
    {
        super(pNativePrim, methodSignature, primTypeID, srctype, comptype, dsttype);
    }

    /**
     *   All DrawPolygon implementors must have this invoker method
     */
    public native void DrawPolygons(SunGraphics2D sg2d, SurfaceData sData,
                                    int[] xPoints, int[] yPoints,
                                    int[] nPoints, int numPolys,
                                    int transX, int transY,
                                    boolean close);

    public GraphicsPrimitive traceWrap() {
        return new TraceDrawPolygons(this);
    }

    private static class TraceDrawPolygons extends DrawPolygons {
        DrawPolygons target;

        public TraceDrawPolygons(DrawPolygons target) {
            super(target.getSourceType(),
                  target.getCompositeType(),
                  target.getDestType());
            this.target = target;
        }

        public GraphicsPrimitive traceWrap() {
            return this;
        }

        public void DrawPolygons(SunGraphics2D sg2d, SurfaceData sData,
                                 int[] xPoints, int[] yPoints,
                                 int[] nPoints, int numPolys,
                                 int transX, int transY,
                                 boolean close)
        {
            tracePrimitive(target);
            target.DrawPolygons(sg2d, sData,
                                xPoints, yPoints, nPoints, numPolys,
                                transX, transY, close);
        }
    }
}
