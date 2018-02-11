/*
 * Copyright (c) 2010, 2013, Oracle and/or its affiliates. All rights reserved.
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

package javafx.util.converter;

import javafx.util.StringConverter;

/**
 * <p>{@link StringConverter} implementation for {@link Float}
 * (and float primitive) values.</p>
 * @since JavaFX 2.1
 */
public class FloatStringConverter extends StringConverter<Float> {
    /** {@inheritDoc} */
    @Override public Float fromString(String value) {
        // If the specified value is null or zero-length, return null
        if (value == null) {
            return null;
        }

        value = value.trim();

        if (value.length() < 1) {
            return null;
        }

        return Float.valueOf(value);
    }

    /** {@inheritDoc} */
    @Override public String toString(Float value) {
        // If the specified value is null, return a zero-length String
        if (value == null) {
            return "";
        }

        return Float.toString(((Float)value).floatValue());
    }
}
