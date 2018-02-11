/*
 * Copyright (c) 2017, Oracle and/or its affiliates. All rights reserved.
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
public final class ContextClassloaderLocalMessages {

    private final static String BUNDLE_NAME = "com.sun.tools.internal.ws.resources.ContextClassloaderLocal";
    private final static LocalizableMessageFactory MESSAGE_FACTORY = new LocalizableMessageFactory(BUNDLE_NAME, new ContextClassloaderLocalMessages.BundleSupplier());
    private final static Localizer LOCALIZER = new Localizer();

    public static Localizable localizableFAILED_TO_CREATE_NEW_INSTANCE(Object arg0) {
        return MESSAGE_FACTORY.getMessage("FAILED_TO_CREATE_NEW_INSTANCE", arg0);
    }

    /**
     * Failed to create new instance of {0}
     *
     */
    public static String FAILED_TO_CREATE_NEW_INSTANCE(Object arg0) {
        return LOCALIZER.localize(localizableFAILED_TO_CREATE_NEW_INSTANCE(arg0));
    }

    private static class BundleSupplier
        implements ResourceBundleSupplier
    {


        public ResourceBundle getResourceBundle(Locale locale) {
            return ResourceBundle.getBundle(BUNDLE_NAME, locale);
        }

    }

}
