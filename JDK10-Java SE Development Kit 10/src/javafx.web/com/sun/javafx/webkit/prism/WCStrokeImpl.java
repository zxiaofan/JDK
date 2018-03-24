/*
 * Copyright (c) 2011, 2015, Oracle and/or its affiliates. All rights reserved.
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

package com.sun.javafx.webkit.prism;

import com.sun.prism.BasicStroke;
import com.sun.prism.Graphics;
import com.sun.prism.paint.Paint;
import com.sun.webkit.graphics.WCStroke;

final class WCStrokeImpl extends WCStroke<Paint, BasicStroke> {

    private BasicStroke stroke;

    public WCStrokeImpl() {
    }

    public WCStrokeImpl(float width, int cap, int join, float miterLimit,
                        float[] dash, float dashOffset)
    {
        setThickness(width);
        setLineCap(cap);
        setLineJoin(join);
        setMiterLimit(miterLimit);
        setDashSizes(dash);
        setDashOffset(dashOffset);
    }

    protected void invalidate() {
        this.stroke = null;
    }

    public BasicStroke getPlatformStroke() {
        if (this.stroke == null) {
            int style = getStyle();
            if (style != NO_STROKE) {
                float width = getThickness();
                float[] dash = getDashSizes();
                if (dash == null) {
                    switch (style) {
                        case DOTTED_STROKE:
                            dash = new float[] { width, width };
                            break;
                        case DASHED_STROKE:
                            dash = new float[] { 3 * width, 3 * width };
                            break;
                    }
                }
                this.stroke = new BasicStroke(width, getLineCap(), getLineJoin(), getMiterLimit(),
                                              dash, getDashOffset());
            }
        }
        return this.stroke;
    }

    boolean isApplicable() {
        return getPaint() != null && getPlatformStroke() != null;
    }

    boolean apply(Graphics graphics) {
        if (isApplicable()) {
            Paint _paint = getPaint();
            BasicStroke _stroke = getPlatformStroke();
            graphics.setPaint(_paint);
            graphics.setStroke(_stroke);
            return true;
        }
        return false;
    }
}
