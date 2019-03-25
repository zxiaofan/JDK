/*
 * Copyright (c) 1998, 2003, Oracle and/or its affiliates. All rights reserved.
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


package sun.awt;

import java.awt.Image;
import java.awt.Toolkit;
import java.awt.im.spi.InputMethod;
import java.awt.im.spi.InputMethodDescriptor;
import java.security.AccessController;
import java.util.Locale;
import sun.awt.SunToolkit;
import sun.security.action.GetPropertyAction;

/**
 * Provides sufficient information about an input method
 * to enable selection and loading of that input method.
 * The input method itself is only loaded when it is actually used.
 *
 * @since 1.3
 */

public abstract class X11InputMethodDescriptor implements InputMethodDescriptor {

    private static Locale locale;

    public X11InputMethodDescriptor() {
        locale = getSupportedLocale();
    }

    /**
     * @see java.awt.im.spi.InputMethodDescriptor#getAvailableLocales
     */
    public Locale[] getAvailableLocales() {
        Locale[] locales = {locale};
        return locales;
    }

    /**
     * @see java.awt.im.spi.InputMethodDescriptor#hasDynamicLocaleList
     */
    public boolean hasDynamicLocaleList() {
        return false;
    }

    /**
     * @see java.awt.im.spi.InputMethodDescriptor#getInputMethodDisplayName
     */
    public synchronized String getInputMethodDisplayName(Locale inputLocale, Locale displayLanguage) {
        // We ignore the input locale.
        // When displaying for the default locale, rely on the localized AWT properties;
        // for any other locale, fall back to English.
        String name = "System Input Methods";
        if (Locale.getDefault().equals(displayLanguage)) {
            name = Toolkit.getProperty("AWT.HostInputMethodDisplayName", name);
        }
        return name;
    }

    /**
     * @see java.awt.im.spi.InputMethodDescriptor#getInputMethodIcon
     */
    public Image getInputMethodIcon(Locale inputLocale) {
        return null;
    }

    /**
     * @see java.awt.im.spi.InputMethodDescriptor#createInputMethod
     */
    public abstract InputMethod createInputMethod() throws Exception;

    /**
     * returns supported locale. Currently this method returns the locale in which
     * the VM is started since Solaris doesn't provide a way to determine the login locale.
     */
    static Locale getSupportedLocale() {
        return SunToolkit.getStartupLocale();
    }
}
