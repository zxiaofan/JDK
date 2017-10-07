/*
 * Copyright (c) 2014, 2015, Oracle and/or its affiliates. All rights reserved.
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
import javafx.css.ParsedValue;
import javafx.css.StyleConverter;
import javafx.scene.text.Font;
import javafx.util.Duration;

/**
 * Convert a Size to Duration
 *
 * @since 9
 */
public final class DurationConverter extends StyleConverter<ParsedValue<?, Size>, Duration> {

    // lazy, thread-safe instatiation
    private static class Holder {
        static final DurationConverter INSTANCE = new DurationConverter();
    }

    public static StyleConverter<ParsedValue<?, Size>, Duration> getInstance() {
        return Holder.INSTANCE;
    }

    private DurationConverter() {
        super();
    }

    @Override
    public Duration convert(ParsedValue<ParsedValue<?, Size>, Duration> value, Font font) {
        ParsedValue<?, Size> parsedValue = value.getValue();
        Size size = parsedValue.convert(font);
        double time = size.getValue();
        Duration duration = null;
        if (time < Double.POSITIVE_INFINITY) {
            switch (size.getUnits()) {
                case S:  duration = Duration.seconds(time); break;
                case MS: duration = Duration.millis(time);  break;
                default: duration = Duration.UNKNOWN;
            }
        } else {
            duration = Duration.INDEFINITE;
        }
        return duration;
    }

    @Override
    public String toString() {
        return "DurationConverter";
    }

}
