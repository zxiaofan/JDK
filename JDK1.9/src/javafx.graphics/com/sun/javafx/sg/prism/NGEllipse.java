/*
 * Copyright (c) 2011, 2013, Oracle and/or its affiliates. All rights reserved.
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

package com.sun.javafx.sg.prism;

import com.sun.javafx.geom.Ellipse2D;
import com.sun.javafx.geom.RectBounds;
import com.sun.javafx.geom.Shape;
import com.sun.prism.Graphics;
import com.sun.prism.shape.ShapeRep;

/**
 */
public class NGEllipse extends NGShape {

    private Ellipse2D ellipse = new Ellipse2D();
    private float cx, cy;

    public void updateEllipse(float cx, float cy, float rx, float ry) {
        ellipse.x = cx - rx;
        ellipse.width = rx * 2f;
        ellipse.y = cy - ry;
        ellipse.height = ry * 2f;
        this.cx = cx;
        this.cy = cy;
        geometryChanged();
    }

    @Override
    public final Shape getShape() {
        return ellipse;
    }

    @Override
    protected ShapeRep createShapeRep(Graphics g) {
        return g.getResourceFactory().createEllipseRep();
    }

    @Override
    protected boolean supportsOpaqueRegions() { return true; }

    @Override
    protected boolean hasOpaqueRegion() {
        return super.hasOpaqueRegion() && ellipse.width > 0 && ellipse.height > 0;
    }

    @Override
    protected RectBounds computeOpaqueRegion(RectBounds opaqueRegion) {
        // An ellipse can be viewed as a circle which has been stretched both
        // horizontally and vertically. We can approach computing the inscribed
        // rectangle in two steps. First, find the length of the inscribed
        // square if you were to have a circle with the diameter of the width
        // of the ellipse. This will give you the width of the rectangle. Second,
        // find the length of the inscribed square if you were to have a circle
        // with a diameter of the height of the ellipse. This gives you the
        // height of the inscribed rectangle.
        final float halfWidth = ellipse.width * NGCircle.HALF_SQRT_HALF;
        final float halfHeight = ellipse.height * NGCircle.HALF_SQRT_HALF;
        return (RectBounds) opaqueRegion.deriveWithNewBounds(
                cx - halfWidth,
                cy - halfHeight, 0,
                cx + halfWidth,
                cy + halfHeight, 0);
    }
}
