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

package com.sun.javafx.font.freetype;

import com.sun.javafx.font.DisposerRecord;
import com.sun.javafx.font.PrismFontFactory;

class FTDisposer implements DisposerRecord  {
    long library;
    long face;

    FTDisposer(long library, long face) {
        this.library = library;
        this.face = face;
    }

    public synchronized void dispose() {
        if (face != 0) {
            OSFreetype.FT_Done_Face(face);
            if (PrismFontFactory.debugFonts) {
                System.err.println("Done Face=" + face);
            }
            face = 0;
        }
        if (library != 0) {
            OSFreetype.FT_Done_FreeType(library);
            if (PrismFontFactory.debugFonts) {
                System.err.println("Done Library=" + library);
            }
            library = 0;
        }
    }
}
