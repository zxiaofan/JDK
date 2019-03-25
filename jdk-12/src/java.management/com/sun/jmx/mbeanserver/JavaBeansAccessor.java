/*
 * Copyright (c) 2015, 2018, Oracle and/or its affiliates. All rights reserved.
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
package com.sun.jmx.mbeanserver;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import jdk.internal.access.JavaBeansAccess;
import jdk.internal.access.SharedSecrets;

/**
 * A centralized place for gaining access to java.beans related functionality -
 * if available.
 */
class JavaBeansAccessor {
    static {
        // ensure that java.beans.Introspector is initialized (if present)
        // it will fill in the SharedSecrets
        try {
            Class.forName("java.beans.Introspector", true,
                          JavaBeansAccessor.class.getClassLoader());
        } catch (ClassNotFoundException ignore) { }
    }

    private static JavaBeansAccess getJavaBeansAccess() {
        return SharedSecrets.getJavaBeansAccess();
    }

    static boolean isAvailable() {
        return getJavaBeansAccess() != null;
    }

    /**
     * Returns the getter method for a property of the given name
     * @param clazz The JavaBeans class
     * @param property The property name
     * @return The resolved property getter name or null
     * @throws Exception
     */
    static Method getReadMethod(Class<?> clazz, String property) throws Exception {
        JavaBeansAccess jba = getJavaBeansAccess();
        return jba != null ? jba.getReadMethod(clazz, property) : null;
    }

    /**
     * Return the <b>value</b> attribute of the associated
     * <code>@ConstructorProperties</code> annotation if that is present.
     * @param ctr The constructor to extract the annotation value from
     * @return The {@code value} attribute of the <code>@ConstructorProperties</code>
     *         annotation or {@code null} if the constructor is not annotated by
     *         this annotation or the annotation is not accessible.
     */
    static String[] getConstructorPropertiesValue(Constructor<?> ctr) {
        JavaBeansAccess jba = getJavaBeansAccess();
        return jba != null ? jba.getConstructorPropertiesValue(ctr) : null;
    }
}
