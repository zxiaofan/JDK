/*
 * Copyright (c) 2015, 2016, Oracle and/or its affiliates. All rights reserved.
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

package com.sun.javafx.tk;

import java.lang.reflect.Constructor;
import java.security.Permission;
import static com.sun.javafx.FXPermissions.ACCESS_CLIPBOARD_PERMISSION;
import java.security.AccessControlContext;
import java.security.AccessControlException;

public class PermissionHelper {

    private static boolean awtInitialized = false;
    private static Permission awtClipboardPermission;

    // Method to get the AWT access clipboard permission. It should
    // only be called if the FXPermission check fails, since it will load
    // and initialize an AWT class from the java.desktop module.
    private static synchronized Permission getAWTClipboardPermission() {
        if (!awtInitialized) {
            // Use refelction to avoid hard dependency on AWT.
            // If the class cannot be loaded, then no fallback is possible, so
            // just set it to null

            try {
                Class clazz = Class.forName("java.awt.AWTPermission",
                        false, PermissionHelper.class.getClassLoader());
                // FIXME JIGSAW: add read edge
                Constructor c = clazz.getConstructor(String.class);
                awtClipboardPermission = (Permission) c.newInstance("accessClipboard");
            } catch (Exception ex) {
                awtClipboardPermission = null;
            }

            awtInitialized = true;
        }

        return awtClipboardPermission;
    }

    public static void checkClipboardPermission() {
        final SecurityManager securityManager = System.getSecurityManager();

        // Always succeed if no security manager installed
        if (securityManager == null) return;

        // Check for FXPermission, using AWTPermission as fallback for compatibility
        try {
            securityManager.checkPermission(ACCESS_CLIPBOARD_PERMISSION);
        } catch (SecurityException ex) {
            // Try fallback if available
            final Permission perm = getAWTClipboardPermission();
            if (perm == null) throw ex;

            try {
                securityManager.checkPermission(perm);
            } catch (SecurityException ex2) {
                // Rethrow original exception
                throw ex;
            }
        }
    }

    public static void checkClipboardPermission(AccessControlContext context) {
        final SecurityManager securityManager = System.getSecurityManager();

        // Always succeed if no security manager installed
        if (securityManager == null) return;

        if (context == null) {
            throw new AccessControlException("AccessControlContext is null");
        }

        // Check for FXPermission, using AWTPermission as fallback for compatibility
        try {
            //
            securityManager.checkPermission(ACCESS_CLIPBOARD_PERMISSION, context);
        } catch (SecurityException ex) {
            // Try fallback if available
            final Permission perm = getAWTClipboardPermission();
            if (perm == null) throw ex;

            try {
                securityManager.checkPermission(perm, context);
            } catch (SecurityException ex2) {
                // Rethrow original exception
                throw ex;
            }
        }
    }

    // Static helper class; do not construct an instance
    private PermissionHelper() {}
}
