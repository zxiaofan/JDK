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
 * <p>{@link StringConverter} implementation for {@link Character}
 * (and char primitive) values.</p>
 * @since JavaFX 2.1
 */
public class CharacterStringConverter extends StringConverter<Character> {
    /** {@inheritDoc} */
    @Override public Character fromString(String value) {
        // If the specified value is null or zero-length, return null
        if (value == null) {
            return null;
        }

        value = value.trim();

        if (value.length() < 1) {
            return null;
        }

        return Character.valueOf(value.charAt(0));
    }

    /** {@inheritDoc} */
    @Override public String toString(Character value) {
        // If the specified value is null, return a zero-length String
        if (value == null) {
            return "";
        }

        return value.toString();
    }
}
