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

import java.util.List;
import java.util.Locale;
import sun.util.resources.LocaleData;

/**
 * Accessor for LocaleData
 *
 * @author Naoto Sato
 */
public interface ResourceBundleBasedAdapter {
    public LocaleData getLocaleData();

    /**
     * candidate locales customization
     */
    public List<Locale> getCandidateLocales(String baseName, Locale locale);
}
