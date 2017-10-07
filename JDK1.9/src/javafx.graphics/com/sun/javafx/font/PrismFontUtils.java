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

package com.sun.javafx.font;

import com.sun.javafx.geom.transform.BaseTransform;

public class PrismFontUtils {

    private PrismFontUtils() {
    }

    static Metrics getFontMetrics(PGFont font) {
        FontStrike strike = font.getStrike(BaseTransform.IDENTITY_TRANSFORM,
                                           FontResource.AA_GREYSCALE);
        return strike.getMetrics();
    }

    static double getCharWidth(PGFont font, char ch) {
        FontStrike strike = font.getStrike(BaseTransform.IDENTITY_TRANSFORM,
                                           FontResource.AA_GREYSCALE);
        double width = strike.getCharAdvance(ch);
        if (width == 0) {
            width = font.getSize() / 2.0; // better than zero.
        }
        return width;
    }
}
