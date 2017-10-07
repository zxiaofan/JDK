/*
 * Copyright (c) 2014, Oracle and/or its affiliates. All rights reserved.
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
}
