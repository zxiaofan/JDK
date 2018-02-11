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

import java.text.NumberFormat;
import java.util.Locale;
import javafx.util.StringConverter;

/**
 * <p>{@link StringConverter} implementation for {@link Number} values
 * that represent percentages.</p>
 *
 * @see CurrencyStringConverter
 * @see NumberStringConverter
 * @see StringConverter
 * @since JavaFX 2.1
 */
public class PercentageStringConverter extends NumberStringConverter {


    // ------------------------------------------------------------ Constructors
    public PercentageStringConverter() {
        this(Locale.getDefault());
    }

    public PercentageStringConverter(Locale locale) {
        super(locale, null, null);
    }

    public PercentageStringConverter(NumberFormat numberFormat) {
        super(null, null, numberFormat);
    }

    // ----------------------------------------------------------------- Methods

    /** {@inheritDoc} */
    @Override public NumberFormat getNumberFormat() {
        Locale _locale = locale == null ? Locale.getDefault() : locale;

        if (numberFormat != null) {
            return numberFormat;
        } else {
            return NumberFormat.getPercentInstance(_locale);
        }
    }
}
