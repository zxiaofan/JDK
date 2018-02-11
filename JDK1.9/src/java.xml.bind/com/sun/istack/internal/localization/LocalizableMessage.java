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

import com.sun.istack.internal.localization.LocalizableMessageFactory.ResourceBundleSupplier;

import java.util.Arrays;
import java.util.Locale;
import java.util.ResourceBundle;


/**
 * @author WS Development Team
 */
public final class LocalizableMessage implements Localizable {

    private final String _bundlename;
    private final ResourceBundleSupplier _rbSupplier;

    private final String _key;
    private final Object[] _args;

    @Deprecated
    public LocalizableMessage(String bundlename, String key, Object... args) {
        this(bundlename, null, key, args);
    }

    public LocalizableMessage(String bundlename, ResourceBundleSupplier rbSupplier,
                              String key, Object... args) {
        _bundlename = bundlename;
        _rbSupplier = rbSupplier;
        _key = key;
        if(args==null)
            args = new Object[0];
        _args = args;
    }

    @Override
    public String getKey() {
        return _key;
    }

    @Override
    public Object[] getArguments() {
        return Arrays.copyOf(_args, _args.length);
    }

    @Override
    public String getResourceBundleName() {
        return _bundlename;
    }

    @Override
    public ResourceBundle getResourceBundle(Locale locale) {
        if (_rbSupplier == null)
            return null;

        return _rbSupplier.getResourceBundle(locale);
    }
}
