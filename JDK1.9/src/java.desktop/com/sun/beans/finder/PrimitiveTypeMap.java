/*
 * Copyright (c) 2006, 2008, Oracle and/or its affiliates. All rights reserved.
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

import java.util.HashMap;
import java.util.Map;

/**
 * This utility class associates
 * name of primitive type with appropriate class.
 *
 * @since 1.7
 *
 * @author Sergey A. Malenkov
 */
final class PrimitiveTypeMap {

    /**
     * Returns primitive type class by its name.
     *
     * @param name  the name of primitive type
     * @return found primitive type class,
     *         or {@code null} if not found
     */
    static Class<?> getType(String name) {
        return map.get(name);
    }

    private static final Map<String, Class<?>> map = new HashMap<String, Class<?>>(9);

    static {
        map.put(boolean.class.getName(), boolean.class);
        map.put(char.class.getName(), char.class);
        map.put(byte.class.getName(), byte.class);
        map.put(short.class.getName(), short.class);
        map.put(int.class.getName(), int.class);
        map.put(long.class.getName(), long.class);
        map.put(float.class.getName(), float.class);
        map.put(double.class.getName(), double.class);
        map.put(void.class.getName(), void.class);
    }

    /**
     * Disable instantiation.
     */
    private PrimitiveTypeMap() {
    }
}
