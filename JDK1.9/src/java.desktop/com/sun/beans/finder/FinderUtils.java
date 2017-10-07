/*
 * Copyright (c) 2015, Oracle and/or its affiliates. All rights reserved.
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
package com.sun.beans.finder;

/**
 * Defines utility methods for use by finders.
 */

final class FinderUtils {
    private FinderUtils() { }

    /**
     * Returns true if the given class is an exported package.
     */
    public static boolean isExported(Class<?> c) {
        String pn = packageName(c);
        return c.getModule().isExported(pn);
    }

    private static String packageName(Class<?> c) {
        if (c.isArray()) {
            return packageName(c.getComponentType());
        } else {
            String name = c.getName();
            int dot = name.lastIndexOf('.');
            if (dot == -1) return "";
            return name.substring(0, dot);
        }
    }
}
