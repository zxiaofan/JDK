/*
 * Copyright (c) 2009, 2013, Oracle and/or its affiliates. All rights reserved.
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

package com.sun.prism.paint;

public class Stop {

    private final Color color;
    private final float offset;

    public Stop(Color color, float offset) {
        this.color = color;
        this.offset = offset;
    }

    public Color getColor() {
        return color;
    }

    public float getOffset() {
        return offset;
    }
}
