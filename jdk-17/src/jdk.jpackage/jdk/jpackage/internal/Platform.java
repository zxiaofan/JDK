/*
 * Copyright (c) 2016, 2021, Oracle and/or its affiliates. All rights reserved.
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

package jdk.jpackage.internal;

import java.util.regex.Pattern;

/**
 * Platform
 *
 * Use <code>Platform</code> to detect the operating system
 * that is currently running.
 *
 * Example:
 *
 *  Platform platform = Platform.getPlatform();
 *
 *  switch(platform) {
 *    case Platform.MAC: {
 *      // Do something
 *      break;
 *    }
 *    case Platform.WINDOWS:
 *    case Platform.LINUX: {
 *      // Do something else
 *    }
 *  }
 *
 */
enum Platform {UNKNOWN, WINDOWS, LINUX, MAC;
    private static final Platform platform;
    private static final int majorVersion;
    private static final int minorVersion;

    static {
        String os = System.getProperty("os.name").toLowerCase();

        if (os.indexOf("win") >= 0) {
            platform = Platform.WINDOWS;
        }
        else if (os.indexOf("nix") >= 0 || os.indexOf("nux") >= 0) {
            platform = Platform.LINUX;
        }
        else if (os.indexOf("mac") >= 0) {
            platform = Platform.MAC;
        }
        else {
            platform = Platform.UNKNOWN;
        }

        String version = System.getProperty("os.version").toString();
        String[] parts = version.split(Pattern.quote("."));

        if (parts.length > 0) {
            majorVersion = Integer.parseInt(parts[0]);

            if (parts.length > 1) {
                minorVersion = Integer.parseInt(parts[1]);
            }
            else {
                minorVersion = -1;
            }
        }
        else {
            majorVersion = -1;
            minorVersion = -1;
        }
    }

    private Platform() {}

    static Platform getPlatform() {
        return platform;
    }

    static int getMajorVersion() {
        return majorVersion;
    }

    static int getMinorVersion() {
        return minorVersion;
    }

    static boolean isWindows() {
        return getPlatform() == WINDOWS;
    }

    static boolean isMac() {
        return getPlatform() == MAC;
    }

    static boolean isArmMac() {
        return (isMac() && "aarch64".equals(System.getProperty("os.arch")));
    }

    static boolean isLinux() {
        return getPlatform() == LINUX;
    }

    static RuntimeException throwUnknownPlatformError() {
        throw new IllegalArgumentException("Unknown platform");
    }
}
