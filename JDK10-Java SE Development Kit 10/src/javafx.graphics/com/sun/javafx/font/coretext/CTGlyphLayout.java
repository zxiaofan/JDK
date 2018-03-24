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

package com.sun.javafx.font.coretext;

import com.sun.javafx.font.CompositeFontResource;
import com.sun.javafx.font.CompositeStrike;
import com.sun.javafx.font.FontStrike;
import com.sun.javafx.font.PGFont;
import com.sun.javafx.font.PrismFontFactory;
import com.sun.javafx.text.GlyphLayout;
import com.sun.javafx.text.TextRun;

class CTGlyphLayout extends GlyphLayout {

    private long createCTLine(long fontRef, char[] chars, boolean rtl,
                              int start, int length) {
        /* Use CoreText to analize the run */
        long alloc = OS.kCFAllocatorDefault();
        long textRef = OS.CFStringCreateWithCharacters(alloc, chars, start, length);
        long lineRef = 0;
        if (textRef != 0) {
            long attributes = OS.CFDictionaryCreateMutable(alloc, 4,
                                  OS.kCFTypeDictionaryKeyCallBacks(),
                                  OS.kCFTypeDictionaryValueCallBacks());
            if (attributes != 0) {
                OS.CFDictionaryAddValue(attributes, OS.kCTFontAttributeName(), fontRef);
                if (rtl) {
                    long paragraphStyleRef = OS.CTParagraphStyleCreate(OS.kCTWritingDirectionRightToLeft);
                    if (paragraphStyleRef != 0) {
                        OS.CFDictionaryAddValue(attributes, OS.kCTParagraphStyleAttributeName(), paragraphStyleRef);
                        OS.CFRelease(paragraphStyleRef);
                    }
                }
                /* Note that by default CoreText will apply kerning depending on the font*/
                long attString = OS.CFAttributedStringCreate(alloc, textRef, attributes);
                if (attString != 0) {
                    lineRef = OS.CTLineCreateWithAttributedString(attString);
                    OS.CFRelease(attString);
                }
                OS.CFRelease(attributes);
            }
            OS.CFRelease(textRef);
        }
        return lineRef;
    }

    private int getFontSlot(long runRef, CompositeFontResource fr, String name, int slot) {
        long runAttrs = OS.CTRunGetAttributes(runRef);
        if (runAttrs == 0) return -1;
        long actualFont = OS.CFDictionaryGetValue(runAttrs, OS.kCTFontAttributeName());
        if (actualFont == 0) return -1;

        /* Use the display name from the kCTFontDisplayNameAttribute attribute
         * instead of CTFontCopyDisplayName() to avoid localized names*/
        String fontName = OS.CTFontCopyAttributeDisplayName(actualFont);
        if (fontName == null) return -1;
        if (!fontName.equalsIgnoreCase(name)) {
            if (fr == null) return -1;
            slot = fr.getSlotForFont(fontName);
            if (PrismFontFactory.debugFonts) {
                System.err.println("\tFallback font= "+ fontName + " slot=" + slot);
            }
        }
        return slot;
    }

    public void layout(TextRun run, PGFont font, FontStrike strike, char[] text) {

        int baseSlot = 0;
        CompositeFontResource composite = null;
        if (strike instanceof CompositeStrike) {
            composite = (CompositeFontResource)strike.getFontResource();
            baseSlot = getInitialSlot(composite);
            strike = ((CompositeStrike)strike).getStrikeSlot(baseSlot);
        }
        float size = strike.getSize();
        String fontName = strike.getFontResource().getFullName();
        long fontRef = ((CTFontStrike)strike).getFontRef();
        if (fontRef == 0) return;
        boolean rtl = (run.getLevel() & 1) != 0;
        long lineRef = createCTLine(fontRef, text, rtl, run.getStart(), run.getLength());
        if (lineRef == 0) return;
        long runs = OS.CTLineGetGlyphRuns(lineRef);
        if (runs != 0) {
            int glyphCount = (int)OS.CTLineGetGlyphCount(lineRef);
            int[] glyphs = new int[glyphCount];
            float[] positions = new float[glyphCount * 2 + 2];
            int[] indices = new int[glyphCount];
            long runCount = OS.CFArrayGetCount(runs);
            int glyphStart = 0, posStart = 0, indicesStart = 0;
            for (int i = 0; i < runCount; i++) {
                long runRef = OS.CFArrayGetValueAtIndex(runs, i);
                if (runRef == 0) continue;
                int slot = getFontSlot(runRef, composite, fontName, baseSlot);
                if (slot != -1) {
                    glyphStart += OS.CTRunGetGlyphs(runRef, slot << 24, glyphStart, glyphs);
                } else {
                    glyphStart += OS.CTRunGetGlyphCount(runRef);
                }
                if (size > 0) {
                    posStart += OS.CTRunGetPositions(runRef, posStart, positions);
                }
                indicesStart += OS.CTRunGetStringIndices(runRef, indicesStart, indices);

            }
            if (size > 0) {
                positions[posStart] = (float)OS.CTLineGetTypographicBounds(lineRef);
            }
            run.shape(glyphCount, glyphs, positions, indices);
        }
        OS.CFRelease(lineRef);
    }
}
