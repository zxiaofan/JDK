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

public final class RadialGradient extends Gradient {

    private final float centerX;
    private final float centerY;
    private final float focusAngle;
    private final float focusDistance;
    private final float radius;

    public RadialGradient(float centerX, float centerY,
                          float focusAngle, float focusDistance,
                          float radius,
                          BaseTransform gradientTransform,
                          boolean proportional,
                          int spreadMethod,
                          List<Stop> stops)
    {
        super(Type.RADIAL_GRADIENT, gradientTransform, proportional, spreadMethod, stops);
        this.centerX = centerX;
        this.centerY = centerY;
        this.focusAngle = focusAngle;
        this.focusDistance = focusDistance;
        this.radius = radius;
    }

    public float getCenterX() {
        return centerX;
    }

    public float getCenterY() {
        return centerY;
    }

    public float getFocusAngle() {
        return focusAngle;
    }

    public float getFocusDistance() {
        return focusDistance;
    }

    public float getRadius() {
        return radius;
    }

    @Override
    public String toString()
    {
        return "RadialGradient: FocusAngle: "+focusAngle+" FocusDistance: "+focusDistance+
               " CenterX: "+centerX+" CenterY "+centerY+
               " Radius: "+radius+"stops:"+getStops();
    }
}
