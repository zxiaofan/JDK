/*
 * Copyright (c) 2008, Oracle and/or its affiliates. All rights reserved.
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
 * name of primitive type with appropriate wrapper.
 *
 * @since 1.7
 *
 * @author Sergey A. Malenkov
 */
public final class PrimitiveWrapperMap {

    /**
     * Replaces all primitive types in specified array with wrappers.
     *
     * @param types  array of classes where all primitive types
     *               will be replaced by appropriate wrappers
     */
    static void replacePrimitivesWithWrappers(Class<?>[] types) {
        for (int i = 0; i < types.length; i++) {
            if (types[i] != null) {
                if (types[i].isPrimitive()) {
                    types[i] = getType(types[i].getName());
                }
            }
        }
    }

    /**
     * Returns wrapper for primitive type by its name.
     *
     * @param name  the name of primitive type
     * @return found wrapper for primitive type,
     *         or {@code null} if not found
     */
    public static Class<?> getType(String name) {
        return map.get(name);
    }

    private static final Map<String, Class<?>> map = new HashMap<String, Class<?>>(9);

    static {
        map.put(Boolean.TYPE.getName(), Boolean.class);
        map.put(Character.TYPE.getName(), Character.class);
        map.put(Byte.TYPE.getName(), Byte.class);
        map.put(Short.TYPE.getName(), Short.class);
        map.put(Integer.TYPE.getName(), Integer.class);
        map.put(Long.TYPE.getName(), Long.class);
        map.put(Float.TYPE.getName(), Float.class);
        map.put(Double.TYPE.getName(), Double.class);
        map.put(Void.TYPE.getName(), Void.class);
    }

    /**
     * Disable instantiation.
     */
    private PrimitiveWrapperMap() {
    }
}
