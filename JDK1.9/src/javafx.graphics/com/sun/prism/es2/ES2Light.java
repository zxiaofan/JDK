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

package com.sun.prism.es2;

/**
 * TODO: 3D - Need documentation
 */
class ES2Light {

    float x, y, z = 0;
    float r, g, b, w = 1;

    ES2Light(float ix, float iy, float iz, float ir, float ig, float ib, float iw) {
        x = ix;
        y = iy;
        z = iz;
        r = ir;
        g = ig;
        b = ib;
        w = iw;
    }
}
