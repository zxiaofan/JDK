/*
 * Copyright (c) 2004, 2013, Oracle and/or its affiliates. All rights reserved.
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
 *
 * THIS FILE WAS MODIFIED BY SUN MICROSYSTEMS, INC.
 */

package com.sun.xml.internal.fastinfoset;

import java.util.Locale;
import java.util.ResourceBundle;

/** Resource bundle implementation for localized messages.
 */
public class CommonResourceBundle extends AbstractResourceBundle {

    public static final String BASE_NAME = "com.sun.xml.internal.fastinfoset.resources.ResourceBundle";
    private static volatile CommonResourceBundle instance = null;
    private static Locale locale = null;
    private ResourceBundle bundle = null;

    protected CommonResourceBundle() {
        // Load the resource bundle of default locale
        bundle = ResourceBundle.getBundle(BASE_NAME);
    }

    protected CommonResourceBundle(Locale locale) {
        // Load the resource bundle of specified locale
        bundle = ResourceBundle.getBundle(BASE_NAME, locale);
    }

    public static CommonResourceBundle getInstance() {
        if (instance == null) {
            synchronized (CommonResourceBundle.class) {
                instance = new CommonResourceBundle();
                //**need to know where to get the locale
                //String localeString = CommonProperties.getInstance()
                //                  .getProperty("omar.common.locale");
                locale = parseLocale(/*localeString*/null);
            }
        }

        return instance;
    }

    public static CommonResourceBundle getInstance(Locale locale) {
        if (instance == null) {
            synchronized (CommonResourceBundle.class) {
                instance = new CommonResourceBundle(locale);
            }
        } else {
            synchronized (CommonResourceBundle.class) {
                if (CommonResourceBundle.locale != locale) {
                    instance = new CommonResourceBundle(locale);
                }
            }
        }
        return instance;
    }


    public ResourceBundle getBundle() {
        return bundle;
    }
    public ResourceBundle getBundle(Locale locale) {
        return ResourceBundle.getBundle(BASE_NAME, locale);
    }

}
