/*
 * Copyright (c) 2012, 2013, Oracle and/or its affiliates. All rights reserved.
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

package com.sun.prism.es2;

class GLGPUInfo {

    final String vendor;    // Information extracted from the GL_VENDOR string
    final String model;     // Information extracted from the GL_RENDERER string

    // Currently, we have no need for version field. Minimum version check is
    // done elsewhere.
    // String version;      // Information extracted from the GL_VERSION string

    GLGPUInfo(String vendor, String model) {
        this.vendor = vendor;
        this.model = model;
    }

    /**
     * Check this GPU information against an entry stored in the whiteList and
     * blackList of ES2Qualifier
     *
     * @param gi entry stored in the whiteList or blackList of ES2Qualifier
     * @return true if sub-string matches otherwise false
     */
    boolean matches(GLGPUInfo gi) {

        // Note: this.vendor and this.model can't be null hence no need to do
        // null check. This check is done in the GLFactory.isQualified() method.

        boolean result = true;
        if (gi.vendor != null) {
            result = vendor.startsWith(gi.vendor);
        }
        if (gi.model != null) {
            result = model.contains(gi.model);
        }
        return result;
    }

    @Override public String toString() {
        return "GLGPUInfo [vendor = " + vendor + ", model = " + model + "]";
    }
}
