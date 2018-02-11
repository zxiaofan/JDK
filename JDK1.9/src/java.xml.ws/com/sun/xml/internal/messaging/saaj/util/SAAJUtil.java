/*
 * Copyright (c) 2011, 2017, Oracle and/or its affiliates. All rights reserved.
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

package com.sun.xml.internal.messaging.saaj.util;

import java.security.AccessControlException;
import java.security.AccessController;
import java.security.PrivilegedAction;

/**
 *
 * @author vbkumarjayanti
 */
public final class SAAJUtil {

    public static boolean getSystemBoolean(String arg) {
        try {
            return Boolean.getBoolean(arg);
        } catch (AccessControlException ex) {
            return false;
        }
    }

    public static String getSystemProperty(String arg) {
        try {
            return System.getProperty(arg);
        } catch (SecurityException ex) {
            return null;
        }
    }

    public static ClassLoader getSystemClassLoader() {
        return AccessController.doPrivileged(new PrivilegedAction<ClassLoader>() {
            @Override
            public ClassLoader run() {
                return ClassLoader.getSystemClassLoader();
            }
        });
    }
}
