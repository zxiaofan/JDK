/*
 * Copyright (c) 2014, 2018, Oracle and/or its affiliates. All rights reserved.
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

package jdk.internal.access;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

public interface JavaBeansAccess {
    /**
     * Returns the getter method for a property of the given name
     * @param clazz The JavaBeans class
     * @param property The property name
     * @return The resolved property getter method
     * @throws Exception
     */
    Method getReadMethod(Class<?> clazz, String property) throws Exception;

    /**
     * Return the <b>value</b> attribute of the associated
     * <code>@ConstructorProperties</code> annotation if that is present.
     * @param ctr The constructor to extract the annotation value from
     * @return The {@code value} attribute of the <code>@ConstructorProperties</code>
     *         annotation or {@code null} if the constructor is not annotated by
     *         this annotation or the annotation is not accessible.
     */
    String[] getConstructorPropertiesValue(Constructor<?> ctr);
}
