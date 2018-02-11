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

class IDWriteTextAnalyzer extends IUnknown {
    IDWriteTextAnalyzer(long ptr) {
        super(ptr);
    }

    int AnalyzeScript(JFXTextAnalysisSink source, int start, int length, JFXTextAnalysisSink sink) {
        return OS.AnalyzeScript(ptr, source.ptr, start, length, sink.ptr);
    }

    int GetGlyphs(char[] textString,
                  int textStart,
                  int textLength,
                  IDWriteFontFace fontFace,
                  boolean isSideways,
                  boolean isRightToLeft,
                  DWRITE_SCRIPT_ANALYSIS scriptAnalysis,
                  String localeName,
                  long numberSubstitution,
                  /*DWRITE_TYPOGRAPHIC_FEATURES*/ long[] features,
                  int[] featureRangeLengths,
                  int featureRanges,
                  int maxGlyphCount,
                  short[] clusterMap,
                  /*DWRITE_SHAPING_TEXT_PROPERTIES*/ short[] textProps,
                  short[] glyphIndices,
                  /*DWRITE_SHAPING_GLYPH_PROPERTIES*/ short[] glyphProps,
                  int[] actualGlyphCount) {
        return OS.GetGlyphs(ptr, textString, textStart, textLength, fontFace.ptr,
                            isSideways, isRightToLeft,
                            scriptAnalysis,
                            (localeName != null ? (localeName+'\0').toCharArray() : (char[])null),
                            numberSubstitution,
                            features, featureRangeLengths, featureRanges,
                            maxGlyphCount, clusterMap, textProps,
                            glyphIndices, glyphProps, actualGlyphCount);
    }

    int GetGlyphPlacements(char[] textString,
                           short[] clusterMap,
                           /*DWRITE_SHAPING_TEXT_PROPERTIES*/ short[] textProps,
                           int textStart,
                           int textLength,
                           short[] glyphIndices,
                           /*DWRITE_SHAPING_GLYPH_PROPERTIES*/ short[] glyphProps,
                           int glyphCount,
                           IDWriteFontFace fontFace,
                           float fontEmSize,
                           boolean isSideways,
                           boolean isRightToLeft,
                           DWRITE_SCRIPT_ANALYSIS scriptAnalysis,
                           String localeName,
                           /*DWRITE_TYPOGRAPHIC_FEATURES*/ long[] features,
                           int[] featureRangeLengths,
                           int featureRanges,
                           float[] glyphAdvances,
                           /*DWRITE_GLYPH_OFFSET 2X */ float[] glyphOffsets) {
        return OS.GetGlyphPlacements(ptr, textString, clusterMap, textProps,
                                     textStart, textLength,
                                     glyphIndices, glyphProps, glyphCount,
                                     fontFace.ptr, fontEmSize, isSideways, isRightToLeft,
                                     scriptAnalysis,
                                     (localeName != null ? (localeName+'\0').toCharArray() : (char[])null),
                                     features, featureRangeLengths, featureRanges,
                                     glyphAdvances, glyphOffsets);
    }
}
