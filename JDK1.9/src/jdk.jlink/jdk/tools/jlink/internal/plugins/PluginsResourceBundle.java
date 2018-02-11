/*
 * Copyright (c) 2015, Oracle and/or its affiliates. All rights reserved.
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
package jdk.tools.jlink.internal.plugins;

import java.text.MessageFormat;
import java.util.Locale;
import java.util.MissingResourceException;
import java.util.ResourceBundle;

public final class PluginsResourceBundle {

    static final String DESCRIPTION = "description";
    static final String ARGUMENT = "argument";
    private static final ResourceBundle pluginsBundle;

    static {
        Locale locale = Locale.getDefault();
        try {
            pluginsBundle = ResourceBundle.getBundle("jdk.tools.jlink."
                    + "resources.plugins", locale);
        } catch (MissingResourceException e) {
            throw new InternalError("Cannot find jlink resource bundle for "
                    + "locale " + locale);
        }
    }

    private PluginsResourceBundle() {
    }

    public static String getArgument(String name, Object... args) {
        return getMessage(name + "." + ARGUMENT, args);
    }

    public static String getDescription(String name) {
        return getMessage(name + "." + DESCRIPTION, name);
    }

    public static String getOption(String name, String option) {
        return getMessage(name + "." + option);
    }

    public static String getMessage(String key, Object... args) throws MissingResourceException {
        String val = pluginsBundle.getString(key);
        return MessageFormat.format(val, args);
    }
}
