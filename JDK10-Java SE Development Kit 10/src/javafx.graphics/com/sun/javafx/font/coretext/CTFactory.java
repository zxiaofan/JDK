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

package com.sun.javafx.font.coretext;

import com.sun.javafx.font.PrismFontFactory;
import com.sun.javafx.font.PrismFontFile;
import com.sun.javafx.text.GlyphLayout;

public class CTFactory extends PrismFontFactory {

    public static PrismFontFactory getFactory() {
        return new CTFactory();
    }

    private CTFactory() {
    }

    @Override
    protected PrismFontFile createFontFile(String name, String filename,
            int fIndex, boolean register, boolean embedded, boolean copy,
            boolean tracked) throws Exception {
        return new CTFontFile(name, filename, fIndex, register,
                              embedded, copy, tracked);
    }

    @Override
    public GlyphLayout createGlyphLayout() {
        return new CTGlyphLayout();
    }

    @Override
    protected boolean registerEmbeddedFont(String path) {
        boolean result = CTFontFile.registerFont(path);
        if (debugFonts) {
            if (result) {
                System.err.println("[CoreText] Font registration succeeded:" + path);
            } else {
                System.err.println("[CoreText] Font registration failed:" + path);
            }
        }
        return result;
    }
}
