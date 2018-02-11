/*
 * Copyright (c) 2011, 2014, Oracle and/or its affiliates. All rights reserved.
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

package com.sun.scenario.effect.impl.state;

import com.sun.javafx.geom.Rectangle;
import com.sun.javafx.geom.transform.BaseTransform;

public class MotionBlurState extends LinearConvolveKernel {
    private float radius;
    private float angle;

    public float getRadius() {
        return radius;
    }

    public void setRadius(float radius) {
        if (radius < 0f || radius > 63f) {
            throw new IllegalArgumentException("Radius must be in the range [0,63]");
        }
        this.radius = radius;
    }

    public float getAngle() {
        return angle;
    }

    public void setAngle(float angle) {
        this.angle = angle;
    }

    public int getHPad() {
        return (int) Math.ceil(Math.abs(Math.cos(angle)) * radius);
    }

    public int getVPad() {
        return (int) Math.ceil(Math.abs(Math.sin(angle)) * radius);
    }

    @Override
    public LinearConvolveRenderState getRenderState(BaseTransform filtertx) {
        float dx = (float) Math.cos(angle);
        float dy = (float) Math.sin(angle);
        return new GaussianRenderState(radius, dx, dy, filtertx);
    }

    @Override
    public boolean isNop() {
        return (radius == 0f);
    }

    @Override
    public int getKernelSize(int pass) {
        return ((int) Math.ceil(radius)) * 2 + 1;
    }

    @Override
    public final Rectangle getResultBounds(Rectangle srcdimension, int pass) {
        Rectangle ret = new Rectangle(srcdimension);
        ret.grow(getHPad(), getVPad());
        return ret;
    }
}
