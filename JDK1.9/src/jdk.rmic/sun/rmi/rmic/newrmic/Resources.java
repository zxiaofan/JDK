/*
 * Copyright (c) 2003, 2012, Oracle and/or its affiliates. All rights reserved.
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

package sun.rmi.rmic.newrmic;

import java.text.MessageFormat;
import java.util.MissingResourceException;
import java.util.ResourceBundle;

/**
 * Provides resource support for rmic.
 *
 * WARNING: The contents of this source file are not part of any
 * supported API.  Code that depends on them does so at its own risk:
 * they are subject to change or removal without notice.
 *
 * @author Peter Jones
 **/
public final class Resources {

    private static ResourceBundle resources = null;
    private static ResourceBundle resourcesExt = null;
    static {
        try {
            resources =
                ResourceBundle.getBundle("sun.rmi.rmic.resources.rmic");
        } catch (MissingResourceException e) {
            // gracefully handle this later
        }
        try {
            resourcesExt =
                ResourceBundle.getBundle("sun.rmi.rmic.resources.rmicext");
        } catch (MissingResourceException e) {
            // OK if this isn't found
        }
    }

    private Resources() { throw new AssertionError(); }

    /**
     * Returns the text of the rmic resource for the specified key
     * formatted with the specified arguments.
     **/
    public static String getText(String key, String... args) {
        String format = getString(key);
        if (format == null) {
            format = "missing resource key: key = \"" + key + "\", " +
                "arguments = \"{0}\", \"{1}\", \"{2}\"";
        }
        return MessageFormat.format(format, (Object[]) args);
    }

    /**
     * Returns the rmic resource string for the specified key.
     **/
    private static String getString(String key) {
        if (resourcesExt != null) {
            try {
                return resourcesExt.getString(key);
            } catch (MissingResourceException e) {
            }
        }
        if (resources != null) {
            try {
                return resources.getString(key);
            } catch (MissingResourceException e) {
                return null;
            }
        }
        return "missing resource bundle: key = \"" + key + "\", " +
            "arguments = \"{0}\", \"{1}\", \"{2}\"";
    }
}
