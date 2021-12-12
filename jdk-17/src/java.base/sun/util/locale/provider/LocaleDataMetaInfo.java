/*
 * Copyright (c) 2014, 2018, Oracle and/or its affiliates. All rights reserved.
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
     * Returns a map for time zone ids to their canonical ids.
     * The map key is either an LDML's short id, or a valid
     * TZDB zone id.
     * @return map of ids to their canonical ids.
     */
    default public Map<String, String>  tzCanonicalIDs() {
        return null;
    }

    /**
     * Returns a map for  language aliases which specifies mapping from source language
     * to from which it should be replaced.
     * @return map of source language to replacement language, separated by a space.
     */
   default public Map<String, String> getLanguageAliasMap(){
       return null;
   }
}
