/*
 * Copyright (c) 1997, 2014, Oracle and/or its affiliates. All rights reserved.
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

package com.sun.xml.internal.ws.spi.db;

import java.lang.reflect.Field;
import javax.xml.ws.WebServiceException;
import static com.sun.xml.internal.ws.spi.db.PropertyGetterBase.verifyWrapperType;

/**
 * FieldSetter
 * @author shih-chang.chen@oracle.com
 * @exclude
 */
public class FieldSetter extends PropertySetterBase {

    protected Field field;

    public FieldSetter(Field f) {
        verifyWrapperType(f.getDeclaringClass());
        field = f;
        type = f.getType();
    }

    public Field getField() {
        return field;
    }

    public void set(final Object instance, final Object val) {
        final Object resource = (type.isPrimitive() && val == null)? uninitializedValue(type): val;
        try {
            field.set(instance, resource);
        } catch (Exception e) {
            throw new WebServiceException(e);
        }
    }

    public <A> A getAnnotation(Class<A> annotationType) {
        Class c = annotationType;
        return (A) field.getAnnotation(c);
    }
}
