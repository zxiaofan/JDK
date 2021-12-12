/*
 * Copyright (c) 2016, Oracle and/or its affiliates. All rights reserved.
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
import sun.text.spi.JavaTimeDateTimePatternProvider;

/**
 * Concrete implementation of the {@link sun.text.spi.JavaTimeDateTimePatternProvider
 * } class for the JRE LocaleProviderAdapter.
 *
 */
public class JavaTimeDateTimePatternImpl extends JavaTimeDateTimePatternProvider implements AvailableLanguageTags {

    private final LocaleProviderAdapter.Type type;
    private final Set<String> langtags;

    public JavaTimeDateTimePatternImpl(LocaleProviderAdapter.Type type, Set<String> langtags) {
        this.type = type;
        this.langtags = langtags;
    }

    /**
     * Returns an array of all locales for which this locale service provider
     * can provide localized objects or names.
     *
     * @return An array of all locales for which this locale service provider
     * can provide localized objects or names.
     */
    @Override
    public Locale[] getAvailableLocales() {
        return LocaleProviderAdapter.toLocaleArray(langtags);
    }

    @Override
    public boolean isSupportedLocale(Locale locale) {
        return LocaleProviderAdapter.forType(type).isSupportedProviderLocale(locale, langtags);
    }

    @Override
    public String getJavaTimeDateTimePattern(int timeStyle, int dateStyle, String calType, Locale locale) {
        LocaleResources lr = LocaleProviderAdapter.getResourceBundleBased().getLocaleResources(locale);
        String pattern = lr.getJavaTimeDateTimePattern(
                timeStyle, dateStyle, calType);
        return pattern;

    }

    @Override
    public Set<String> getAvailableLanguageTags() {
        return langtags;
    }
}
