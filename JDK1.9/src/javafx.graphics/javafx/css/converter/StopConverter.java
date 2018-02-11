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
import javafx.scene.paint.Stop;
import javafx.scene.text.Font;

/**
 * convert a Stop from a Size and a Color
 */
public final class StopConverter extends StyleConverter<ParsedValue[], Stop> {

    // lazy, thread-safe instatiation
    private static class Holder {
        static final StopConverter INSTANCE = new StopConverter();
    }

    public static StopConverter getInstance() {
        return Holder.INSTANCE;
    }

    private StopConverter() {
        super();
    }

    @Override
    public Stop convert(ParsedValue<ParsedValue[], Stop> value, Font font) {
        ParsedValue[] values = value.getValue();
        final Double offset = ((Size) values[0].convert(font)).pixels(font);
        final Color color = (Color) values[1].convert(font);
        return new Stop(offset, color);
    }

    @Override
    public String toString() {
        return "StopConverter";
    }
}
