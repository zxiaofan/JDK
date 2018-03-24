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

import com.sun.javafx.geom.PickRay;

/**
 * TODO: 3D - Need documentation
 */
public class NGParallelCamera extends NGCamera {

    public NGParallelCamera() { }

    @Override
    public PickRay computePickRay(float x, float y, PickRay pickRay) {
        return PickRay.computeParallelPickRay(x, y, viewHeight, worldTransform,
                zNear, zFar, pickRay);
    }
}
