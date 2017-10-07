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

import com.sun.javafx.geom.CubicCurve2D;
import com.sun.javafx.geom.Shape;

/**
 *
 */
public class NGCubicCurve extends NGShape {
    private CubicCurve2D curve = new CubicCurve2D();

    @Override public final Shape getShape() { return curve; }
    public void updateCubicCurve(
            float x1, float y1, float x2, float y2,
            float ctrlx1, float ctrly1, float ctrlx2, float ctrly2) {
        curve.x1 = x1;
        curve.y1 = y1;
        curve.x2 = x2;
        curve.y2 = y2;
        curve.ctrlx1 = ctrlx1;
        curve.ctrly1 = ctrly1;
        curve.ctrlx2 = ctrlx2;
        curve.ctrly2 = ctrly2;
        geometryChanged();
    }
}
