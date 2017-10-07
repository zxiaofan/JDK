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

import com.sun.javafx.geom.transform.BaseTransform;
import com.sun.scenario.effect.Color4f;

/**
 * The state and implementation class for calculating 1 dimensional
 * linear convolution kernels for performing multi-pass box blurs.
 */
public class BoxBlurState extends HVSeparableKernel {
    private int hsize;
    private int vsize;
    private int blurPasses;

    public int getHsize() {
        return hsize;
    }

    public void setHsize(int hsize) {
        if (hsize < 0 || hsize > 255) {
            throw new IllegalArgumentException("Blur size must be in the range [0,255]");
        }
        this.hsize = hsize;
    }

    public int getVsize() {
        return vsize;
    }

    public void setVsize(int vsize) {
        if (vsize < 0 || vsize > 255) {
            throw new IllegalArgumentException("Blur size must be in the range [0,255]");
        }
        this.vsize = vsize;
    }

    public int getBlurPasses() {
        return blurPasses;
    }

    public void setBlurPasses(int blurPasses) {
        if (blurPasses < 0 || blurPasses > 3) {
            throw new IllegalArgumentException("Number of passes must be in the range [0,3]");
        }
        this.blurPasses = blurPasses;
    }

    public Color4f getShadowColor() {
        return null;
    }

    public float getSpread() {
        return 0.0f;
    }

    @Override
    public LinearConvolveRenderState getRenderState(BaseTransform filtertx) {
        return new BoxRenderState(hsize, vsize, blurPasses, getSpread(),
                                  isShadow(), getShadowColor(), filtertx);
    }

    @Override
    public boolean isNop() {
        return (blurPasses == 0 || (hsize <= 1 && vsize <= 1));
    }

    @Override
    public int getKernelSize(int pass) {
        int ksize = pass == 0 ? hsize : vsize;
        if (ksize < 1) ksize = 1;
        ksize = (ksize-1) * blurPasses + 1;
        ksize |= 1;
        return ksize;
    }
}
