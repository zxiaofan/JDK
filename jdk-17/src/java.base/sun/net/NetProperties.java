/*
 * Copyright (c) 2004, 2021, Oracle and/or its affiliates. All rights reserved.
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
package sun.net;

import jdk.internal.util.StaticProperty;

import java.io.*;
import java.security.AccessController;
import java.security.PrivilegedAction;
import java.util.Properties;

/*
 * This class allows for centralized access to Networking properties.
 * Default values are loaded from the file jre/lib/net.properties
 *
 *
 * @author Jean-Christophe Collet
 *
 */

@SuppressWarnings("removal")
public class NetProperties {
    private static Properties props = new Properties();
    static {
        AccessController.doPrivileged(
            new PrivilegedAction<Void>() {
                public Void run() {
                    loadDefaultProperties();
                    return null;
                }});
    }

    private NetProperties() { };


    /*
     * Loads the default networking system properties
     * the file is in jre/lib/net.properties
     */
    private static void loadDefaultProperties() {
        String fname = StaticProperty.javaHome();
        if (fname == null) {
            throw new Error("Can't find java.home ??");
        }
        try {
            File f = new File(fname, "conf");
            f = new File(f, "net.properties");
            fname = f.getCanonicalPath();
            InputStream in = new FileInputStream(fname);
            BufferedInputStream bin = new BufferedInputStream(in);
            props.load(bin);
            bin.close();
        } catch (Exception e) {
            // Do nothing. We couldn't find or access the file
            // so we won't have default properties...
        }
    }

    /**
     * Get a networking system property. If no system property was defined
     * returns the default value, if it exists, otherwise returns
     * <code>null</code>.
     * @param      key  the property name.
     * @throws  SecurityException  if a security manager exists and its
     *          <code>checkPropertiesAccess</code> method doesn't allow access
     *          to the system properties.
     * @return the <code>String</code> value for the property,
     *         or <code>null</code>
     */
    public static String get(String key) {
        String def = props.getProperty(key);
        try {
            return System.getProperty(key, def);
        } catch (IllegalArgumentException e) {
        } catch (NullPointerException e) {
        }
        return null;
    }

    /**
     * Get an Integer networking system property. If no system property was
     * defined returns the default value, if it exists, otherwise returns
     * <code>null</code>.
     * @param   key     the property name.
     * @param   defval  the default value to use if the property is not found
     * @throws  SecurityException  if a security manager exists and its
     *          <code>checkPropertiesAccess</code> method doesn't allow access
     *          to the system properties.
     * @return the <code>Integer</code> value for the property,
     *         or <code>null</code>
     */
    public static Integer getInteger(String key, int defval) {
        String val = null;

        try {
            val = System.getProperty(key, props.getProperty(key));
        } catch (IllegalArgumentException e) {
        } catch (NullPointerException e) {
        }

        if (val != null) {
            try {
                return Integer.decode(val);
            } catch (NumberFormatException ex) {
            }
        }
        return defval;
    }

    /**
     * Get a Boolean networking system property. If no system property was
     * defined returns the default value, if it exists, otherwise returns
     * <code>null</code>.
     * @param   key     the property name.
     * @throws  SecurityException  if a security manager exists and its
     *          <code>checkPropertiesAccess</code> method doesn't allow access
     *          to the system properties.
     * @return the <code>Boolean</code> value for the property,
     *         or <code>null</code>
     */
    public static Boolean getBoolean(String key) {
        String val = null;

        try {
            val = System.getProperty(key, props.getProperty(key));
        } catch (IllegalArgumentException e) {
        } catch (NullPointerException e) {
        }

        if (val != null) {
            try {
                return Boolean.valueOf(val);
            } catch (NumberFormatException ex) {
            }
        }
        return null;
    }

}
