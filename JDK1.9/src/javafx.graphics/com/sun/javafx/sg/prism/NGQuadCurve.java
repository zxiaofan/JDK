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

import com.sun.javafx.geom.QuadCurve2D;
import com.sun.javafx.geom.Shape;

/**
 *
 */
public class NGQuadCurve extends NGShape {
    private QuadCurve2D curve = new QuadCurve2D();

    @Override public final Shape getShape() { return curve; }
    public void updateQuadCurve(float x1, float y1, float x2, float y2, float ctrlx, float ctrly) {
        curve.x1 = x1;
        curve.y1 = y1;
        curve.x2 = x2;
        curve.y2 = y2;
        curve.ctrlx = ctrlx;
        curve.ctrly = ctrly;
        geometryChanged();
    }
}
