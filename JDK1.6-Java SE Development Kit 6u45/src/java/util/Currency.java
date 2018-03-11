/*
 * %W% %E%
 *
 * Copyright (c) 2006, Oracle and/or its affiliates. All rights reserved.
 * ORACLE PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

package java.util;

import java.io.Serializable;
import java.security.AccessController;
import java.security.PrivilegedAction;
import java.util.spi.CurrencyNameProvider;
import java.util.spi.LocaleServiceProvider;
import sun.util.LocaleServiceProviderPool;
import sun.util.resources.LocaleData;


/**
 * Represents a currency. Currencies are identified by their ISO 4217 currency
 * codes. Visit the <a href="http://www.bsi-global.com/">
 * BSi web site</a> for more information, including a table of
 * currency codes.
 * <p>
 * The class is designed so that there's never more than one
 * <code>Currency</code> instance for any given currency. Therefore, there's
 * no public constructor. You obtain a <code>Currency</code> instance using
 * the <code>getInstance</code> methods.
 *
 * @since 1.4
 */
public final class Currency implements Serializable {

    private static final long serialVersionUID = -158308464356906721L;
    
    /**
     * ISO 4217 currency code for this currency.
     *
     * @serial
     */
    private final String currencyCode;
    
    /**
     * Default fraction digits for this currency.
     * Set from currency data tables.
     */
    transient private final int defaultFractionDigits;


    // class data: instance map

    private static HashMap instances = new HashMap(7);

    
    // Class data: currency data obtained from java.util.CurrencyData.
    // Purpose:
    // - determine valid country codes
    // - determine valid currency codes
    // - map country codes to currency codes
    // - obtain default fraction digits for currency codes
    //
    // sc = special case; dfd = default fraction digits
    // Simple countries are those where the country code is a prefix of the
    // currency code, and there are no known plans to change the currency.
    //
    // table formats:
    // - mainTable:
    //   - maps country code to 8-bit char
    //   - 26*26 entries, corresponding to [A-Z]*[A-Z]
    //   - \u007F -> not valid country
    //   - bit 7 - 1: special case, bits 0-4 indicate which one
    //             0: simple country, bits 0-4 indicate final char of currency code
    //   - bits 5-6: fraction digits for simple countries, 0 for special cases
    //   - bits 0-4: final char for currency code for simple country, or ID of special case
    // - special case IDs:
    //   - 0: country has no currency
    //   - other: index into sc* arrays + 1
    // - scCutOverTimes: cut-over time in millis as returned by
    //   System.currentTimeMillis for special case countries that are changing
    //   currencies; Long.MAX_VALUE for countries that are not changing currencies
    // - scOldCurrencies: old currencies for special case countries
    // - scNewCurrencies: new currencies for special case countries that are
    //   changing currencies; null for others
    // - scOldCurrenciesDFD: default fraction digits for old currencies
    // - scNewCurrenciesDFD: default fraction digits for new currencies, 0 for
    //   countries that are not changing currencies
    // - otherCurrencies: concatenation of all currency codes that are not the
    //   main currency of a simple country, separated by "-"
    // - otherCurrenciesDFD: decimal format digits for currencies in otherCurrencies, same order

    static String mainTable;
    static long[] scCutOverTimes;
    static String[] scOldCurrencies;
    static String[] scNewCurrencies;
    static int[] scOldCurrenciesDFD;
    static int[] scNewCurrenciesDFD;
    static String otherCurrencies;
    static int[] otherCurrenciesDFD;

