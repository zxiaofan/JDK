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

package com.sun.media.jfxmediaimpl;

import java.security.AccessController;
import java.security.PrivilegedAction;

/**
 * Common functions that involve the host platform
 */
public class HostUtils {
    private static String osName;
    private static String osArch;
    private static boolean embedded;
    private static boolean is64bit = false;

    static {
        embedded = AccessController.doPrivileged((PrivilegedAction<Boolean>) () -> {
            osName = System.getProperty("os.name").toLowerCase();
            osArch = System.getProperty("os.arch").toLowerCase();

            is64bit =  osArch.equals("x64")
                    || osArch.equals("x86_64")
                    || osArch.equals("ia64");

            return Boolean.getBoolean("com.sun.javafx.isEmbedded");
        });
    }

    public static boolean is64Bit() {
        return is64bit;
    }

    public static boolean isWindows() {
        return osName.startsWith("windows");
    }

    public static boolean isMacOSX() {
        return osName.startsWith("mac os x");
    }

    public static boolean isLinux() {
        return osName.startsWith("linux");
    }

    public static boolean isIOS() {
        return osName.startsWith("ios");
    }

    /**
     * Returns true if the platform is embedded.
     */
    public static boolean isEmbedded() {
        return embedded;
    }
}
