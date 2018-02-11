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
import com.sun.javafx.geom.Ellipse2D;
import com.sun.javafx.geom.Shape;
import com.sun.prism.Graphics;

public class BasicEllipseRep extends BasicShapeRep {

    public BasicEllipseRep() {
    }

    @Override
    public void fill(Graphics g, Shape shape, BaseBounds bounds) {
        Ellipse2D e = (Ellipse2D)shape;
        g.fillEllipse(e.x, e.y, e.width, e.height);
    }

    @Override
    public void draw(Graphics g, Shape shape, BaseBounds bounds) {
        Ellipse2D e = (Ellipse2D)shape;
        g.drawEllipse(e.x, e.y, e.width, e.height);
    }
}
