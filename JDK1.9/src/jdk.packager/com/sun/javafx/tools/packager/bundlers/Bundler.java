/*
 * Copyright (c) 2012, 2016, Oracle and/or its affiliates. All rights reserved.
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

package com.sun.javafx.tools.packager.bundlers;

@Deprecated
public final class Bundler {

    private Bundler() {}

    /**
     * Located here for backwards compatibility
     */
    @Deprecated
    public enum BundleType {
        NONE,
        @Deprecated
        ALL,      // Generates all bundlers
        JNLP,     // Generates JNLP
        NATIVE,   // Generates both app image and all installers
        IMAGE,    // Generates app image only
        INSTALLER // Generates installers
    }

    @Deprecated
    public static final class Bundle {
        public BundleType type = BundleType.NONE;
        public String format = null;
    }

    @Deprecated
    static public Bundle stringToBundle(String value) {
        Bundle result = new Bundle();

        if (!value.isEmpty()) {
            if ("false".equals(value) || "none".equals(value)) {
                result.type = BundleType.NONE;
            } else if ("all".equals(value) || "true".equals(value)) {
                result.type = BundleType.ALL;
            } else if ("jnlp".equals(value)) {
                result.type = BundleType.JNLP;
            } else if ("image".equals(value)) {
                result.type = BundleType.IMAGE;
            } else if ("native".equals(value)) {
                result.type = BundleType.NATIVE;
            } else if ("installer".equals(value)) {
                result.type = BundleType.INSTALLER;
            } else {
                //assume it is request to build only specific format (like exe or msi)
                result.type = BundleType.INSTALLER;
                result.format = (value != null) ? value.toLowerCase() : null;
            }
        }

        return result;
    }
}
