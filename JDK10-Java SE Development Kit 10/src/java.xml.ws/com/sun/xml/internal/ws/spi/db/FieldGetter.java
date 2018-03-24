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


/**
 * FieldGetter gets the value of a field from an instance.
 *
 * @author shih-chang.chen@oracle.com
 * @exclude
 */
public class FieldGetter extends PropertyGetterBase {

    protected Field field;

    public FieldGetter(Field f) {
        verifyWrapperType(f.getDeclaringClass());
        field = f;
        type = f.getType();
    }

    public Field getField() {
        return field;
    }

    public Object get(final Object instance) {
        try {
            return field.get(instance);
        } catch (Exception e) {
            throw new WebServiceException(e);
        }
    }

    public <A> A getAnnotation(Class<A> annotationType) {
        Class c = annotationType;
        return (A) field.getAnnotation(c);
    }
}
