/*
 * Copyright (c) 2011, 2015, Oracle and/or its affiliates. All rights reserved.
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

package javafx.css.converter;

import javafx.css.Size;
import javafx.css.StyleConverter;
import javafx.css.ParsedValue;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

/**
 * Derive a Color from a Color and a brightness value
 */
public final class DeriveColorConverter extends StyleConverter<ParsedValue[], Color> {

    // lazy, thread-safe instatiation
    private static class Holder {
        static final DeriveColorConverter INSTANCE = new DeriveColorConverter();
    }

    public static DeriveColorConverter getInstance() {
        return Holder.INSTANCE;
    }

    private DeriveColorConverter() {
        super();
    }

    @Override
    public Color convert(ParsedValue<ParsedValue[], Color> value, Font font) {
        ParsedValue[] values = value.getValue();
        final Color color = (Color) values[0].convert(font);
        final Size brightness = (Size) values[1].convert(font);
        return com.sun.javafx.util.Utils.deriveColor(color, brightness.pixels(font));
    }

    @Override
    public String toString() {
        return "DeriveColorConverter";
    }
}
