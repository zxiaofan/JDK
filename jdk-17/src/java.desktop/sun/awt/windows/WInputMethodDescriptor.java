/*
 * Copyright (c) 1998, 2014, Oracle and/or its affiliates. All rights reserved.
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


package sun.awt.windows;

import java.awt.Image;
import java.awt.Toolkit;
import java.awt.im.spi.InputMethod;
import java.awt.im.spi.InputMethodDescriptor;
import java.util.Locale;

/**
 * Provides sufficient information about an input method
 * to enable selection and loading of that input method.
 * The input method itself is only loaded when it is actually used.
 *
 * @since 1.3
 */

final class WInputMethodDescriptor implements InputMethodDescriptor {

    /**
     * @see java.awt.im.spi.InputMethodDescriptor#getAvailableLocales
     */
    @Override
    public Locale[] getAvailableLocales() {
        // returns a copy of internal list for public API
        Locale[] locales = getAvailableLocalesInternal();
        Locale[] tmp = new Locale[locales.length];
        System.arraycopy(locales, 0, tmp, 0, locales.length);
        return tmp;
    }

    static Locale[] getAvailableLocalesInternal() {
        return getNativeAvailableLocales();
    }

    /**
     * @see java.awt.im.spi.InputMethodDescriptor#hasDynamicLocaleList
     */
    @Override
    public boolean hasDynamicLocaleList() {
        return true;
    }

    /**
     * @see java.awt.im.spi.InputMethodDescriptor#getInputMethodDisplayName
     */
    @Override
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
    @Override
    public Image getInputMethodIcon(Locale inputLocale) {
        return null;
    }

    /**
     * @see java.awt.im.spi.InputMethodDescriptor#createInputMethod
     */
    @Override
    public InputMethod createInputMethod() throws Exception {
        return new WInputMethod();
    }

    private static native Locale[] getNativeAvailableLocales();
}
