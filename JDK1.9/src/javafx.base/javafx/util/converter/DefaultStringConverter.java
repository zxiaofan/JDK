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
 * <p>{@link StringConverter} implementation for {@link String} values.</p>
 * @since JavaFX 2.1
 */
public class DefaultStringConverter extends StringConverter<String> {
    /** {@inheritDoc} */
    @Override public String toString(String value) {
        return (value != null) ? value : "";
    }

    /** {@inheritDoc} */
    @Override public String fromString(String value) {
        return value;
    }
}
