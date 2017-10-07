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

package com.sun.tools.internal.ws.resources;

import java.util.Locale;
import java.util.ResourceBundle;
import com.sun.istack.internal.localization.Localizable;
import com.sun.istack.internal.localization.LocalizableMessageFactory;
import com.sun.istack.internal.localization.LocalizableMessageFactory.ResourceBundleSupplier;
import com.sun.istack.internal.localization.Localizer;


/**
 * Defines string formatting method for each constant in the resource file
 *
 */
public final class JavacompilerMessages {

    private final static String BUNDLE_NAME = "com.sun.tools.internal.ws.resources.javacompiler";
    private final static LocalizableMessageFactory MESSAGE_FACTORY = new LocalizableMessageFactory(BUNDLE_NAME, new JavacompilerMessages.BundleSupplier());
    private final static Localizer LOCALIZER = new Localizer();

    public static Localizable localizableNO_JAVACOMPILER_ERROR() {
        return MESSAGE_FACTORY.getMessage("no.javacompiler.error");
    }

    /**
     * No system compiler found, check your jdk.
     *
     */
    public static String NO_JAVACOMPILER_ERROR() {
        return LOCALIZER.localize(localizableNO_JAVACOMPILER_ERROR());
    }

    private static class BundleSupplier
        implements ResourceBundleSupplier
    {


        public ResourceBundle getResourceBundle(Locale locale) {
            return ResourceBundle.getBundle(BUNDLE_NAME, locale);
        }

    }

}
