/*
 * Copyright (c) 2005, 2019, Oracle and/or its affiliates. All rights reserved.
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

package java.text.spi;

import java.text.NumberFormat;
import java.util.Locale;
import java.util.spi.LocaleServiceProvider;

/**
 * An abstract class for service providers that
 * provide concrete implementations of the
 * {@link java.text.NumberFormat NumberFormat} class.
 *
 * @since        1.6
 */
public abstract class NumberFormatProvider extends LocaleServiceProvider {

    /**
     * Sole constructor.  (For invocation by subclass constructors, typically
     * implicit.)
     */
    protected NumberFormatProvider() {
    }

    /**
     * Returns a new {@code NumberFormat} instance which formats
     * monetary values for the specified locale.
     *
     * @param locale the desired locale.
     * @throws    NullPointerException if {@code locale} is null
     * @throws    IllegalArgumentException if {@code locale} isn't
     *     one of the locales returned from
     *     {@link java.util.spi.LocaleServiceProvider#getAvailableLocales()
     *     getAvailableLocales()}.
     * @return a currency formatter
     * @see java.text.NumberFormat#getCurrencyInstance(java.util.Locale)
     */
    public abstract NumberFormat getCurrencyInstance(Locale locale);

    /**
     * Returns a new {@code NumberFormat} instance which formats
     * integer values for the specified locale.
     * The returned number format is configured to
     * round floating point numbers to the nearest integer using
     * half-even rounding (see {@link java.math.RoundingMode#HALF_EVEN HALF_EVEN})
     * for formatting, and to parse only the integer part of
     * an input string (see {@link
     * java.text.NumberFormat#isParseIntegerOnly isParseIntegerOnly}).
     *
     * @param locale the desired locale
     * @throws    NullPointerException if {@code locale} is null
     * @throws    IllegalArgumentException if {@code locale} isn't
     *     one of the locales returned from
     *     {@link java.util.spi.LocaleServiceProvider#getAvailableLocales()
     *     getAvailableLocales()}.
     * @return a number format for integer values
     * @see java.text.NumberFormat#getIntegerInstance(java.util.Locale)
     */
    public abstract NumberFormat getIntegerInstance(Locale locale);

    /**
     * Returns a new general-purpose {@code NumberFormat} instance for
     * the specified locale.
     *
     * @param locale the desired locale
     * @throws    NullPointerException if {@code locale} is null
     * @throws    IllegalArgumentException if {@code locale} isn't
     *     one of the locales returned from
     *     {@link java.util.spi.LocaleServiceProvider#getAvailableLocales()
     *     getAvailableLocales()}.
     * @return a general-purpose number formatter
     * @see java.text.NumberFormat#getNumberInstance(java.util.Locale)
     */
    public abstract NumberFormat getNumberInstance(Locale locale);

    /**
     * Returns a new {@code NumberFormat} instance which formats
     * percentage values for the specified locale.
     *
     * @param locale the desired locale
     * @throws    NullPointerException if {@code locale} is null
     * @throws    IllegalArgumentException if {@code locale} isn't
     *     one of the locales returned from
     *     {@link java.util.spi.LocaleServiceProvider#getAvailableLocales()
     *     getAvailableLocales()}.
     * @return a percent formatter
     * @see java.text.NumberFormat#getPercentInstance(java.util.Locale)
     */
    public abstract NumberFormat getPercentInstance(Locale locale);

    /**
     * Returns a new {@code NumberFormat} instance which formats
     * a number in its compact form for the specified
     * {@code locale} and {@code formatStyle}.
     *
     * @implSpec The default implementation of this method throws
     * {@link java.lang.UnsupportedOperationException
     * UnsupportedOperationException}. Overriding the implementation
     * of this method returns the compact number formatter instance
     * of the given {@code locale} with specified {@code formatStyle}.
     *
     * @param locale the desired locale
     * @param formatStyle the style for formatting a number
     * @throws NullPointerException if {@code locale} or {@code formatStyle}
     *     is {@code null}
     * @throws IllegalArgumentException if {@code locale} is not
     *     one of the locales returned from
     *     {@link java.util.spi.LocaleServiceProvider#getAvailableLocales()
     *     getAvailableLocales()}.
     * @throws UnsupportedOperationException if the implementation does not
     *      support this method
     * @return a compact number formatter
     *
     * @see java.text.NumberFormat#getCompactNumberInstance(Locale,
     *                      NumberFormat.Style)
     * @since 12
     */
    public NumberFormat getCompactNumberInstance(Locale locale,
            NumberFormat.Style formatStyle) {
        throw new UnsupportedOperationException(
                "The " + this.getClass().getName() + " should override this"
                + " method to return compact number format instance of "
                + locale + " locale and " + formatStyle + " style.");
    }

}
