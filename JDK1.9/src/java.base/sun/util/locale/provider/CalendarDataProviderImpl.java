/*
 * Copyright (c) 2012, 2013, Oracle and/or its affiliates. All rights reserved.
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
package sun.util.locale.provider;

import java.util.Locale;
import java.util.Set;
import java.util.spi.CalendarDataProvider;

/**
 * Concrete implementation of the  {@link java.util.spi.CalendarDataProvider
 * CalendarDataProvider} class for the JRE LocaleProviderAdapter.
 *
 * @author Masayoshi Okutsu
 * @author Naoto Sato
 */
public class CalendarDataProviderImpl extends CalendarDataProvider implements AvailableLanguageTags {
    private final LocaleProviderAdapter.Type type;
    private final Set<String> langtags;

    public CalendarDataProviderImpl(LocaleProviderAdapter.Type type, Set<String> langtags) {
        this.type = type;
        this.langtags = langtags;
    }

    @Override
    public int getFirstDayOfWeek(Locale locale) {
        return LocaleProviderAdapter.forType(type).getLocaleResources(locale)
                   .getCalendarData(CalendarDataUtility.FIRST_DAY_OF_WEEK);
    }

    @Override
    public int getMinimalDaysInFirstWeek(Locale locale) {
        return LocaleProviderAdapter.forType(type).getLocaleResources(locale)
                   .getCalendarData(CalendarDataUtility.MINIMAL_DAYS_IN_FIRST_WEEK);
    }

    @Override
    public Locale[] getAvailableLocales() {
        return LocaleProviderAdapter.toLocaleArray(langtags);
    }

    @Override
    public Set<String> getAvailableLanguageTags() {
        return langtags;
    }
}
