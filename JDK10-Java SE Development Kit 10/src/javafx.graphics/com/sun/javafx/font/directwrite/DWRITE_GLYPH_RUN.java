/*
 * Copyright (c) 2013, Oracle and/or its affiliates. All rights reserved.
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

package com.sun.javafx.font.directwrite;

class DWRITE_GLYPH_RUN {
    long fontFace;
    float fontEmSize;
    short glyphIndices;
    float glyphAdvances;
    float advanceOffset;
    float ascenderOffset;
    boolean isSideways;
    int bidiLevel;
}
