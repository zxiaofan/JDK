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
public final class ConfigurationMessages {

    private final static String BUNDLE_NAME = "com.sun.tools.internal.ws.resources.configuration";
    private final static LocalizableMessageFactory MESSAGE_FACTORY = new LocalizableMessageFactory(BUNDLE_NAME, new ConfigurationMessages.BundleSupplier());
    private final static Localizer LOCALIZER = new Localizer();

    public static Localizable localizableCONFIGURATION_NOT_BINDING_FILE(Object arg0) {
        return MESSAGE_FACTORY.getMessage("configuration.notBindingFile", arg0);
    }

    /**
     * Ignoring: binding file "{0}". It is not a jaxws or a jaxb binding file.
     *
     */
    public static String CONFIGURATION_NOT_BINDING_FILE(Object arg0) {
        return LOCALIZER.localize(localizableCONFIGURATION_NOT_BINDING_FILE(arg0));
    }

    private static class BundleSupplier
        implements ResourceBundleSupplier
    {


        public ResourceBundle getResourceBundle(Locale locale) {
            return ResourceBundle.getBundle(BUNDLE_NAME, locale);
        }

    }

}
