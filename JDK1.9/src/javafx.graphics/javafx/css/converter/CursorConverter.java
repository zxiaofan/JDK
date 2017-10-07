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

import javafx.css.ParsedValue;
import javafx.css.StyleConverter;
import javafx.scene.Cursor;
import javafx.scene.text.Font;

/**
 * @since 9
 */
public final class CursorConverter extends StyleConverter<String, Cursor> {

    // lazy, thread-safe instatiation
    private static class Holder {
        static final CursorConverter INSTANCE = new CursorConverter();
    }

    public static StyleConverter<String, Cursor> getInstance() {
        return Holder.INSTANCE;
    }

    private CursorConverter() {
        super();
    }

    @Override
    public Cursor convert(ParsedValue<String, Cursor> value, Font not_used) {

        // the parser doesn't covert cusor, so convert it from the raw value
        String string = value.getValue();

        if (string != null) {

            int index = string.indexOf("Cursor.");
            if (index > -1) {
                string = string.substring(index+"Cursor.".length());
            }
            string = string.replace('-','_').toUpperCase();
        }

        try {
            return Cursor.cursor(string);
        } catch (IllegalArgumentException | NullPointerException exception) {
            return Cursor.DEFAULT;
        }
    }

    @Override
    public String toString() {
        return "CursorConverter";
    }
}
