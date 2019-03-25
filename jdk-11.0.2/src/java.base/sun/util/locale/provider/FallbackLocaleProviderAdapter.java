/*
 * Copyright (c) 2012, 2015, Oracle and/or its affiliates. All rights reserved.
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

import java.util.Collections;
import java.util.Locale;
import java.util.Set;

/**
 * FallbackProviderAdapter implementation.
 *
 * @author Naoto Sato
 */
public class FallbackLocaleProviderAdapter extends JRELocaleProviderAdapter {

    /**
     * Supported language tag set.
     */
    private static final Set<String> rootTagSet =
        Collections.singleton(Locale.ROOT.toLanguageTag());

    /**
     * Fallback provider only provides the ROOT locale data.
     */
    private final LocaleResources rootLocaleResources =
        new LocaleResources(this, Locale.ROOT);

    /**
     * Returns the type of this LocaleProviderAdapter
     */
    @Override
    public LocaleProviderAdapter.Type getAdapterType() {
        return Type.FALLBACK;
    }

    @Override
    public LocaleResources getLocaleResources(Locale locale) {
        return rootLocaleResources;
    }

    @Override
    protected Set<String> createLanguageTagSet(String category) {
        return rootTagSet;
    }

    @Override
    public boolean isSupportedProviderLocale(Locale locale, Set<String>langtags) {
        return Locale.ROOT.equals(locale);
    }
}
