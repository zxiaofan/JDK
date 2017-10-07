/*
 * Copyright (c) 2010, 2013, Oracle and/or its affiliates. All rights reserved.
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

import com.sun.javafx.geom.transform.BaseTransform;

/**
 * An interface for supplying an object which can simplify effect
 * chains by rendering some intermediate images directly from the
 * implementations of the effects.
 */
public interface ImageDataRenderer {
    /**
     * Renders the indicated {@link ImageData} to the output with the
     * indicated transform using BILINEAR filtering.
     * This method should only be used by an {@link Effect} if there is only
     * a single output or if there are multiple outputs which would have
     * otherwise been combined into a single output using the Porter-Duff
     * SrcOver composite mode.
     * If this method is used to render all image results of an effect
     * operation then the effect may return null as its output result.
     * This method should not save a reference to or modify the reference
     * count on the {@code ImageData} argument.
     */
    public void renderImage(ImageData image,
                            BaseTransform transform,
                            FilterContext fctx);
}
