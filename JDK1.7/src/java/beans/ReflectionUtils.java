/*
 * Copyright (c) 2003, 2009, Oracle and/or its affiliates. All rights reserved.
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
package java.beans;

import java.lang.reflect.Field;

/**
 * A utility class for reflectively finding methods, constuctors and fields
 * using reflection.
 */
class ReflectionUtils {

    public static boolean isPrimitive(Class type) {
        return primitiveTypeFor(type) != null;
    }

    public static Class primitiveTypeFor(Class wrapper) {
        if (wrapper == Boolean.class) return Boolean.TYPE;
        if (wrapper == Byte.class) return Byte.TYPE;
        if (wrapper == Character.class) return Character.TYPE;
        if (wrapper == Short.class) return Short.TYPE;
        if (wrapper == Integer.class) return Integer.TYPE;
        if (wrapper == Long.class) return Long.TYPE;
        if (wrapper == Float.class) return Float.TYPE;
        if (wrapper == Double.class) return Double.TYPE;
        if (wrapper == Void.class) return Void.TYPE;
        return null;
    }

    /**
     * Returns the value of a private field.
     *
     * @param instance object instance
     * @param cls class
     * @param name name of the field
     * @param el an exception listener to handle exceptions; or null
     * @return value of the field; null if not found or an error is encountered
     */
    public static Object getPrivateField(Object instance, Class cls,
                                         String name, ExceptionListener el) {
        try {
            Field f = cls.getDeclaredField(name);
            f.setAccessible(true);
            return f.get(instance);
        }
        catch (Exception e) {
            if (el != null) {
                el.exceptionThrown(e);
            }
        }
        return null;
    }
}
