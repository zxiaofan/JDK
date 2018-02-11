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

import com.sun.javafx.geom.Rectangle;
import com.sun.javafx.geom.transform.BaseTransform;

/**
 * The helper class for defining a 1 dimensional linear convolution kernel
 * for either the LinearConvolve or LinearConvolveShadow shaders.
 * This class is abstract and must be subclassed for specific linear
 * convolutions.
 */
public abstract class LinearConvolveKernel {
    /**
     * Returns true if this is a LinearConvolveShadow operation, or false
     * if the operation is a regular LinearConvolve.
     *
     * @return true if this is a Shadow operation
     */
    public boolean isShadow() {
        return false;
    }

    /**
     * Returns true if the entire operation of this linear convolution
     * would have no effect on the source data.
     *
     * @return true if the operation is a NOP
     */
    public boolean isNop() {
        return false;
    }

    /**
     * Returns the size of the output image needed for a given input
     * image dimensions and a given pass of the algorithm.
     *
     * @param srcdimension the bounds of the input image
     * @param pass the algorithm pass being performed
     * @return the bounds of the result image
     */
    public abstract Rectangle getResultBounds(Rectangle srcdimension, int pass);

    /**
     * Returns the size of the kernel for a given pass.
     *
     * @param pass the pass of the algorithm being performed
     * @return the size of the kernel for the given pass
     */
    public abstract int getKernelSize(int pass);

    public abstract LinearConvolveRenderState getRenderState(BaseTransform filtertx);
}
