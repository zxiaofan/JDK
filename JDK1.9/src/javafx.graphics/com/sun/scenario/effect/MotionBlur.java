/*
 * Copyright (c) 2008, 2014, Oracle and/or its affiliates. All rights reserved.
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

import com.sun.javafx.geom.BaseBounds;
import com.sun.javafx.geom.DirtyRegionContainer;
import com.sun.javafx.geom.DirtyRegionPool;
import com.sun.javafx.geom.RectBounds;
import com.sun.javafx.geom.Rectangle;
import com.sun.javafx.geom.transform.BaseTransform;
import com.sun.scenario.effect.impl.Renderer;
import com.sun.scenario.effect.impl.state.LinearConvolveKernel;
import com.sun.scenario.effect.impl.state.MotionBlurState;

/**
 * A motion blur effect using a Gaussian convolution kernel, with a
 * configurable radius and angle.
 */
public class MotionBlur extends LinearConvolveCoreEffect {

    private MotionBlurState state = new MotionBlurState();

    /**
     * Constructs a new {@code MotionBlur} effect with the default radius
     * (10.0) and default angle (0.0), using the default input for source
     * data.
     * This is a shorthand equivalent to:
     * <pre>
     *     new MotionBlur(10f, 0f, DefaultInput)
     * </pre>
     */
    public MotionBlur() {
        this(10f, 0f, DefaultInput);
    }

    /**
     * Constructs a new {@code MotionBlur} effect with the given radius
     * and angle, using the default input for source data.
     * This is a shorthand equivalent to:
     * <pre>
     *     new MotionBlur(radius, angle, DefaultInput)
     * </pre>
     *
     * @param radius the radius of the Gaussian kernel
     * @param angle the angle of the motion effect, in radians
     * @throws IllegalArgumentException if {@code radius} is outside the
     * allowable range
     */
    public MotionBlur(float radius, float angle) {
        this(radius, angle, DefaultInput);
    }

    /**
     * Constructs a new {@code MotionBlur} effect with the given radius
     * and angle.
     *
     * @param radius the radius of the Gaussian kernel
     * @param angle the angle of the motion effect, in radians
     * @param input the single input {@code Effect}
     * @throws IllegalArgumentException if {@code radius} is outside the
     * allowable range
     */
    public MotionBlur(float radius, float angle, Effect input) {
        super(input);
        setRadius(radius);
        setAngle(angle);
    }

    @Override
    LinearConvolveKernel getState() {
        return state;
    }

    @Override
    public AccelType getAccelType(FilterContext fctx) {
        return Renderer.getRenderer(fctx).getAccelType();
    }

    /**
     * Returns the input for this {@code Effect}.
     *
     * @return the input for this {@code Effect}
     */
    public final Effect getInput() {
        return getInputs().get(0);
    }

    /**
     * Sets the input for this {@code Effect} to a specific {@code Effect}
     * or to the default input if {@code input} is {@code null}.
     *
     * @param input the input for this {@code Effect}
     */
    public void setInput(Effect input) {
        setInput(0, input);
    }

    /**
     * Returns the radius of the Gaussian kernel.
     *
     * @return the radius of the Gaussian kernel
     */
    public float getRadius() {
        return state.getRadius();
    }

    /**
     * Sets the radius of the Gaussian kernel.
     * <pre>
     *       Min:  0.0
     *       Max: 63.0
     *   Default: 10.0
     *  Identity:  0.0
     * </pre>
     *
     * @param radius the radius of the Gaussian kernel
     * @throws IllegalArgumentException if {@code radius} is outside the
     * allowable range
     */
    public void setRadius(float radius) {
        state.setRadius(radius);
    }

    /**
     * Returns the angle of the motion effect, in radians.
     *
     * @return the angle of the motion effect, in radians
     */
    public float getAngle() {
        return state.getAngle();
    }

    /**
     * Sets the angle of the motion effect, in radians.
     * <pre>
     *       Min: n/a
     *       Max: n/a
     *   Default: 0.0
     *  Identity: n/a
     * </pre>
     *
     * @param angle the angle of the motion effect, in radians
     */
    public void setAngle(float angle) {
        state.setAngle(angle);
    }

    @Override
    public BaseBounds getBounds(BaseTransform transform, Effect defaultInput) {
        BaseBounds r = super.getBounds(null, defaultInput);
        int hpad = state.getHPad();
        int vpad = state.getVPad();
        BaseBounds ret = new RectBounds(r.getMinX(), r.getMinY(), r.getMaxX(), r.getMaxY());
        ((RectBounds) ret).grow(hpad, vpad);
        return transformBounds(transform, ret);
    }

    @Override
    public Rectangle getResultBounds(BaseTransform transform,
                                     Rectangle outputClip,
                                     ImageData... inputDatas)
    {
        Rectangle r = super.getResultBounds(transform, outputClip, inputDatas);
        int hpad = state.getHPad();
        int vpad = state.getVPad();
        Rectangle ret = new Rectangle(r);
        ret.grow(hpad, vpad);
        return ret;
    }

    @Override
    public boolean reducesOpaquePixels() {
        if (!state.isNop()) {
            return true;
        }
        final Effect input = getInput();
        return input != null && input.reducesOpaquePixels();
    }

    @Override
    public DirtyRegionContainer getDirtyRegions(Effect defaultInput, DirtyRegionPool regionPool) {
        Effect di = getDefaultedInput(0, defaultInput);
        DirtyRegionContainer drc = di.getDirtyRegions(defaultInput, regionPool);

        drc.grow(state.getHPad(), state.getVPad());

        return drc;
    }
}
