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

import com.sun.javafx.geom.Line2D;
import com.sun.javafx.geom.Shape;
import com.sun.prism.BasicStroke;
import com.sun.prism.Graphics;

/**
 *
 */
public class NGLine extends NGShape {

    private Line2D line = new Line2D();

    public void updateLine(float x1, float y1, float x2, float y2) {
        line.x1 = x1;
        line.y1 = y1;
        line.x2 = x2;
        line.y2 = y2;
        geometryChanged();
    }

    @Override protected void renderContent2D(Graphics g, boolean printing) {
        if ((mode == Mode.STROKE || mode == Mode.STROKE_FILL) &&
            drawStroke.getLineWidth() > 0 &&
            drawStroke.getType() != BasicStroke.TYPE_INNER)
        {
            g.setPaint(drawPaint);
            g.setStroke(drawStroke);
            g.drawLine(line.x1, line.y1, line.x2, line.y2);
        }
    }

    @Override
    public final Shape getShape() {
        return line;
    }
}
