/*
 * Copyright (c) 2008, 2021, Oracle and/or its affiliates. All rights reserved.
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

package sun.font;

import java.awt.AWTError;
import java.awt.Font;
import java.awt.GraphicsEnvironment;
import java.awt.Toolkit;
import java.security.AccessController;
import java.security.PrivilegedAction;

import sun.security.action.GetPropertyAction;


/**
 * Factory class used to retrieve a valid FontManager instance for the current
 * platform.
 *
 * A default implementation is given for Linux, Solaris and Windows.
 * You can alter the behaviour of the {@link #getInstance()} method by setting
 * the {@code sun.font.fontmanager} property. For example:
 * {@code sun.font.fontmanager=sun.awt.X11FontManager}
 */
public final class FontManagerFactory {

    /** Our singleton instance. */
    private static FontManager instance = null;

    private static final String DEFAULT_CLASS;
    static {
        if (FontUtilities.isWindows) {
            DEFAULT_CLASS = "sun.awt.Win32FontManager";
        } else if (FontUtilities.isMacOSX) {
            DEFAULT_CLASS = "sun.font.CFontManager";
            } else {
            DEFAULT_CLASS = "sun.awt.X11FontManager";
            }
    }

    /**
     * Get a valid FontManager implementation for the current platform.
     *
     * @return a valid FontManager instance for the current platform
     */
    @SuppressWarnings("removal")
    public static synchronized FontManager getInstance() {

        if (instance != null) {
            return instance;
        }

        AccessController.doPrivileged(new PrivilegedAction<Object>() {

            public Object run() {
                try {
                    String fmClassName =
                            System.getProperty("sun.font.fontmanager",
                                               DEFAULT_CLASS);
                    ClassLoader cl = ClassLoader.getSystemClassLoader();
                    Class<?> fmClass = Class.forName(fmClassName, true, cl);
                    instance =
                       (FontManager) fmClass.getDeclaredConstructor().newInstance();
                } catch (ReflectiveOperationException ex) {
                    throw new InternalError(ex);

                }
                return null;
            }
        });

        return instance;
    }
}
