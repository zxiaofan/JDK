/*
 * Copyright (c) 2016, 2017, Oracle and/or its affiliates. All rights reserved.
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

package com.oracle.tools.packager;

import java.util.regex.Pattern;

/**
 * Use <code>Platform</code> to detect the operating system that is currently running.
 *
 * Example:
 *
 *  Platform platform = Platform.getPlatform();
 *
 *  switch(platform) {
 *    case Platform.MAC: {
 *      //TODO Do something
 *      break;
 *    }
 *    case Platform.WINDOWS:
 *    case Platform.LINUX: {
 *      //TODO Do something else
 *    }
 *  }
 */

public enum Platform {UNKNOWN, WINDOWS, LINUX, MAC;
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
                minorVersion = Integer.parseInt(parts[0]);
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

    public static Platform getPlatform() {
        return platform;
    }

    public static int getMajorVersion() {
        return majorVersion;
    }

    public static int getMinorVersion() {
        return minorVersion;
    }
}
