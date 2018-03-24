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

import com.sun.javafx.geom.Point2D;

/**
 * A high-level effect that makes brighter portions of the input image
 * appear to glow, based on a configurable threshold.
 */
public class Bloom extends DelegateEffect {

    private final Brightpass brightpass;
    private final GaussianBlur blur;
    private final Blend blend;

    /**
     * Constructs a new {@code Bloom} effect with the default threshold (0.3),
     * using the default input for source data.
     * This is a shorthand equivalent to:
     * <pre>
     *     new Bloom(DefaultInput)
     * </pre>
     */
    public Bloom() {
        this(DefaultInput);
    }

    /**
     * Constructs a new {@code Bloom} effect with the default threshold (0.3).
     *
     * @param input the single input {@code Effect} or {@code null} if the
     *              default input should be used
     */
    public Bloom(Effect input) {
        super(input);

        //
        //    (input)
        //       |
        //   Brightpass
        //       |
        //  GaussianBlur
        //       |
        //       Crop   (input)
        //          |   |
        //          Blend
        //            |
        //
        this.brightpass = new Brightpass(input);
        this.blur = new GaussianBlur(10f, brightpass);
        // crop to prevent blur fringes from being included in final result
        Crop crop = new Crop(blur, input);
        this.blend = new Blend(Blend.Mode.ADD, input, crop);
    }

    protected Effect getDelegate() {
        return blend;
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
     * Sets the input for this {@code Effect} to a specific
     * {@code Effect} or to the default input if {@code input} is
     * {@code null}.
     *
     * @param input the input for this {@code Effect}
     */
    public void setInput(Effect input) {
        setInput(0, input);
        brightpass.setInput(input);
        blend.setBottomInput(input);
    }

    /**
     * Returns the threshold, which controls the intensity of the glow effect.
     *
     * @return the threshold value
     */
    public float getThreshold() {
        return brightpass.getThreshold();
    }

    /**
     * Sets the threshold, which controls the intensity of the glow effect.
     * <pre>
     *       Min: 0.0
     *       Max: 1.0
     *   Default: 0.3
     *  Identity: n/a
     * </pre>
     *
     * @param threshold the threshold value
     * @throws IllegalArgumentException if {@code threshold} is outside
     * the allowable range
     */
    public void setThreshold(float threshold) {
        float old = brightpass.getThreshold();
        brightpass.setThreshold(threshold);
    }

    @Override
    public Point2D transform(Point2D p, Effect defaultInput) {
        return getDefaultedInput(0, defaultInput).transform(p, defaultInput);
    }

    @Override
    public Point2D untransform(Point2D p, Effect defaultInput) {
        return getDefaultedInput(0, defaultInput).untransform(p, defaultInput);
    }
}
