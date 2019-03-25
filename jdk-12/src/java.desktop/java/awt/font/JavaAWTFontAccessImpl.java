/*
 * Copyright (c) 2014, 2018, Oracle and/or its affiliates. All rights reserved.
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

package java.awt.font;

import jdk.internal.access.JavaAWTFontAccess;

class JavaAWTFontAccessImpl implements JavaAWTFontAccess {

    // java.awt.font.TextAttribute constants
    public Object getTextAttributeConstant(String name) {
        switch (name) {
            case "RUN_DIRECTION":
                return TextAttribute.RUN_DIRECTION;
            case "NUMERIC_SHAPING":
                return TextAttribute.NUMERIC_SHAPING;
            case "BIDI_EMBEDDING":
                return TextAttribute.BIDI_EMBEDDING;
            case "RUN_DIRECTION_LTR":
                return TextAttribute.RUN_DIRECTION_LTR;
            default:
                throw new AssertionError("Constant name is not recognized");
        }
    }

    // java.awt.font.NumericShaper
    public void shape(Object shaper, char[] text, int start, int count) {
        assert shaper instanceof NumericShaper;
        ((NumericShaper)shaper).shape(text, start,count);
    }

}
