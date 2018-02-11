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
import javafx.css.SizeUnits;
import javafx.css.StyleConverter;
import javafx.css.ParsedValue;
import javafx.scene.text.Font;

/**
 * A type that combines two Size values.  The primary purpose of
 * this type is to handle "convert(size1, size2)" expressions in CSS.
 */
public final class DeriveSizeConverter extends StyleConverter<ParsedValue<Size, Size>[], Size> {

    // lazy, thread-safe instatiation
    private static class Holder {
        static final DeriveSizeConverter INSTANCE = new DeriveSizeConverter();
    }

    public static DeriveSizeConverter getInstance() {
        return Holder.INSTANCE;
    }

    private DeriveSizeConverter() {
        super();
    }

    @Override
    public Size convert(ParsedValue<ParsedValue<Size, Size>[], Size> value, Font font) {
        final ParsedValue<Size, Size>[] sizes = value.getValue();
        final double px1 = sizes[0].convert(font).pixels(font);
        final double px2 = sizes[1].convert(font).pixels(font);
        return new Size(px1 + px2, SizeUnits.PX);
    }

    @Override
    public String toString() {
        return "DeriveSizeConverter";
    }
}
