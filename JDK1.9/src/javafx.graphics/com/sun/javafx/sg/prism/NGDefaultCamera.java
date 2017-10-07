/*
 * Copyright (c) 2013, Oracle and/or its affiliates. All rights reserved.
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

package com.sun.javafx.sg.prism;

/**
 */
public class NGDefaultCamera extends NGParallelCamera {
    public void validate(final int w, final int h) {
        if ((w != viewWidth) || (h != viewHeight)) {
            setViewWidth(w);
            setViewHeight(h);

            final double halfDepth = (w > h) ? w / 2.0 : h / 2.0;
            projViewTx.ortho(0.0, w, h, 0.0, -halfDepth, halfDepth);
        }
    }
}
