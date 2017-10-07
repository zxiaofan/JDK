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

package com.sun.scenario.effect.impl.state;

import com.sun.scenario.effect.ZoomRadialBlur;

public class ZoomRadialBlurState {

    private float dx = -1f;
    private float dy = -1f;
    private final ZoomRadialBlur effect;

    public ZoomRadialBlurState(ZoomRadialBlur effect) {
        this.effect = effect;
    }

    public int getRadius() {
        return effect.getRadius();
    }

    /**
     * Updates offsets by X and Y axes.
     */
    public void updateDeltas(float dx, float dy) {
        this.dx = dx;
        this.dy = dy;
    }

    /**
     * Invalidates X and Y offsets.
     */
    public void invalidateDeltas() {
        this.dx = -1f;
        this.dy = -1f;
    }

    /**
     * Returns offset by X axis to the next pixel
     * @return offset by X axis to the next pixel
     */
    public float getDx() {
        return dx;
    }

    /**
     * Returns offset by Y axis to the next pixel
     * @return offset by Y axis to the next pixel
     */
    public float getDy() {
        return dy;
    }

    public int getNumSteps() {
        int r = getRadius();
        return r * 2 + 1;
    }

    public float getAlpha() {
        float r = getRadius();
        return 1.0f/(2.0f*r + 1.0f);
    }
}
