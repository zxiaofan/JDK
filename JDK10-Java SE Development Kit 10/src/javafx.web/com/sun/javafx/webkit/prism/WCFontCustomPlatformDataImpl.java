/*
 * Copyright (c) 2011, 2016, Oracle and/or its affiliates. All rights reserved.
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

package com.sun.javafx.webkit.prism;

import com.sun.javafx.font.FontFactory;
import com.sun.javafx.font.PGFont;
import com.sun.prism.GraphicsPipeline;
import com.sun.webkit.graphics.WCFont;
import com.sun.webkit.graphics.WCFontCustomPlatformData;
import java.io.IOException;
import java.io.InputStream;

final class WCFontCustomPlatformDataImpl extends WCFontCustomPlatformData {

    private final PGFont font;


    WCFontCustomPlatformDataImpl(InputStream inputStream) throws IOException {
        FontFactory factory = GraphicsPipeline.getPipeline().getFontFactory();
        PGFont[] fa = factory.loadEmbeddedFont(null, inputStream,
                                               10, false, false);
        if (fa == null) {
            throw new IOException("Error loading font");
        }
        font = fa[0];
    }


    @Override
    protected WCFont createFont(int size, boolean bold, boolean italic) {
        FontFactory factory = GraphicsPipeline.getPipeline().getFontFactory();
        return new WCFontImpl(factory.deriveFont(font, bold, italic, size));
    }
}
