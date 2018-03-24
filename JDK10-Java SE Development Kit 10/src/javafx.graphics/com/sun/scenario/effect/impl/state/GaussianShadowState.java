/*
 * Copyright (c) 2009, 2014, Oracle and/or its affiliates. All rights reserved.
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

import com.sun.scenario.effect.Color4f;

/**
 * The helper class for defining a 1 dimensional linear convolution shadow
 * kernel for the Gaussian Shadow shader.  This class leverages the
 * {@link GaussianBlurState} class for defining the kernel and simply stores
 * additional {@code shadowColor} and {@code spread} properties for the
 * associated support methods for the shadow version of the shader.
 */
public class GaussianShadowState extends GaussianBlurState {
    private Color4f shadowColor;
    private float spread;

    @Override
    void checkRadius(float radius) {
        if (radius < 0f || radius > 127f) {
            throw new IllegalArgumentException("Radius must be in the range [1,127]");
        }
    }

    @Override
    public Color4f getShadowColor() {
        return shadowColor;
    }

    public void setShadowColor(Color4f shadowColor) {
        if (shadowColor == null) {
            throw new IllegalArgumentException("Color must be non-null");
        }
        this.shadowColor = shadowColor;
    }

    @Override
    public float getSpread() {
        return spread;
    }

    public void setSpread(float spread) {
        if (spread < 0f || spread > 1f) {
            throw new IllegalArgumentException("Spread must be in the range [0,1]");
        }
        this.spread = spread;
    }

    @Override
    public boolean isNop() {
        // The shadow operation is never a NOP since it replaces the colors
        // if nothing else.
        return false;
    }

    @Override
    public boolean isShadow() {
        return true;
    }
}
