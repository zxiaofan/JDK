/*
 * Copyright (c) 1997, 2017, Oracle and/or its affiliates. All rights reserved.
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

package com.sun.istack.internal.localization;

import java.util.Locale;
import java.util.ResourceBundle;

/**
 * @author WS Development Team
 */
public class LocalizableMessageFactory {

    private final String _bundlename;
    private final ResourceBundleSupplier _rbSupplier;

    @Deprecated
    public LocalizableMessageFactory(String bundlename) {
        _bundlename = bundlename;
        _rbSupplier = null;
    }

    public LocalizableMessageFactory(String bundlename, ResourceBundleSupplier rbSupplier) {
        _bundlename = bundlename;
        _rbSupplier = rbSupplier;
    }

    public Localizable getMessage(String key, Object... args) {
        return new LocalizableMessage(_bundlename, _rbSupplier, key, args);
    }

    public interface ResourceBundleSupplier {
        /**
         * Gets the ResourceBundle.
         * @param locale the requested bundle's locale
         * @return ResourceBundle
         */
        ResourceBundle getResourceBundle(Locale locale);
    }

}
