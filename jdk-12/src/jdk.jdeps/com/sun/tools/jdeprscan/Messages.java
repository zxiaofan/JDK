/*
 * Copyright (c) 2016, Oracle and/or its affiliates. All rights reserved.
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

package com.sun.tools.jdeprscan;

import java.text.MessageFormat;
import java.util.Locale;
import java.util.MissingResourceException;
import java.util.ResourceBundle;

/**
 * Message handling class for localization.
 */
public class Messages {
    /** Indicates whether line separators in messages need replacement. */
    static final boolean REPLACE_LINESEP = ! System.lineSeparator().equals("\n");

    /** The resource bundle, must be non-null. */
    static final ResourceBundle bundle;

    static {
        Locale locale = Locale.getDefault();
        try {
            bundle = ResourceBundle.getBundle("com.sun.tools.jdeprscan.resources.jdeprscan", locale);
        } catch (MissingResourceException e) {
            throw new InternalError("Cannot find jdeprscan resource bundle for locale " + locale, e);
        }
    }

    /**
     * Gets a message from the resource bundle. If necessary, translates "\n",
     * the line break string used in the message file, to the system-specific
     * line break string.
     *
     * @param key the message key
     * @param args the message arguments
     */
    public static String get(String key, Object... args) {
        try {
            String msg = MessageFormat.format(bundle.getString(key), args);
            if (REPLACE_LINESEP) {
                msg = msg.replace("\n", System.lineSeparator());
            }
            return msg;
        } catch (MissingResourceException e) {
            throw new InternalError("Missing message: " + key, e);
        }
    }
}
