/*
 * %W% %E%
 *
 * Copyright (c) 2006, Oracle and/or its affiliates. All rights reserved.
 * ORACLE PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

package java.util.spi;

import java.util.Locale;

/**
 * An abstract class for service providers that
 * provide localized names for the 
 * {@link java.util.Locale Locale} class.
 *
 * @since        1.6
 * @version      %W% %E%
 */
public abstract class LocaleNameProvider extends LocaleServiceProvider {

    /**
     * Sole constructor.  (For invocation by subclass constructors, typically
     * implicit.)
     */
    protected LocaleNameProvider() {
    }

    /**
     * Returns a localized name for the given ISO 639 language code and the 
     * given locale that is appropriate for display to the user.
     * For example, if <code>languageCode</code> is "fr" and <code>locale</code>
     * is en_US, getDisplayLanguage() will return "French"; if <code>languageCode</code>
     * is "en" and <code>locale</code> is fr_FR, getDisplayLanguage() will return "anglais".
     * If the name returned cannot be localized according to <code>locale</code>,
     * (say, the provider does not have a Japanese name for Croatian),
     * this method returns null.
     * @param languageCode the ISO 639 language code string in the form of two
     *     lower-case letters between 'a' (U+0061) and 'z' (U+007A)
     * @param locale the desired locale
     * @return the name of the given language code for the specified locale, or null if it's not 
     *     available.
     * @exception NullPointerException if <code>languageCode</code> or <code>locale</code> is null
     * @exception IllegalArgumentException if <code>languageCode</code> is not in the form of
     *     two lower-case letters, or <code>locale</code> isn't
     *     one of the locales returned from 
     *     {@link java.util.spi.LocaleServiceProvider#getAvailableLocales() 
     *     getAvailableLocales()}.
     * @see java.util.Locale#getDisplayLanguage(java.util.Locale)
     */
    public abstract String getDisplayLanguage(String languageCode, Locale locale);

    /**
     * Returns a localized name for the given ISO 3166 country code and the 
     * given locale that is appropriate for display to the user.
     * For example, if <code>countryCode</code> is "FR" and <code>locale</code>
     * is en_US, getDisplayCountry() will return "France"; if <code>countryCode</code> 
     * is "US" and <code>locale</code> is fr_FR, getDisplayCountry() will return "Etats-Unis".
     * If the name returned cannot be localized according to <code>locale</code>,
     * (say, the provider does not have a Japanese name for Croatia),
     * this method returns null.
     * @param countryCode the ISO 3166 country code string in the form of two
     *     upper-case letters between 'A' (U+0041) and 'Z' (U+005A)
     * @param locale the desired locale
     * @return the name of the given country code for the specified locale, or null if it's not
     *     available.
     * @exception NullPointerException if <code>countryCode</code> or <code>locale</code> is null
     * @exception IllegalArgumentException if <code>countryCode</code> is not in the form of
     *     two upper-case letters, or <code>locale</code> isn't
     *     one of the locales returned from 
     *     {@link java.util.spi.LocaleServiceProvider#getAvailableLocales() 
     *     getAvailableLocales()}.
     * @see java.util.Locale#getDisplayCountry(java.util.Locale)
     */
    public abstract String getDisplayCountry(String countryCode, Locale locale);

    /**
     * Returns a localized name for the given variant code and the given locale that 
     * is appropriate for display to the user.
     * If the name returned cannot be localized according to <code>locale</code>,
     * this method returns null.
     * @param variant the variant string
     * @param locale the desired locale
     * @return the name of the given variant string for the specified locale, or null if it's not
     *     available.
     * @exception NullPointerException if <code>variant</code> or <code>locale</code> is null
     * @exception IllegalArgumentException if <code>locale</code> isn't
     *     one of the locales returned from 
     *     {@link java.util.spi.LocaleServiceProvider#getAvailableLocales() 
     *     getAvailableLocales()}.
     * @see java.util.Locale#getDisplayVariant(java.util.Locale)
     */
    public abstract String getDisplayVariant(String variant, Locale locale);
}
