/*
 * Copyright (c) 1997, 2013, Oracle and/or its affiliates. All rights reserved.
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

package com.sun.javafx.geom;

/**
 * The <code>Dimension2D</code> class is to encapsulate a width
 * and a height dimension.
 * <p>
 */
public class Dimension2D {
    public float width;
    public float height;

    public Dimension2D() { }

    public Dimension2D(float w, float h) {
        width = w;
        height = h;
    }
}
