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

import java.math.BigInteger;
import javafx.util.StringConverter;

/**
 * <p>{@link StringConverter} implementation for {@link BigInteger} values.</p>
 * @since JavaFX 2.1
 */
public class BigIntegerStringConverter extends StringConverter<BigInteger> {
    /** {@inheritDoc} */
    @Override public BigInteger fromString(String value) {
        // If the specified value is null or zero-length, return null
        if (value == null) {
            return null;
        }

        value = value.trim();

        if (value.length() < 1) {
            return null;
        }

        return new BigInteger(value);
    }

    /** {@inheritDoc} */
    @Override public String toString(BigInteger value) {
        // If the specified value is null, return a zero-length String
        if (value == null) {
            return "";
        }

        return ((BigInteger)value).toString();
    }
}
