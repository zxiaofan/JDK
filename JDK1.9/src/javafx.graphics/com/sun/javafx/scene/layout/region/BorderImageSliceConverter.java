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

package com.sun.javafx.scene.layout.region;

import javafx.scene.layout.BorderWidths;
import javafx.scene.text.Font;
import javafx.css.ParsedValue;
import javafx.css.Size;
import javafx.css.SizeUnits;
import javafx.css.StyleConverter;

/**
 */
public final class BorderImageSliceConverter extends StyleConverter<ParsedValue[], BorderImageSlices> {

    private static final BorderImageSliceConverter BORDER_IMAGE_SLICE_CONVERTER =
            new BorderImageSliceConverter();

    public static BorderImageSliceConverter getInstance() {
        return BORDER_IMAGE_SLICE_CONVERTER;
    }

    // Disallow instantiation
    private BorderImageSliceConverter() { }

    @Override
    public BorderImageSlices convert(ParsedValue<ParsedValue[], BorderImageSlices> layer, Font font) {
        // Parser sends insets and boolean fill
        final ParsedValue[] values = layer.getValue();

        // value[0] is ParsedValue<Value<?,Size>[],Insets>
        final ParsedValue<?, Size>[] sizes = (ParsedValue<?, Size>[]) values[0].getValue();
        final Size topSz = sizes[0].convert(font);
        final Size rightSz = sizes[1].convert(font);
        final Size bottomSz = sizes[2].convert(font);
        final Size leftSz = sizes[3].convert(font);

        return new BorderImageSlices(
                new BorderWidths(
                topSz.pixels(font),
                rightSz.pixels(font),
                bottomSz.pixels(font),
                leftSz.pixels(font),
                topSz.getUnits() == SizeUnits.PERCENT,
                rightSz.getUnits() == SizeUnits.PERCENT,
                bottomSz.getUnits() == SizeUnits.PERCENT,
                leftSz.getUnits() == SizeUnits.PERCENT
                ),
                (Boolean) values[1].getValue());
    }

    /**
     * @inheritDoc
     */
    @Override public String toString() {
        return "BorderImageSliceConverter";
    }
}
