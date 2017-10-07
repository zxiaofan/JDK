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

import java.math.BigDecimal;
import javafx.util.StringConverter;

/**
 * <p>{@link StringConverter} implementation for {@link BigDecimal} values.</p>
 * @since JavaFX 2.1
 */
public class BigDecimalStringConverter extends StringConverter<BigDecimal> {

    /** {@inheritDoc} */
    @Override public BigDecimal fromString(String value) {
        // If the specified value is null or zero-length, return null
        if (value == null) {
            return null;
        }

        value = value.trim();

        if (value.length() < 1) {
            return null;
        }

        return new BigDecimal(value);
    }

    /** {@inheritDoc} */
    @Override public String toString(BigDecimal value) {
        // If the specified value is null, return a zero-length String
        if (value == null) {
            return "";
        }

        return ((BigDecimal)value).toString();
    }
}
