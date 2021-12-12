/*
 * Copyright (c) 2016, 2020, Oracle and/or its affiliates. All rights reserved.
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

package jdk.javadoc.internal.doclets.toolkit;

import java.text.MessageFormat;
import java.util.Locale;
import java.util.MissingResourceException;
import java.util.ResourceBundle;
import java.util.function.Function;

/**
 * Access to the localizable resources used by a doclet.
 * The resources are split across two resource bundles:
 * one that contains format-neutral strings common to
 * all supported formats, and one that contains strings
 * specific to the selected doclet, such as the standard
 * HTML doclet.
 */
public class Resources {

    protected final ResourceBundle commonBundle;
    protected final ResourceBundle docletBundle;
    protected Function<String, String> mapper;

    /**
     * Creates a {@code Resources} object to provide access the resource
     * bundles used by a doclet.
     *
     * @param locale           the locale to be used when accessing the
     *                         resource bundles.
     * @param commonBundleName the name of the bundle containing the strings
     *                         common to all output formats
     * @param docletBundleName the name of the bundle containing the strings
     *                         specific to a particular format
     */
    public Resources(Locale locale, String commonBundleName, String docletBundleName) {
        this.commonBundle = ResourceBundle.getBundle(commonBundleName, locale);
        this.docletBundle = ResourceBundle.getBundle(docletBundleName, locale);
    }

    public void setKeyMapper(Function<String, String> mapper) {
        this.mapper = mapper;
    }

    /**
     * Returns the string for the given key from one of the doclet's
     * resource bundles. If the current {@code mapper} is not {@code null},
     * it will be applied to the {@code key} before looking up the resulting
     * key in the resource bundle(s).
     *
     * The more specific bundle is checked first;
     * if it is not there, the common bundle is then checked.
     *
     * @param key the key for the desired string
     * @return the string for the given key
     * @throws MissingResourceException if the key is not found in either
     *                                  bundle.
     */
    public String getText(String key) throws MissingResourceException {
        String mKey = mapper == null ? key : mapper.apply(key);

        if (docletBundle.containsKey(mKey))
            return docletBundle.getString(mKey);

        return commonBundle.getString(mKey);
    }

    /**
     * Returns the string for the given key (after applying the current
     * {@code mapper} if it is not {@code null}) from one of the doclet's
     * resource bundles, substituting additional arguments into
     * into the resulting string with {@link MessageFormat#format}.
     *
     * The more specific bundle is checked first;
     * if it is not there, the common bundle is then checked.
     *
     * @param key the key for the desired string
     * @param args values to be substituted into the resulting string
     * @return the string for the given key
     * @throws MissingResourceException if the key is not found in either
     *  bundle.
     */
    public String getText(String key, Object... args) throws MissingResourceException {
        return MessageFormat.format(getText(key), args);
    }
}
