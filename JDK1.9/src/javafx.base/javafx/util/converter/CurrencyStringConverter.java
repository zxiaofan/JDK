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

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.NumberFormat;
import java.util.Locale;
import javafx.util.StringConverter;

/**
 * <p>{@link StringConverter} implementation for {@link Number} values
 * that represent currency.</p>
 *
 * @see PercentageStringConverter
 * @see NumberStringConverter
 * @see StringConverter
 * @since JavaFX 2.1
 */
public class CurrencyStringConverter extends NumberStringConverter {

    // ------------------------------------------------------------ Constructors
    public CurrencyStringConverter() {
        this(Locale.getDefault());
    }

    public CurrencyStringConverter(Locale locale) {
        this(locale, null);
    }

    public CurrencyStringConverter(String pattern) {
        this(Locale.getDefault(), pattern);
    }

    public CurrencyStringConverter(Locale locale, String pattern) {
        super(locale, pattern, null);
    }

    public CurrencyStringConverter(NumberFormat numberFormat) {
        super(null, null, numberFormat);
    }


    // ---------------------------------------------------------------0- Methods

    /** {@inheritDoc} */
    @Override protected NumberFormat getNumberFormat() {
        Locale _locale = locale == null ? Locale.getDefault() : locale;

        if (numberFormat != null) {
            return numberFormat;
        } else if (pattern != null) {
            DecimalFormatSymbols symbols = new DecimalFormatSymbols(_locale);
            return new DecimalFormat(pattern, symbols);
        } else {
            return NumberFormat.getCurrencyInstance(_locale);
        }
    }
}