    // handy constants - must match definitions in GenerateCurrencyData
    // number of characters from A to Z
    private static final int A_TO_Z = ('Z' - 'A') + 1;
    // entry for invalid country codes
    private static final int INVALID_COUNTRY_ENTRY = 0x007F;
    // entry for countries without currency
    private static final int COUNTRY_WITHOUT_CURRENCY_ENTRY = 0x0080;
    // mask for simple case country entries
    private static final int SIMPLE_CASE_COUNTRY_MASK = 0x0000;
    // mask for simple case country entry final character
    private static final int SIMPLE_CASE_COUNTRY_FINAL_CHAR_MASK = 0x001F;
    // mask for simple case country entry default currency digits
    private static final int SIMPLE_CASE_COUNTRY_DEFAULT_DIGITS_MASK = 0x0060;
    // shift count for simple case country entry default currency digits
    private static final int SIMPLE_CASE_COUNTRY_DEFAULT_DIGITS_SHIFT = 5;
    // mask for special case country entries
    private static final int SPECIAL_CASE_COUNTRY_MASK = 0x0080;
    // mask for special case country index
    private static final int SPECIAL_CASE_COUNTRY_INDEX_MASK = 0x001F;
    // delta from entry index component in main table to index into special case tables
    private static final int SPECIAL_CASE_COUNTRY_INDEX_DELTA = 1;
    // mask for distinguishing simple and special case countries
    private static final int COUNTRY_TYPE_MASK = SIMPLE_CASE_COUNTRY_MASK | SPECIAL_CASE_COUNTRY_MASK;

    static {
        AccessController.doPrivileged(new PrivilegedAction() {
            public Object run() {
                try {
                    Class data = Class.forName("java.util.CurrencyData");
                    mainTable = (String) data.getDeclaredField("mainTable").get(data);
                    scCutOverTimes = (long[]) data.getDeclaredField("scCutOverTimes").get(data);
                    scOldCurrencies = (String[]) data.getDeclaredField("scOldCurrencies").get(data);
                    scNewCurrencies = (String[]) data.getDeclaredField("scNewCurrencies").get(data);
                    scOldCurrenciesDFD = (int[]) data.getDeclaredField("scOldCurrenciesDFD").get(data);
                    scNewCurrenciesDFD = (int[]) data.getDeclaredField("scNewCurrenciesDFD").get(data);
                    otherCurrencies = (String) data.getDeclaredField("otherCurrencies").get(data);
                    otherCurrenciesDFD = (int[]) data.getDeclaredField("otherCurrenciesDFD").get(data);
                } catch (ClassNotFoundException e) {
                    throw new InternalError();
                } catch (NoSuchFieldException e) {
                    throw new InternalError();
                } catch (IllegalAccessException e) {
                    throw new InternalError();
                }
                return null;
            }
        });
    }
    

    /**
     * Constructs a <code>Currency</code> instance. The constructor is private
     * so that we can insure that there's never more than one instance for a
     * given currency.
     */
    private Currency(String currencyCode, int defaultFractionDigits) {
        this.currencyCode = currencyCode;
        this.defaultFractionDigits = defaultFractionDigits;
    }
    
    /**
     * Returns the <code>Currency</code> instance for the given currency code.
     *
     * @param currencyCode the ISO 4217 code of the currency
     * @return the <code>Currency</code> instance for the given currency code
     * @exception NullPointerException if <code>currencyCode</code> is null
     * @exception IllegalArgumentException if <code>currencyCode</code> is not
     * a supported ISO 4217 code.
     */
    public static Currency getInstance(String currencyCode) {
        return getInstance(currencyCode, Integer.MIN_VALUE);
    }
    
