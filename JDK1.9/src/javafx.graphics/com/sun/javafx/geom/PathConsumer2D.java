/*
 * Copyright (c) 2011, 2013, Oracle and/or its affiliates. All rights reserved.
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
 */
public interface PathConsumer2D {
    public void moveTo(float x0, float y0);
    public void lineTo(float x1, float y1);
    public void quadTo(float xc, float yc,
                       float x1, float y1);
    public void curveTo(float xc0, float yc0,
                        float xc1, float yc1,
                        float x1, float y1);
    public void closePath();
    public void pathDone();
}
