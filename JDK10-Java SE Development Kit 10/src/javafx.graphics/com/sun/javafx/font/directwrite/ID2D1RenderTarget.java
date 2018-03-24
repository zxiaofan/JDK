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

class ID2D1RenderTarget extends IUnknown {
    ID2D1RenderTarget(long ptr) {
        super(ptr);
    }

    void BeginDraw() {
        OS.BeginDraw(ptr);
    }

    int EndDraw() {
        return OS.EndDraw(ptr);
    }

    void Clear(D2D1_COLOR_F clearColor) {
        OS.Clear(ptr, clearColor);
    }

    void SetTransform(D2D1_MATRIX_3X2_F transform) {
        OS.SetTransform(ptr, transform);
    }

    void SetTextAntialiasMode(int textAntialiasMode) {
        OS.SetTextAntialiasMode(ptr, textAntialiasMode);
    }

    void DrawGlyphRun(D2D1_POINT_2F baselineOrigin, DWRITE_GLYPH_RUN glyphRun, ID2D1Brush foregroundBrush, int measuringMode) {
        OS.DrawGlyphRun(ptr, baselineOrigin, glyphRun, foregroundBrush.ptr, measuringMode);
    }

    ID2D1Brush CreateSolidColorBrush(D2D1_COLOR_F color) {
        long result = OS.CreateSolidColorBrush(ptr, color);
        return result != 0 ? new ID2D1Brush(result) : null;
    }
}
