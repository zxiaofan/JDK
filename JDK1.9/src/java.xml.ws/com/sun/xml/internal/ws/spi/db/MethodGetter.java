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

import java.lang.reflect.Method;
import javax.xml.ws.WebServiceException;


/**
 * MethodGetter
 * @author shih-chang.chen@oracle.com
 * @exclude
 */
public class MethodGetter extends PropertyGetterBase {

    private Method method;

    public MethodGetter(Method m) {
        verifyWrapperType(m.getDeclaringClass());
        method = m;
        type = m.getReturnType();
    }

    public Method getMethod() {
        return method;
    }

    public <A> A getAnnotation(Class<A> annotationType) {
        Class c = annotationType;
        return (A) method.getAnnotation(c);
    }

    public Object get(final Object instance) {
        final Object[] args = new Object[0];
        try {
            return method.invoke(instance, args);
        } catch (Exception e) {
            throw new WebServiceException(e);
        }
    }
}
