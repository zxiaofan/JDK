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

/* JFX implementation for IDWriteTextRenderer */
class JFXTextRenderer extends IUnknown {
    JFXTextRenderer(long ptr) {
        super(ptr);
    }

    boolean Next() {
        return OS.JFXTextRendererNext(ptr);
    }

    int GetStart() {
        return OS.JFXTextRendererGetStart(ptr);
    }

    int GetLength() {
        return OS.JFXTextRendererGetLength(ptr);
    }

    int GetGlyphCount() {
        return OS.JFXTextRendererGetGlyphCount(ptr);
    }

    int GetTotalGlyphCount() {
        return OS.JFXTextRendererGetTotalGlyphCount(ptr);
    }

    IDWriteFontFace GetFontFace() {
        long result = OS.JFXTextRendererGetFontFace(ptr);
        return result != 0 ? new IDWriteFontFace(result) : null;
    }

    int GetGlyphIndices(int[] glyphs, int start, int slot) {
        return OS.JFXTextRendererGetGlyphIndices(ptr, glyphs, start, slot);
    }

    int GetGlyphAdvances(float[] advances, int start) {
        return OS.JFXTextRendererGetGlyphAdvances(ptr, advances, start);
    }

    int GetGlyphOffsets(float[] offsets, int start) {
        return OS.JFXTextRendererGetGlyphOffsets(ptr, offsets, start);
    }

    int GetClusterMap(short[] clusterMap, int textStart, int glyphStart) {
        return OS.JFXTextRendererGetClusterMap(ptr, clusterMap, textStart, glyphStart);
    }
}
