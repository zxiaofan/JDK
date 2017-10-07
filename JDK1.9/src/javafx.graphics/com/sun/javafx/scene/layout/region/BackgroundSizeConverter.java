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

import javafx.css.ParsedValue;
import javafx.css.Size;
import javafx.css.SizeUnits;
import javafx.css.StyleConverter;
import javafx.css.converter.BooleanConverter;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.text.Font;

/**
 */
public final class BackgroundSizeConverter  extends StyleConverter<ParsedValue[], BackgroundSize> {
    private static final BackgroundSizeConverter BACKGROUND_SIZE_CONVERTER =
            new BackgroundSizeConverter();

    public static BackgroundSizeConverter getInstance() {
        return BACKGROUND_SIZE_CONVERTER;
    }

    // Disallow instantiation
    private BackgroundSizeConverter() { }

    @Override
    public BackgroundSize convert(ParsedValue<ParsedValue[], BackgroundSize> value, Font font) {
        ParsedValue[] values = value.getValue();

        // A Size that is null represents that we are "auto" for that dimension
        final Size wSize = (values[0] != null)
                ? ((ParsedValue<?, Size>) values[0]).convert(font) : null;
        final Size hSize = (values[1] != null)
                ? ((ParsedValue<?, Size>) values[1]).convert(font) : null;

        boolean proportionalWidth = true;
        boolean proportionalHeight = true;

        if (wSize != null) {
            proportionalWidth = wSize.getUnits() == SizeUnits.PERCENT;
        }
        if (hSize != null) {
            // wSize will be null if wSize is AUTO
            proportionalHeight = hSize.getUnits() == SizeUnits.PERCENT;
        }

        double w = (wSize != null) ? wSize.pixels(font) : BackgroundSize.AUTO;
        double h = (hSize != null) ? hSize.pixels(font) : BackgroundSize.AUTO;

        boolean cover = (values[2] != null)
                ? BooleanConverter.getInstance().convert(values[2], font) : false;

        boolean contain = (values[3] != null)
                ? BooleanConverter.getInstance().convert(values[3], font) : false;

        return new BackgroundSize(w, h, proportionalWidth, proportionalHeight, contain, cover);
    }

    /**
     * @inheritDoc
     */
    @Override public String toString() {
        return "BackgroundSizeConverter";
    }
}
