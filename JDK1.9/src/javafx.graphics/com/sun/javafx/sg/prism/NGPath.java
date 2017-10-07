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

import javafx.scene.shape.FillRule;
import com.sun.javafx.geom.Arc2D;
import com.sun.javafx.geom.Path2D;
import com.sun.javafx.geom.PathIterator;
import com.sun.javafx.geom.Shape;
import com.sun.javafx.geom.transform.BaseTransform;

/**
 */
public class NGPath extends NGShape {

    private Path2D p = new Path2D();

    public void reset() {
        p.reset();
    }

    public void update() {
        geometryChanged();
    }

    private int toWindingRule(FillRule rule) {
        if (rule == FillRule.NON_ZERO) {
            return Path2D.WIND_NON_ZERO;
        } else {
            return Path2D.WIND_EVEN_ODD;
        }
    }

    public void setFillRule(FillRule fillRule) {
        p.setWindingRule(toWindingRule(fillRule));
    }

    public float getCurrentX() {
        return p.getCurrentPoint().x;
    }

    public float getCurrentY() {
        return p.getCurrentPoint().y;
    }

    public void addClosePath() {
        p.closePath();
    }

    public void addMoveTo(float x, float y) {
        p.moveTo(x, y);
    }

    public void addLineTo(float x, float y) {
        p.lineTo(x, y);
    }

    public void addQuadTo(float ctrlx, float ctrly, float x, float y) {
        p.quadTo(ctrlx, ctrly, x, y);
    }

    public void addCubicTo(float ctrlx1, float ctrly1,
                           float ctrlx2, float ctrly2,
                           float x, float y)
    {
        p.curveTo(ctrlx1, ctrly1, ctrlx2, ctrly2, x, y);
    }

    public void addArcTo(float arcX, float arcY, float arcW, float arcH,
                         float arcStart, float arcExtent, float xAxisRotation)
    {
        Arc2D arc = new Arc2D(arcX, arcY, arcW, arcH, arcStart, arcExtent, Arc2D.OPEN);
        BaseTransform xform = xAxisRotation == 0.0 ? null :
                BaseTransform.getRotateInstance(xAxisRotation,
                                                arc.getCenterX(), arc.getCenterY());
        PathIterator pi = arc.getPathIterator(xform);
        // RT-8926, append(true) converts the initial moveTo into a
        // lineTo which can generate huge miter joins if the segment
        // is small enough.  So, we manually skip it here instead.
        pi.next();
        p.append(pi, true);
    }

    public Path2D getGeometry() {
        return p;
    }

    @Override
    public Shape getShape() {
        return p;
    }

    public boolean acceptsPath2dOnUpdate() {
        return true;
    }

    public void updateWithPath2d(Path2D path) {
        p.setTo(path);
        geometryChanged();
    }


}
