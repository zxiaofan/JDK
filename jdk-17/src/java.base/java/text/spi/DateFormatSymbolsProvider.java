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

import java.text.DateFormatSymbols;
import java.util.Locale;
import java.util.spi.LocaleServiceProvider;

/**
 * An abstract class for service providers that
 * provide instances of the
 * {@link java.text.DateFormatSymbols DateFormatSymbols} class.
 *
 * @since        1.6
 */
public abstract class DateFormatSymbolsProvider extends LocaleServiceProvider {

    /**
     * Sole constructor.  (For invocation by subclass constructors, typically
     * implicit.)
     */
    protected DateFormatSymbolsProvider() {
    }

    /**
     * Returns a new {@code DateFormatSymbols} instance for the
     * specified locale.
     *
     * @param locale the desired locale
     * @throws    NullPointerException if {@code locale} is null
     * @throws    IllegalArgumentException if {@code locale} isn't
     *     one of the locales returned from
     *     {@link java.util.spi.LocaleServiceProvider#getAvailableLocales()
     *     getAvailableLocales()}.
     * @return a {@code DateFormatSymbols} instance.
     * @see java.text.DateFormatSymbols#getInstance(java.util.Locale)
     */
    public abstract DateFormatSymbols getInstance(Locale locale);
}
