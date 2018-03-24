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
 * <p>{@link StringConverter} implementation for {@link Short} values.</p>
 * @since JavaFX 2.1
 */
public class ShortStringConverter extends StringConverter<Short> {
    /** {@inheritDoc} */
    @Override public Short fromString(String text) {
        // If the specified value is null or zero-length, return null
        if (text == null) {
            return null;
        }

        text = text.trim();

        if (text.length() < 1) {
            return null;
        }

        return Short.valueOf(text);
    }

    /** {@inheritDoc} */
    @Override public String toString(Short value) {
        // If the specified value is null, return a
        // zero-length String
        if (value == null) {
            return "";
        }

        return Short.toString(((Short)value).shortValue());
    }
}
