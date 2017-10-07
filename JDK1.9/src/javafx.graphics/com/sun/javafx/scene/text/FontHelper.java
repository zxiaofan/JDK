/*
 * Copyright (c) 2016, Oracle and/or its affiliates. All rights reserved.
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

package com.sun.javafx.scene.text;

import com.sun.javafx.util.Utils;
import javafx.scene.text.Font;

/**
 * Used to access internal methods of Font.
 */
public class FontHelper {

    private static FontAccessor fontAccessor;

    static {
        Utils.forceInit(Font.class);
    }

    private FontHelper() {
    }

    public static Object getNativeFont(Font font) {
        return fontAccessor.getNativeFont(font);
    }

    public static void setNativeFont(Font font, Object f, String nam,
            String fam, String styl) {
        fontAccessor.setNativeFont(font, f, nam, fam, styl);
    }

    public static Font nativeFont(Object f, String name, String family,
                                       String style, double size) {
        return fontAccessor.nativeFont(f, name, family, style, size);
    }

    public static void setFontAccessor(final FontAccessor newAccessor) {
        if (fontAccessor != null) {
            throw new IllegalStateException();
        }

        fontAccessor = newAccessor;
    }

    public interface FontAccessor {
        Object getNativeFont(Font font);
        void setNativeFont(Font font, Object f, String nam, String fam, String styl);
        Font nativeFont(Object f, String name, String family, String style, double size);
    }

}