    private static Currency getInstance(String currencyCode, int defaultFractionDigits) {
        synchronized (instances) {
            // Try to look up the currency code in the instances table.
            // This does the null pointer check as a side effect.
            // Also, if there already is an entry, the currencyCode must be valid.
            Currency instance = (Currency) instances.get(currencyCode);
            if (instance != null) {
                return instance;
            }
        
            if (defaultFractionDigits == Integer.MIN_VALUE) {
                // Currency code not internally generated, need to verify first
                // A currency code must have 3 characters and exist in the main table
                // or in the list of other currencies.
                if (currencyCode.length() != 3) {
                    throw new IllegalArgumentException();
                }
                char char1 = currencyCode.charAt(0);
                char char2 = currencyCode.charAt(1);
                int tableEntry = getMainTableEntry(char1, char2);
                if ((tableEntry & COUNTRY_TYPE_MASK) == SIMPLE_CASE_COUNTRY_MASK
                        && tableEntry != INVALID_COUNTRY_ENTRY
                        && currencyCode.charAt(2) - 'A' == (tableEntry & SIMPLE_CASE_COUNTRY_FINAL_CHAR_MASK)) {
                    defaultFractionDigits = (tableEntry & SIMPLE_CASE_COUNTRY_DEFAULT_DIGITS_MASK) >> SIMPLE_CASE_COUNTRY_DEFAULT_DIGITS_SHIFT;
                } else {
                    // Check for '-' separately so we don't get false hits in the table.
                    if (currencyCode.charAt(2) == '-') {
                        throw new IllegalArgumentException();
                    }
                    int index = otherCurrencies.indexOf(currencyCode);
                    if (index == -1) {
                        throw new IllegalArgumentException();
                    }
                    defaultFractionDigits = otherCurrenciesDFD[index / 4];
                }
            }
        
            instance = new Currency(currencyCode, defaultFractionDigits);
            instances.put(currencyCode, instance);
            return instance;
        }
    }
    
    /**
     * Returns the <code>Currency</code> instance for the country of the
     * given locale. The language and variant components of the locale
     * are ignored. The result may vary over time, as countries change their
     * currencies. For example, for the original member countries of the
     * European Monetary Union, the method returns the old national currencies
     * until December 31, 2001, and the Euro from January 1, 2002, local time
     * of the respective countries.
     * <p>
     * The method returns <code>null</code> for territories that don't
     * have a currency, such as Antarctica.
     *
     * @param locale the locale for whose country a <code>Currency</code>
     * instance is needed
     * @return the <code>Currency</code> instance for the country of the given
     * locale, or null
     * @exception NullPointerException if <code>locale</code> or its country
     * code is null
     * @exception IllegalArgumentException if the country of the given locale
     * is not a supported ISO 3166 country code.
     */
    public static Currency getInstance(Locale locale) {
        String country = locale.getCountry();
        if (country == null) {
            throw new NullPointerException();
        }

        if (country.length() != 2) {
            throw new IllegalArgumentException();
        }
        
        char char1 = country.charAt(0);
        char char2 = country.charAt(1);
        int tableEntry = getMainTableEntry(char1, char2);
        if ((tableEntry & COUNTRY_TYPE_MASK) == SIMPLE_CASE_COUNTRY_MASK
                    && tableEntry != INVALID_COUNTRY_ENTRY) {
            char finalChar = (char) ((tableEntry & SIMPLE_CASE_COUNTRY_FINAL_CHAR_MASK) + 'A');
            int defaultFractionDigits = (tableEntry & SIMPLE_CASE_COUNTRY_DEFAULT_DIGITS_MASK) >> SIMPLE_CASE_COUNTRY_DEFAULT_DIGITS_SHIFT;
            StringBuffer sb = new StringBuffer(country);
            sb.append(finalChar);
            return getInstance(sb.toString(), defaultFractionDigits);
        } else {
            // special cases
            if (tableEntry == INVALID_COUNTRY_ENTRY) {
                throw new IllegalArgumentException();
            }
            if (tableEntry == COUNTRY_WITHOUT_CURRENCY_ENTRY) {
                return null;
            } else {
                int index = (tableEntry & SPECIAL_CASE_COUNTRY_INDEX_MASK) - SPECIAL_CASE_COUNTRY_INDEX_DELTA;
                if (scCutOverTimes[index] == Long.MAX_VALUE || System.currentTimeMillis() < scCutOverTimes[index]) {
                    return getInstance(scOldCurrencies[index], scOldCurrenciesDFD[index]);
                } else {
                    return getInstance(scNewCurrencies[index], scNewCurrenciesDFD[index]);
                }
            }
        }
    }
    
