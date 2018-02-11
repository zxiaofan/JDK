/*
 * Copyright (c) 2010, 2015, Oracle and/or its affiliates. All rights reserved.
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

package jdk.nashorn.internal.runtime;

import java.util.MissingResourceException;
import java.util.ResourceBundle;

/**
 * Class to handle version strings for Nashorn.
 */
public final class Version {
    // Don't create me!
    private Version() {
    }

    /**
     * The current version number as a string.
     * @return version string
     */
    public static String version() {
        return version("version_short");  // E.g. "9-internal" or "9.1.2"
    }

    /**
     * The current full version number as a string.
     * @return full version string
     */
    public static String fullVersion() {
        return version("version_string"); // E.g. "9.1.2.3-ea-4+nashorn-testing"
    }

    private static final String   VERSION_RB_NAME = "jdk.nashorn.internal.runtime.resources.version";
    private static ResourceBundle versionRB;

    private static String version(final String key) {
        if (versionRB == null) {
            try {
                versionRB = ResourceBundle.getBundle(VERSION_RB_NAME);
            } catch (final MissingResourceException e) {
                return "version not available";
            }
        }
        try {
            return versionRB.getString(key);
        }
        catch (final MissingResourceException e) {
            return "version not available";
        }
    }
}
