/*
 * Copyright (c) 2013, 2014, Oracle and/or its affiliates. All rights reserved.
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

package com.sun.javafx.font.freetype;

class PangoGlyphString {
    /* Fields from PangoItem */
    int offset;
    int length;
    int num_chars;
    /* pangoItem->analysis->font*/
    long font;
    int num_glyphs;
    /* PangoGlyphInfo->glyph */
    int[] glyphs;
    /* PangoGlyphInfo->PangoGlyphGeometry->width */
    int[] widths;
    int[] log_clusters;
}
