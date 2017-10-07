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
 *
 */
public class NGCircle extends NGShape {
    /**
     * .5 * 1/Math.sqrt(2). If you multiply this value by the diameter of the
     * circle, then you will get half the length of the side of the square which
     * is inscribed within the circle. This is used when computing the opaque region
     * of the circle and ellipse. This value has been precomputed and stored
     * as a constant to make the resulting math faster. It is low in precision
     * to compute a conservative inscribed square.
     */
    static final float HALF_SQRT_HALF = .353f; // really .35355339059327...

    private Ellipse2D ellipse = new Ellipse2D();
    private float cx, cy;

    public void updateCircle(float cx, float cy, float r) {
        ellipse.x = cx - r;
        ellipse.y = cy - r;
        ellipse.width = r * 2f;
        ellipse.height = ellipse.width;
        this.cx = cx;
        this.cy = cy;
        geometryChanged();
    }

    @Override
    public Shape getShape() {
        return ellipse;
    }

    @Override protected boolean supportsOpaqueRegions() { return true; }

    @Override
    protected boolean hasOpaqueRegion() {
        // Since this is a circle, both ellipse.width & ellipse.height are the
        // same, so I can just get away with checking one of them.
        // Although a circle with a very small radius won't produce a very large
        // opaque region on its own, it might be subsequently scaled in which
        // case even a very small radius (like .00001) could become something
        // significant.
        return super.hasOpaqueRegion() && ellipse.width > 0;
    }

    @Override
    protected RectBounds computeOpaqueRegion(RectBounds opaqueRegion) {
        final float halfSquareLength = ellipse.width * HALF_SQRT_HALF;
        return (RectBounds) opaqueRegion.deriveWithNewBounds(
                cx - halfSquareLength,
                cy - halfSquareLength, 0,
                cx + halfSquareLength,
                cy + halfSquareLength, 0);
    }

    @Override
    protected ShapeRep createShapeRep(Graphics g) {
        return g.getResourceFactory().createEllipseRep();
    }
}
