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

package com.sun.javafx.font;


public class PrismMetrics implements Metrics {

    PrismFontFile fontResource;
    float ascent, descent, linegap;
    private float[] styleMetrics;
    float size;

    static final int XHEIGHT = 0;
    static final int CAPHEIGHT = 1;
    static final int TYPO_ASCENT = 2;
    static final int TYPO_DESCENT = 3;
    static final int TYPO_LINEGAP = 4;
    static final int STRIKETHROUGH_THICKNESS = 5;
    static final int STRIKETHROUGH_OFFSET = 6;
    static final int UNDERLINE_THICKESS = 7;
    static final int UNDERLINE_OFFSET = 8;
    static final int METRICS_TOTAL = 9;

    PrismMetrics(float ascent, float descent, float linegap,
               PrismFontFile fontResource, float size) {
        this.ascent = ascent;
        this.descent = descent;
        this.linegap = linegap;
        this.fontResource = fontResource;
        this.size = size;
    }

    public float getAscent() {
        return ascent;
    }

    public float getDescent() {
        return descent;
    }

    public float getLineGap() {
        return linegap;
    }

    public float getLineHeight() {
        return -ascent + descent + linegap;
    }

    private void checkStyleMetrics() {
        if (styleMetrics == null) {
            styleMetrics = fontResource.getStyleMetrics(size);
        }
    }

    public float getTypoAscent() {
        checkStyleMetrics();
        return styleMetrics[TYPO_ASCENT];
    }

    public float getTypoDescent() {
        checkStyleMetrics();
        return styleMetrics[TYPO_DESCENT];
    }

    public float getTypoLineGap() {
        checkStyleMetrics();
        return styleMetrics[TYPO_LINEGAP];
    }

    public float getCapHeight() {
        checkStyleMetrics();
        return styleMetrics[CAPHEIGHT];
    }

    public float getXHeight() {
        checkStyleMetrics();
        return styleMetrics[XHEIGHT];
    }

    public float getStrikethroughOffset() {
        checkStyleMetrics();
        return styleMetrics[STRIKETHROUGH_OFFSET];
    }

    public float getStrikethroughThickness() {
        checkStyleMetrics();
        return styleMetrics[STRIKETHROUGH_THICKNESS];
    }

    public float getUnderLineOffset() {
        checkStyleMetrics();
        return styleMetrics[UNDERLINE_OFFSET];
    }

    public float getUnderLineThickness() {
        checkStyleMetrics();
        return styleMetrics[UNDERLINE_THICKESS];
    }

    public String toString() {
        return
            "ascent = " + getAscent() +
            " descent = " + getDescent() +
            " linegap = " + getLineGap() +
            " lineheight = " +getLineHeight();
    }
}
