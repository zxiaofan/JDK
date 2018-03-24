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

package com.sun.javafx.sg.prism;

import javafx.scene.shape.ArcType;
import com.sun.javafx.geom.Arc2D;
import com.sun.javafx.geom.Shape;
import com.sun.prism.Graphics;
import com.sun.prism.shape.ShapeRep;

/**
 *
 */
public class NGArc extends NGShape {
    private Arc2D arc = new Arc2D();

    public void updateArc(float cx, float cy, float rx, float ry,
                                    float start, float extent, ArcType type) {
        arc.x = cx - rx;
        arc.width = rx * 2f;
        arc.y = cy - ry;
        arc.height = ry * 2f;
        arc.start = start;
        arc.extent = extent;

        if (type == ArcType.CHORD) {
            arc.setArcType(Arc2D.CHORD);
        } else if (type == ArcType.OPEN) {
            arc.setArcType(Arc2D.OPEN);
        } else if (type == ArcType.ROUND) {
            arc.setArcType(Arc2D.PIE);
        } else {
            throw new AssertionError("Unknown arc type specified");
        }
        geometryChanged();
    }

    @Override public Shape getShape() { return arc; }
    @Override protected ShapeRep createShapeRep(Graphics g) {
        return g.getResourceFactory().createArcRep();
    }
}
