/*
 * Copyright (c) 2011, 2016, Oracle and/or its affiliates. All rights reserved.
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

package com.sun.marlin;

public interface DPathConsumer2D {
    public void moveTo(double x0, double y0);
    public void lineTo(double x1, double y1);
    public void quadTo(double xc, double yc,
                       double x1, double y1);
    public void curveTo(double xc0, double yc0,
                        double xc1, double yc1,
                        double x1, double y1);
    public void closePath();
    public void pathDone();
}
