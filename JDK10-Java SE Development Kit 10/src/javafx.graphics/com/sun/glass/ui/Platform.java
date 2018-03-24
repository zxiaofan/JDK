/*
 * Copyright (c) 2010, 2014, Oracle and/or its affiliates. All rights reserved.
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
package com.sun.glass.ui;

import java.security.AccessController;
import java.security.PrivilegedAction;
import java.util.Locale;

final class Platform {

    public static final String MAC = "Mac";
    public static final String WINDOWS = "Win";
    public static final String GTK = "Gtk";
    public static final String IOS = "Ios";
    public static final String UNKNOWN = "unknown";

    static private String type = null;

    static public synchronized String determinePlatform() {
        if (type == null) {

            // Provide for a runtime override, allowing EGL for example
            String userPlatform =
                AccessController.doPrivileged((PrivilegedAction<String>) () -> System.getProperty("glass.platform"));

            if (userPlatform != null) {
                if (userPlatform.equals("macosx"))
                   type = MAC;
                else if (userPlatform.equals("windows"))
                   type = WINDOWS;
                else if (userPlatform.equals("linux"))
                   type = GTK;
                else if (userPlatform.equals("gtk"))
                   type = GTK;
                else if (userPlatform.equals("ios"))
                   type = IOS;
                else
                   type = userPlatform;
                return type;
            }

            String osName = System.getProperty("os.name");
            String osNameLowerCase = osName.toLowerCase(Locale.ROOT);
            if (osNameLowerCase.startsWith("mac") || osNameLowerCase.startsWith("darwin")) {
                type = MAC;
            } else if (osNameLowerCase.startsWith("wind")) {
                type = WINDOWS;
            } else if (osNameLowerCase.startsWith("linux")) {
                type = GTK;
            }
        }

        return type;
    }
}