    /**
     * Gets the ISO 4217 currency code of this currency.
     *
     * @return the ISO 4217 currency code of this currency.
     */
    public String getCurrencyCode() {
        return currencyCode;
    }
    
    /**
     * Gets the symbol of this currency for the default locale.
     * For example, for the US Dollar, the symbol is "$" if the default
     * locale is the US, while for other locales it may be "US$". If no
     * symbol can be determined, the ISO 4217 currency code is returned.
     *
     * @return the symbol of this currency for the default locale
     */
    public String getSymbol() {
        return getSymbol(Locale.getDefault());
    }
    
    /**
     * Gets the symbol of this currency for the specified locale.
     * For example, for the US Dollar, the symbol is "$" if the specified
     * locale is the US, while for other locales it may be "US$". If no
     * symbol can be determined, the ISO 4217 currency code is returned.
     *
     * @param locale the locale for which a display name for this currency is
     * needed
     * @return the symbol of this currency for the specified locale
     * @exception NullPointerException if <code>locale</code> is null
     */
    public String getSymbol(Locale locale) {
        try {
            // Check whether a provider can provide an implementation that's closer 
            // to the requested locale than what the Java runtime itself can provide.
            LocaleServiceProviderPool pool =
                LocaleServiceProviderPool.getPool(CurrencyNameProvider.class);

            if (pool.hasProviders()) {
                // Assuming that all the country locales include necessary currency 
                // symbols in the Java runtime's resources,  so there is no need to
                // examine whether Java runtime's currency resource bundle is missing 
                // names.  Therefore, no resource bundle is provided for calling this 
                // method.
                String symbol = pool.getLocalizedObject(
                                    CurrencyNameGetter.INSTANCE,
                                    locale, null, currencyCode);
                if (symbol != null) {
                    return symbol;
                }
            }

            ResourceBundle bundle = LocaleData.getCurrencyNames(locale);
            return bundle.getString(currencyCode);
        } catch (MissingResourceException e) {
            // use currency code as symbol of last resort
            return currencyCode;
        }
    }
    
    /**
     * Gets the default number of fraction digits used with this currency.
     * For example, the default number of fraction digits for the Euro is 2,
     * while for the Japanese Yen it's 0.
     * In the case of pseudo-currencies, such as IMF Special Drawing Rights,
     * -1 is returned.
     *
     * @return the default number of fraction digits used with this currency
     */
    public int getDefaultFractionDigits() {
        return defaultFractionDigits;
    }
    
    /**
     * Returns the ISO 4217 currency code of this currency.
     *
     * @return the ISO 4217 currency code of this currency
     */
    public String toString() {
        return currencyCode;
    }

    /**
     * Resolves instances being deserialized to a single instance per currency.
     */
    private Object readResolve() {
        return getInstance(currencyCode);
    }
    
    /**
     * Gets the main table entry for the country whose country code consists
     * of char1 and char2.
     */
    private static int getMainTableEntry(char char1, char char2) {
        if (char1 < 'A' || char1 > 'Z' || char2 < 'A' || char2 > 'Z') {
            throw new IllegalArgumentException();
        }
        return mainTable.charAt((char1 - 'A') * A_TO_Z + (char2 - 'A'));
    }

    /**
     * Obtains a localized currency names from a CurrencyNameProvider
     * implementation.
     */
    private static class CurrencyNameGetter 
        implements LocaleServiceProviderPool.LocalizedObjectGetter<CurrencyNameProvider,
                                                                   String> {
        private static final CurrencyNameGetter INSTANCE = new CurrencyNameGetter();

        public String getObject(CurrencyNameProvider currencyNameProvider,
                                Locale locale, 
                                String key,
                                Object... params) {
            assert params.length == 0;
	    return currencyNameProvider.getSymbol(key, locale);
        }
    }
}
