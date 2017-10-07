/*
 * Copyright (c) 2009, 2013, Oracle and/or its affiliates. All rights reserved.
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

package com.sun.prism.paint;

import com.sun.javafx.geom.transform.BaseTransform;
import java.util.List;

public final class LinearGradient extends Gradient {

    private float x1;
    private float y1;
    private float x2;
    private float y2;

    public LinearGradient(float x1, float y1,
                          float x2, float y2,
                          BaseTransform gradientTransform,
                          boolean proportional,
                          int spreadMethod,
                          List<Stop> stops)
    {
        super(Type.LINEAR_GRADIENT, gradientTransform, proportional, spreadMethod, stops);
        this.x1 = x1;
        this.y1 = y1;
        this.x2 = x2;
        this.y2 = y2;
    }

    public float getX1() { return x1; }
    public float getY1() { return y1; }
    public float getX2() { return x2; }
    public float getY2() { return y2; }
}
