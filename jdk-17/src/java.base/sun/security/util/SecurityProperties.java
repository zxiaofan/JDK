/*
 * Copyright (c) 2018, 2021, Oracle and/or its affiliates. All rights reserved.
 * Copyright (c) 2018 SAP SE. All rights reserved.
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

package sun.security.util;

import java.security.AccessController;
import java.security.PrivilegedAction;
import java.security.Security;

public class SecurityProperties {

    public static final boolean INCLUDE_JAR_NAME_IN_EXCEPTIONS
        = includedInExceptions("jar");

    /**
     * Returns the value of the security property propName, which can be overridden
     * by a system property of the same name
     *
     * @param  propName the name of the system or security property
     * @return the value of the system or security property
     */
    @SuppressWarnings("removal")
    public static String privilegedGetOverridable(String propName) {
        if (System.getSecurityManager() == null) {
            return getOverridableProperty(propName);
        } else {
            return AccessController.doPrivileged((PrivilegedAction<String>) () -> getOverridableProperty(propName));
        }
    }

    private static String getOverridableProperty(String propName) {
        String val = System.getProperty(propName);
        if (val == null) {
            return Security.getProperty(propName);
        } else {
            return val;
        }
    }

    /**
     * Returns true in case the system or security property "jdk.includeInExceptions"
     * contains the category refName
     *
     * @param refName the category to check
     * @return true in case the system or security property "jdk.includeInExceptions"
     *         contains refName, false otherwise
     */
    public static boolean includedInExceptions(String refName) {
        String val = privilegedGetOverridable("jdk.includeInExceptions");
        if (val == null) {
            return false;
        }

        String[] tokens = val.split(",");
        for (String token : tokens) {
            token = token.trim();
            if (token.equalsIgnoreCase(refName)) {
                return true;
            }
        }
        return false;
    }
}
