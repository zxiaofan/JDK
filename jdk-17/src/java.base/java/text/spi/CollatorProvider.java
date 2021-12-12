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

import java.text.Collator;
import java.util.Locale;
import java.util.spi.LocaleServiceProvider;

/**
 * An abstract class for service providers that
 * provide concrete implementations of the
 * {@link java.text.Collator Collator} class.
 *
 * @since        1.6
 */
public abstract class CollatorProvider extends LocaleServiceProvider {

    /**
     * Sole constructor.  (For invocation by subclass constructors, typically
     * implicit.)
     */
    protected CollatorProvider() {
    }

    /**
     * Returns a new {@code Collator} instance for the specified locale.
     * @param locale the desired locale.
     * @return the {@code Collator} for the desired locale.
     * @throws    NullPointerException if
     * {@code locale} is null
     * @throws    IllegalArgumentException if {@code locale} isn't
     *     one of the locales returned from
     *     {@link java.util.spi.LocaleServiceProvider#getAvailableLocales()
     *     getAvailableLocales()}.
     * @see java.text.Collator#getInstance(java.util.Locale)
     */
    public abstract Collator getInstance(Locale locale);
}
