/*
 * Copyright (c) 2014, 2017, Oracle and/or its affiliates. All rights reserved.
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

import java.util.Map;

/**
 * LocaleData meta info SPI
 *
 * @author Naoto Sato
 */
public interface LocaleDataMetaInfo {

    /**
     * Returns the type of LocaleProviderAdapter for which this LocaleData
     * provides the data.
     * @return type The type of the adapter.
     */
    public LocaleProviderAdapter.Type getType();

    /**
     * Returns the string concatenation of the supported language tags in
     * this LocaleData instance
     * @param category category of the locale data.
     * @return concatenated language tags, separated by a space.
     */
    public String availableLanguageTags(String category);

    /**
     * Returns a map for short time zone ids in BCP47 Unicode extension and
     * the long time zone ids.
     * @return map of short id to long ids, separated by a space.
     */
    default public Map<String, String>  tzShortIDs() {
        return null;
    }
}
