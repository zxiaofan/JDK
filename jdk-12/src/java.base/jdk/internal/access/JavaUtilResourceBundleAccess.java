/*
 * Copyright (c) 2015, 2018, Oracle and/or its affiliates. All rights reserved.
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

package jdk.internal.access;

import java.util.Locale;
import java.util.ResourceBundle;

/**
 * Provides access to non-public methods in java.util.ResourceBundle.
 */
public interface JavaUtilResourceBundleAccess {
    /**
     * Sets the bundle's parent to the given parent.
     */
    void setParent(ResourceBundle bundle, ResourceBundle parent);

    /**
     * Returns the parent of the given bundle or null if the bundle has no parent.
     */
    ResourceBundle getParent(ResourceBundle bundle);

    /**
     * Sets the bundle's locale to the given locale.
     */
    void setLocale(ResourceBundle bundle, Locale locale);

    /**
     * Sets the bundle's base name to the given name.
     */
    void setName(ResourceBundle bundle, String name);

    /**
     * Returns a {@code ResourceBundle} of the given baseName and locale
     * loaded on behalf of the given module with no caller module
     * access check.
     */
    ResourceBundle getBundle(String baseName, Locale locale, Module module);

    /**
     * Instantiates a {@code ResourceBundle} of the given bundle class.
     */
    ResourceBundle newResourceBundle(Class<? extends ResourceBundle> bundleClass);
}
