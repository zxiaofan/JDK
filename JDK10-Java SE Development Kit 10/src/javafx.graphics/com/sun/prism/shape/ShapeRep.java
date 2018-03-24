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

package com.sun.prism.shape;

import com.sun.javafx.geom.BaseBounds;
import com.sun.javafx.geom.Shape;
import com.sun.prism.Graphics;

public interface ShapeRep {
    public enum InvalidationType {
        /**
         * location only changed
         */
        LOCATION,
        /**
         * both location and geometry changed
         */
        LOCATION_AND_GEOMETRY
        // NOTE: potentially have more specific (stroke/shape changed), at which
        // point we might as well use bits
    }

    public boolean is3DCapable();
    public void invalidate(InvalidationType type);
    public void fill(Graphics g, Shape shape, BaseBounds bounds);
    public void draw(Graphics g, Shape shape, BaseBounds bounds);
    public void dispose();
}
