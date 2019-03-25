/*
 * Copyright (c) 2015, Oracle and/or its affiliates. All rights reserved.
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

package sun.util.resources.provider;

import java.util.Locale;
import java.util.ResourceBundle;
import sun.util.resources.LocaleData;

/**
 * Service Provider for loading JavaTimeSupplementary resource bundles in jdk.localedata.
 */
public class SupplementaryLocaleDataProvider extends LocaleData.SupplementaryResourceBundleProvider {
    @Override
    public ResourceBundle getBundle(String baseName, Locale locale) {
        return LocaleDataProvider.loadResourceBundle(toBundleName(baseName, locale));
    }
}
