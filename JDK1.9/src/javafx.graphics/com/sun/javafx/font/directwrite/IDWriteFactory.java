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

class IDWriteFactory extends IUnknown {
    IDWriteFactory(long ptr) {
        super(ptr);
    }

    IDWriteFontCollection GetSystemFontCollection(boolean checkForUpdates) {
        long result = OS.GetSystemFontCollection(ptr, checkForUpdates);
        return result != 0 ? new IDWriteFontCollection(result) : null;
    }

    IDWriteTextAnalyzer CreateTextAnalyzer() {
        long result = OS.CreateTextAnalyzer(ptr);
        return result != 0 ? new IDWriteTextAnalyzer(result) : null;
    }

    IDWriteTextFormat CreateTextFormat(String fontFamily,
                                       IDWriteFontCollection fontCollection,
                                       int fontWeight,
                                       int fontStyle,
                                       int fontStretch,
                                       float fontSize,
                                       String localeName) {
        long result = OS.CreateTextFormat(ptr,
                                          (fontFamily+'\0').toCharArray(),
                                          fontCollection.ptr,
                                          fontWeight,
                                          fontStyle,
                                          fontStretch,
                                          fontSize,
                                          (localeName+'\0').toCharArray());
        return result != 0 ? new IDWriteTextFormat(result) : null;
    }

    IDWriteTextLayout CreateTextLayout(char[] text,
                                       int stringStart,
                                       int stringLength,
                                       IDWriteTextFormat textFormat,
                                       float maxWidth,
                                       float maxHeight) {
        long result = OS.CreateTextLayout(ptr,
                                          text,
                                          stringStart,
                                          stringLength,
                                          textFormat.ptr,
                                          maxWidth,
                                          maxHeight);
        return result != 0 ? new IDWriteTextLayout(result) : null;
    }

    IDWriteGlyphRunAnalysis CreateGlyphRunAnalysis(DWRITE_GLYPH_RUN glyphRun,
                                                   float pixelsPerDip,
                                                   DWRITE_MATRIX transform,
                                                   int renderingMode,
                                                   int measuringMode,
                                                   float baselineOriginX,
                                                   float baselineOriginY) {
        long result = OS.CreateGlyphRunAnalysis(ptr,
                                                glyphRun,
                                                pixelsPerDip,
                                                transform,
                                                renderingMode,
                                                measuringMode,
                                                baselineOriginX,
                                                baselineOriginY);
        return result != 0 ? new IDWriteGlyphRunAnalysis(result) : null;
    }

    IDWriteFontFile CreateFontFileReference(String filePath) {
        long result = OS.CreateFontFileReference(ptr, (filePath+'\0').toCharArray());
        return result != 0 ? new IDWriteFontFile(result) : null;
    }

    IDWriteFontFace CreateFontFace(int fontFaceType,
                                   IDWriteFontFile fontFiles,
                                   int faceIndex,
                                   int fontFaceSimulationFlags) {

        long result = OS.CreateFontFace(ptr, fontFaceType, fontFiles.ptr, faceIndex, fontFaceSimulationFlags);
        return result != 0 ? new IDWriteFontFace(result) : null;
    }
}
