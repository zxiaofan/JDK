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

import com.sun.javafx.util.Utils;
import javafx.css.Size;
import javafx.css.CssMetaData;
import javafx.css.ParsedValue;
import javafx.css.StyleConverter;
import javafx.css.Styleable;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;

import java.util.Locale;
import java.util.Map;
import java.util.Map.Entry;

/**
 * @since 9
 */
public final class FontConverter extends StyleConverter<ParsedValue[], Font> {

    // lazy, thread-safe instatiation
    private static class Holder {
        static final FontConverter INSTANCE = new FontConverter();
    }

    public static StyleConverter<ParsedValue[], Font> getInstance() {
        return Holder.INSTANCE;
    }

    private FontConverter() {
        super();
    }

    @Override
    public Font convert(ParsedValue<ParsedValue[], Font> value, Font font) {
        ParsedValue[] values = value.getValue();
        Font aFont = (font != null) ? font : Font.getDefault();
        String family = (values[0] != null) ? Utils.stripQuotes((String) values[0].convert(aFont)) : aFont.getFamily();
        // if font size is given in terms of percent, then we have to call
        // pixels directly in order to pass the multiplier.
        double fsize = aFont.getSize();
        if (values[1] != null) {
            ParsedValue<?, ?> pv = (ParsedValue<?, ?>) values[1].getValue();
            Size size = (Size) pv.convert(aFont);
            fsize = size.pixels(aFont.getSize(), aFont);
        }
        FontWeight weight = (values[2] != null) ? (FontWeight) values[2].convert(aFont) : FontWeight.NORMAL;
        FontPosture style = (values[3] != null) ? (FontPosture) values[3].convert(aFont) : FontPosture.REGULAR;
        Font f = Font.font(family, weight, style, fsize);
        return f;
    }

    @Override
    public Font convert(Map<CssMetaData<? extends Styleable, ?>, Object> convertedValues) {
        Font font = Font.getDefault();
        double size = font.getSize();
        String family = font.getFamily();
        FontWeight weight = FontWeight.NORMAL;
        FontPosture style = FontPosture.REGULAR;

        for (Entry<CssMetaData<? extends Styleable, ?>, Object> entry : convertedValues.entrySet()) {

            Object value = entry.getValue();
            if (value == null) {
                continue;
            }
            final String prop = entry.getKey().getProperty();
            if (prop.endsWith("font-size")) {
                size = ((Number) value).doubleValue();
            } else if (prop.endsWith("font-family")) {
                family = Utils.stripQuotes((String) value);
            } else if (prop.endsWith("font-weight")) {
                weight = (FontWeight) value;
            } else if (prop.endsWith("font-style")) {
                style = (FontPosture) value;
            }
        }
        final Font f = Font.font(family, weight, style, size);
        return f;
    }

    @Override
    public String toString() {
        return "FontConverter";
    }

    public static final class FontStyleConverter extends StyleConverter<String, FontPosture> {

        // lazy, thread-safe instatiation
        private static class Holder {
            static final FontStyleConverter INSTANCE = new FontStyleConverter();
        }

        public static FontStyleConverter getInstance() {
            return Holder.INSTANCE;
        }

        private FontStyleConverter() {
            super();
        }

        @Override
        public FontPosture convert(ParsedValue<String, FontPosture> value, Font font) {

            // Testing for RT-31022 exposed a ClassCastException where value
            // wraps a String (e.g., "ITALIC", not a FontUnits.Style).
            final Object val = value.getValue();

            FontPosture style = null;

            if (val instanceof String) {
                try {
                    String sval = ((String)val).toUpperCase(Locale.ROOT);
                    style = Enum.valueOf(FontPosture.class, sval);
                } catch (IllegalArgumentException iae) {
                    style =  FontPosture.REGULAR;
                } catch (NullPointerException npe) {
                    style =  FontPosture.REGULAR;
                }

            } else if (val instanceof FontPosture) {
                style = (FontPosture)val;
            }
            return style;
        }

        @Override
        public String toString() {
            return "FontConverter.StyleConverter";
        }
    }

    public static final class FontWeightConverter extends StyleConverter<String, FontWeight> {

        // lazy, thread-safe instatiation
        private static class Holder {
            static final FontWeightConverter INSTANCE = new FontWeightConverter();
        }

        public static FontWeightConverter getInstance() {
            return Holder.INSTANCE;
        }

        private FontWeightConverter() {
            super();
        }

        @Override
        public FontWeight convert(ParsedValue<String, FontWeight> value, Font font) {

            // Testing for RT-31022 exposed a ClassCastException where value
            // wraps a String (e.g., "ITALIC", not a FontUnits.Style).
            final Object val = value.getValue();

            FontWeight weight = null;

            if (val instanceof String) {
                try {
                    String sval = ((String)val).toUpperCase(Locale.ROOT);
                    weight = Enum.valueOf(FontWeight.class, sval);
                } catch (IllegalArgumentException iae) {
                    weight =  FontWeight.NORMAL;
                } catch (NullPointerException npe) {
                    weight =  FontWeight.NORMAL;
                }

            } else if (val instanceof FontWeight) {
                weight = (FontWeight)val;
            }

            return weight;
        }

        @Override
        public String toString() {
            return "FontConverter.WeightConverter";
        }
    }

    public static final class FontSizeConverter extends StyleConverter<ParsedValue<?, Size>, Number> {

        // lazy, thread-safe instatiation
        private static class Holder {
            static final FontSizeConverter INSTANCE = new FontSizeConverter();
        }

        public static FontSizeConverter getInstance() {
            return Holder.INSTANCE;
        }

        private FontSizeConverter() {
            super();
        }

        @Override
        public Number convert(ParsedValue<ParsedValue<?, Size>, Number> value, Font font) {
            final ParsedValue<?, Size> size = value.getValue();
            return size.convert(font).pixels(font.getSize(), font);
        }

        @Override
        public String toString() {
            return "FontConverter.FontSizeConverter";
        }
    }

}
