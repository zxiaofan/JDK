/*
 * Copyright (c) 2017, 2020, Oracle and/or its affiliates. All rights reserved.
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
package jdk.tools.jlink.internal;

import jdk.tools.jlink.plugin.ResourcePoolModule;

import java.util.Locale;

/**
 * Supported platforms
 */
public enum Platform {
    WINDOWS,
    LINUX,
    MACOS,
    AIX,
    UNKNOWN;

    /**
     * Returns the {@code Platform} derived from the target platform
     * in the {@code ModuleTarget} attribute.
     */
    public static Platform toPlatform(String targetPlatform) {
        String osName;
        int index = targetPlatform.indexOf("-");
        if (index < 0) {
            osName = targetPlatform;
        } else {
            osName = targetPlatform.substring(0, index);
        }
        try {
            return Platform.valueOf(osName.toUpperCase(Locale.ENGLISH));
        } catch (IllegalArgumentException e) {
            return Platform.UNKNOWN;
        }
    }

    /**
     * Returns the {@code Platform} to which the given module is target to.
     */
    public static Platform getTargetPlatform(ResourcePoolModule module) {
        String targetPlatform = module.targetPlatform();
        if (targetPlatform != null) {
            return toPlatform(targetPlatform);
        } else {
            return Platform.UNKNOWN;
        }
    }
}
