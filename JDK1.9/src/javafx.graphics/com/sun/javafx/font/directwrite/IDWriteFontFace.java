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

import com.sun.javafx.geom.Path2D;

class IDWriteFontFace extends IUnknown {
    IDWriteFontFace(long ptr) {
        super(ptr);
    }

    /* Based on GetDesignGlyphMetrics but only handles a single codePoint,
     * as opposite of taking in an array and returing an array.
     * - performance and simplicity based on JavaFX needs */
    DWRITE_GLYPH_METRICS GetDesignGlyphMetrics(short glyphIndex, boolean isSideways) {
        return OS.GetDesignGlyphMetrics(ptr, glyphIndex, isSideways);
    }

    Path2D GetGlyphRunOutline(float emSize, short glyphIndex, boolean isSideways) {
        return OS.GetGlyphRunOutline(ptr, emSize, glyphIndex, isSideways);
    }
}
