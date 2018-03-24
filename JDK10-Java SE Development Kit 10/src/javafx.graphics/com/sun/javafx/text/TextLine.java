/*
 * Copyright (c) 2012, 2013, Oracle and/or its affiliates. All rights reserved.
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

package com.sun.javafx.text;

import com.sun.javafx.geom.RectBounds;

public class TextLine implements com.sun.javafx.scene.text.TextLine {
    TextRun[] runs;
    RectBounds bounds;
    float lsb, rsb, leading;
    int start;
    int length;

    public TextLine(int start, int length, TextRun[] runs,
                    float width, float ascent, float descent, float leading) {
        this.start = start;
        this.length = length;
        this.bounds = new RectBounds(0, ascent, width, descent + leading);
        this.leading = leading;
        this.runs = runs;
    }

    public RectBounds getBounds() {
        return bounds;
    }

    public float getLeading() {
        return leading;
    }

    public TextRun[] getRuns() {
        return runs;
    }

    public int getStart() {
        return start;
    }

    public int getLength() {
        return length;
    }

    public void setSideBearings(float lsb, float rsb) {
        this.lsb = lsb;
        this.rsb = rsb;
    }

    public float getLeftSideBearing() {
        return lsb;
    }

    public float getRightSideBearing() {
        return rsb;
    }

    public void setAlignment(float x) {
        bounds.setMinX(x);
        bounds.setMaxX(x + bounds.getMaxX());
    }

    public void setWidth(float width) {
        bounds.setMaxX(bounds.getMinX() + width);
    }
}
