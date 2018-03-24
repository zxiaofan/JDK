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

package com.sun.prism.impl.shape;

import com.sun.javafx.geom.BaseBounds;
import com.sun.javafx.geom.Shape;
import com.sun.prism.Graphics;
import com.sun.prism.shape.ShapeRep;

public class BasicShapeRep implements ShapeRep {

    public BasicShapeRep() {
    }

    public boolean is3DCapable() {
        return false;
    }

    public void invalidate(InvalidationType type) {
    }

    public void fill(Graphics g, Shape shape, BaseBounds bounds) {
        g.fill(shape);
    }

    public void draw(Graphics g, Shape shape, BaseBounds bounds) {
        g.draw(shape);
    }

    public void dispose() {
    }
}
