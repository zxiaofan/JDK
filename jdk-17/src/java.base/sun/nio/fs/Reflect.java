/*
 * Copyright (c) 2008, 2021, Oracle and/or its affiliates. All rights reserved.
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

package sun.nio.fs;

import java.lang.reflect.*;
import java.security.AccessController;
import java.security.PrivilegedAction;

/**
 * Utility class for reflection.
 */

class Reflect {
    private Reflect() {}

    @SuppressWarnings("removal")
    private static void setAccessible(final AccessibleObject ao) {
        AccessController.doPrivileged(new PrivilegedAction<Object>() {
                @Override
                public Object run() {
                    ao.setAccessible(true);
                    return null;
                }});
    }

    /**
     * Lookup the field of a given class.
     */
    static Field lookupField(String className, String fieldName) {
        try {
            Class<?> cl = Class.forName(className);
            Field f = cl.getDeclaredField(fieldName);
            setAccessible(f);
            return f;
        } catch (ClassNotFoundException x) {
            throw new AssertionError(x);
        } catch (NoSuchFieldException x) {
            throw new AssertionError(x);
        }
    }
}
