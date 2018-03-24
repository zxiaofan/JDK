/*
 * Copyright (c) 2008, 2013, Oracle and/or its affiliates. All rights reserved.
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
 * An immutable color, represented by four floating point values.
 * The color components should be provided in non-premultiplied format.
 */
public final class Color4f {

    public static final Color4f BLACK = new Color4f(0f, 0f, 0f, 1f);
    public static final Color4f WHITE = new Color4f(1f, 1f, 1f, 1f);

    private final float r;
    private final float g;
    private final float b;
    private final float a;

    public Color4f(float r, float g, float b, float a) {
        this.r = r;
        this.g = g;
        this.b = b;
        this.a = a;
    }

    public float getRed() {
        return r;
    }

    public float getGreen() {
        return g;
    }

    public float getBlue() {
        return b;
    }

    public float getAlpha() {
        return a;
    }

    /**
     * Calculates and return the premultiplied color components of a
     * this {@code Color4f} object in an array of 4 {@code float}s.
     * @return an array of 4 {@code float}s containing the premultiplied
     *         color components of the color.
     */
    public float[] getPremultipliedRGBComponents() {
        float[] comps = new float[4];
        comps[0] = r*a;
        comps[1] = g*a;
        comps[2] = b*a;
        comps[3] = a;
        return comps;
    }
}
