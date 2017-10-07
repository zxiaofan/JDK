/*
 * Copyright (c) 1997, 2015, Oracle and/or its affiliates. All rights reserved.
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

package com.sun.xml.internal.bind;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

import javax.xml.bind.JAXBException;

import com.sun.xml.internal.bind.v2.runtime.reflect.Accessor;

public class AccessorFactoryImpl implements InternalAccessorFactory {

    private static AccessorFactoryImpl instance = new AccessorFactoryImpl();
    private AccessorFactoryImpl(){}

    public static AccessorFactoryImpl getInstance(){
        return instance;
    }

    /**
     * Access a field of the class.
     *
     * @param bean the class to be processed.
     * @param field the field within the class to be accessed.
     * @param readOnly  the isStatic value of the field's modifier.
     * @return Accessor the accessor for this field
     */
    public Accessor createFieldAccessor(Class bean, Field field, boolean readOnly) {
        return readOnly
                ? new Accessor.ReadOnlyFieldReflection(field)
                : new Accessor.FieldReflection(field);
    }

    /**
     * Access a field of the class.
     *
     * @param bean the class to be processed.
     * @param field the field within the class to be accessed.
     * @param readOnly  the isStatic value of the field's modifier.
     * @param supressWarning supress security warning about accessing fields through reflection
     * @return Accessor the accessor for this field
     */
    public Accessor createFieldAccessor(Class bean, Field field, boolean readOnly, boolean supressWarning) {
        return readOnly
                ? new Accessor.ReadOnlyFieldReflection(field, supressWarning)
                : new Accessor.FieldReflection(field, supressWarning);
    }

    /**
     * Access a property of the class.
     *
     * @param bean the class to be processed
     * @param getter the getter method to be accessed. The value can be null.
     * @param setter the setter method to be accessed. The value can be null.
     * @return Accessor the accessor for these methods
     */
    public Accessor createPropertyAccessor(Class bean, Method getter, Method setter) {
        if (getter == null) {
            return new Accessor.SetterOnlyReflection(setter);
        }
        if (setter == null) {
            return new Accessor.GetterOnlyReflection(getter);
        }
        return new Accessor.GetterSetterReflection(getter, setter);
    }
}
