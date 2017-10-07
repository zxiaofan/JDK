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

/**
 * An abstract helper intermediate implementation class for
 * {@code LinearConvolve} effects that break down into a horizontal and
 * a vertical pass.
 */
public abstract class HVSeparableKernel extends LinearConvolveKernel {
    @Override
    public final Rectangle getResultBounds(Rectangle srcdimension, int pass) {
        int ksize = getKernelSize(pass);
        Rectangle ret = new Rectangle(srcdimension);
        if (pass == 0) {
            ret.grow(ksize/2, 0);
        } else {
            ret.grow(0, ksize/2);
        }
        return ret;
    }
}
