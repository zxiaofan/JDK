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

package com.sun.scenario.effect;

/**
 * An implementation supertype for both Gaussian and Box filter based
 * shadows to facilitate their conditional usage inside the various
 * composite shadow effects like DropShadow and InnerShadow.
 *
 * The radius, width and height parameters all refer to the corresponding
 * dimension that a "Gaussian" blur filter would use - other shadow
 * implementations will have to use whatever parameters produce a
 * similar effect.
 * The width and height parameters should relate to the radius parameter
 * by the equation {@code w,h = 2 * r + 1} and if the width and height are
 * set to something different then the radius parameter will be an average
 * of the corresponding individual dimensional radius values.
 */
public abstract class AbstractShadow extends LinearConvolveCoreEffect {
    public AbstractShadow(Effect input) {
        super(input);
    }

    public enum ShadowMode {
        ONE_PASS_BOX,
        TWO_PASS_BOX,
        THREE_PASS_BOX,
        GAUSSIAN,
    }

    public abstract ShadowMode getMode();
    public abstract AbstractShadow implFor(ShadowMode m);
    public abstract float getGaussianRadius();
    public abstract void  setGaussianRadius(float r);
    public abstract float getGaussianWidth();
    public abstract void  setGaussianWidth(float w);
    public abstract float getGaussianHeight();
    public abstract void  setGaussianHeight(float h);
    public abstract float getSpread();
    public abstract void  setSpread(float spread);
    public abstract Color4f getColor();
    public abstract void setColor(Color4f c);
    public abstract Effect getInput();
    public abstract void setInput(Effect input);
}
