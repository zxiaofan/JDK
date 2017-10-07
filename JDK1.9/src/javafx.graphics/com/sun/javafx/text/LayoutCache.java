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

import com.sun.javafx.font.PGFont;

class LayoutCache {
    int[] glyphs;
    float[] advances;
    boolean valid;
    int analysis;
    char[] text;
    PGFont font;
    TextRun[] runs;
    int runCount;
    TextLine[] lines;
    float layoutWidth, layoutHeight;
}
