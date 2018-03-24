/*
 * Copyright (c) 2012, 2015, Oracle and/or its affiliates. All rights reserved.
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

import javafx.scene.layout.BorderStrokeStyle;
import javafx.scene.text.Font;
import javafx.css.ParsedValue;
import javafx.css.StyleConverter;

/**
 * User: richardbair
 * Date: 8/10/12
 * Time: 7:31 AM
 */
public final class BorderStrokeStyleSequenceConverter extends StyleConverter<ParsedValue<ParsedValue[],BorderStrokeStyle>[],BorderStrokeStyle[]> {
    /**
     * Convert an array of border style values to an array of BorderStyle which
     * contains one BorderStyle element per border (top, right, bottom, left).
     */
    private static final BorderStrokeStyleSequenceConverter BORDER_STYLE_SEQUENCE_CONVERTER =
            new BorderStrokeStyleSequenceConverter();

    public static BorderStrokeStyleSequenceConverter getInstance() {
        return BORDER_STYLE_SEQUENCE_CONVERTER;
    }

    private BorderStrokeStyleSequenceConverter() {
        super();
    }

    @Override
    public BorderStrokeStyle[] convert(ParsedValue<ParsedValue<ParsedValue[],BorderStrokeStyle>[], BorderStrokeStyle[]> value, Font font) {

        ParsedValue<ParsedValue[],BorderStrokeStyle>[] borders = value.getValue();
        BorderStrokeStyle[] styles = new BorderStrokeStyle[4];

        styles[0] = (borders.length > 0) ?
                borders[0].convert(font) : BorderStrokeStyle.SOLID;

        styles[1] = (borders.length > 1) ?
                borders[1].convert(font) : styles[0];

        styles[2] = (borders.length > 2) ?
                borders[2].convert(font) : styles[0];

        styles[3] = (borders.length > 3) ?
                borders[3].convert(font) : styles[1];

        return styles;
    }

    @Override
    public String toString() {
        return "BorderStrokeStyleSequenceConverter";
    }

}
