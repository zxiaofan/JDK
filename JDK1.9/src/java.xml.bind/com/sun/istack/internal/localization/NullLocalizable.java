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
 * {@link Localizable} that wraps a non-localizable string.
 *
 * @author WS Development Team
 */
public final class NullLocalizable implements Localizable {
    private final String msg;

    public NullLocalizable(String msg) {
        if(msg==null)
            throw new IllegalArgumentException();
        this.msg = msg;
    }

    @Override
    public String getKey() {
        return Localizable.NOT_LOCALIZABLE;
    }
    @Override
    public Object[] getArguments() {
        return new Object[]{msg};
    }
    @Override
    public String getResourceBundleName() {
        return "";
    }
    @Override
    public ResourceBundle getResourceBundle(Locale locale) {
        return null;
    }
}
