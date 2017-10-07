/*
 * Copyright (c) 2011, 2016, Oracle and/or its affiliates. All rights reserved.
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

package com.sun.webkit;

import java.util.Locale;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;

final class LocalizedStrings {
    private final static Logger log =
        Logger.getLogger(LocalizedStrings.class.getName());

    private final static ResourceBundle BUNDLE =
        ResourceBundle.getBundle("com.sun.webkit.LocalizedStrings",
            Locale.getDefault());

    /** Private ctor to avoid unexpected instantiation */
    private LocalizedStrings() {}

    private static String getLocalizedProperty(String propName) {
        log.log(Level.FINE, "Get property: " + propName);
        String propValue = BUNDLE.getString(propName);
        if ((propValue != null) && (propValue.trim().length() > 0)) {
            log.log(Level.FINE, "Property value: " + propValue);
            return propValue.trim();
        }
        log.log(Level.FINE, "Unknown property value");
        return null;
    }
}
