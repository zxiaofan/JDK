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

import com.sun.javafx.geom.Rectangle;
import com.sun.javafx.geom.transform.BaseTransform;
import com.sun.scenario.effect.impl.state.RenderState;

/**
 * An effect that filters out (i.e., replaces with a transparent value) all
 * pixels with brightness lower than the configurable threshold value.
 */
public class Brightpass extends CoreEffect<RenderState> {

    private float threshold;

    /**
     * Constructs a new {@code Brightpass} effect with the default
     * threshold value (0.3), using the default input for source data.
     * This is a shorthand equivalent to:
     * <pre>
     *     new Brightpass(DefaultInput)
     * </pre>
     */
    public Brightpass() {
        this(DefaultInput);
    }

    /**
     * Constructs a new {@code Brightpass} effect with the default
     * threshold value (0.3).
     *
     * @param input the single input {@code Effect}
     * @throws IllegalArgumentException if {@code input} is null
     */
    public Brightpass(Effect input) {
        super(input);
        setThreshold(0.3f);
        updatePeerKey("Brightpass");
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
     * Sets the input for this {@code Effect}.
     *
     * @param input the input for this {@code Effect}
     * @throws IllegalArgumentException if {@code input} is null
     */
    public void setInput(Effect input) {
        setInput(0, input);
    }

    /**
     * Returns the threshold, which controls which pixels are included in
     * the resulting image.  Pixel values with brightness greater than
     * this threshold value will be included.
     *
     * @return the threshold value
     */
    public float getThreshold() {
        return threshold;
    }

    /**
     * Sets the threshold, which controls which pixels are included in
     * the resulting image.  Pixel values with brightness greater than
     * this threshold value will be included.
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
        if (threshold < 0f || threshold > 1f) {
            throw new IllegalArgumentException("Threshold must be in the range [0,1]");
        }
        float old = this.threshold;
        this.threshold = threshold;
    }

    @Override
    public RenderState getRenderState(FilterContext fctx,
                                      BaseTransform transform,
                                      Rectangle outputClip,
                                      Object renderHelper,
                                      Effect defaultInput)
    {
        return RenderState.RenderSpaceRenderState;
    }

    @Override
    public boolean reducesOpaquePixels() {
        return true;
    }

}
