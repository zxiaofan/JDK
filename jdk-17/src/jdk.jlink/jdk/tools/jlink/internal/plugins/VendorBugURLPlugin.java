/*
 * Copyright (c) 2019, Oracle and/or its affiliates. All rights reserved.
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

package jdk.tools.jlink.internal.plugins;

/**
 * Plugin to set the vendor bug URL, by redefining the static field
 * java.lang.VersionProps.VENDOR_URL_BUG
 */
public final class VendorBugURLPlugin extends VersionPropsPlugin {

    public VendorBugURLPlugin() {
        super("VENDOR_URL_BUG", "vendor-bug-url");
    }

}
