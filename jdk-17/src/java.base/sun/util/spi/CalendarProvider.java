/*
 * Copyright (c) 2013, Oracle and/or its affiliates. All rights reserved.
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

package sun.util.spi;

import java.util.Calendar;
import java.util.Locale;
import java.util.TimeZone;
import java.util.spi.LocaleServiceProvider;

/**
 * An abstract class for service providers that
 * provide instances of the
 * {@link java.util.Calendar Calendar} class.
 *
 * @since        1.8
 */
public abstract class CalendarProvider extends LocaleServiceProvider {

    /**
     * Sole constructor.  (For invocation by subclass constructors, typically
     * implicit.)
     */
    protected CalendarProvider() {
    }

    /**
     * Returns a new <code>Calendar</code> instance for the
     * specified locale.
     *
     * @param zone the time zone
     * @param locale the desired locale
     * @exception NullPointerException if <code>locale</code> is null
     * @exception IllegalArgumentException if <code>locale</code> isn't
     *     one of the locales returned from
     *     {@link java.util.spi.LocaleServiceProvider#getAvailableLocales()
     *     getAvailableLocales()}.
     * @return a <code>Calendar</code> instance.
     * @see java.util.Calendar#getInstance(java.util.Locale)
     */
    public abstract Calendar getInstance(TimeZone zone, Locale locale);
}
