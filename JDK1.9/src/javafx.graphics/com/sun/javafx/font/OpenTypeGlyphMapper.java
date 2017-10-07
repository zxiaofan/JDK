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

public class OpenTypeGlyphMapper extends CharToGlyphMapper {

    PrismFontFile font;
    CMap cmap;

    public OpenTypeGlyphMapper(PrismFontFile font) {
        this.font = font;
        try {
            cmap = CMap.initialize(font);
        } catch (Exception e) {
            cmap = null;
        }
        if (cmap == null) {
            handleBadCMAP();
        }
        missingGlyph = 0; /* standard for TrueType fonts */
    }

    public int getGlyphCode(int charCode) {
        try {
            return cmap.getGlyph(charCode);
        } catch(Exception e) {
            handleBadCMAP();
            return missingGlyph;
        }
    }

    private void handleBadCMAP() {
        // REMIND: Need to deregister ?
        cmap = CMap.theNullCmap;
    }

    /* A pretty good heuristic is that the cmap we are using
     * supports 32 bit character codes.
     */
    boolean hasSupplementaryChars() {
        return
            cmap instanceof CMap.CMapFormat8 ||
            cmap instanceof CMap.CMapFormat10 ||
            cmap instanceof CMap.CMapFormat12;
    }
}
