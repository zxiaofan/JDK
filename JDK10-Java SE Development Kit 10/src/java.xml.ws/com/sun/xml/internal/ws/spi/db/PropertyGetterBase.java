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

import javax.xml.ws.WebServiceException;

/**
 * This is the Gtter of a bean property.
 *
 * @author shih-chang.chen@oracle.com
 * @exclude
 */
public abstract class PropertyGetterBase implements PropertyGetter {
    protected Class type;

    public Class getType() {
        return type;
    }

    static public boolean getterPattern(java.lang.reflect.Method method) {
        if (!method.getReturnType().equals(void.class) &&
            (method.getParameterTypes() == null ||
             method.getParameterTypes().length == 0)) {
            if (method.getName().startsWith("get") &&
                method.getName().length() > 3) {
                return true;
            } else {
                if ((method.getReturnType().equals(boolean.class) || method.getReturnType().equals(Boolean.class)) &&
                    method.getName().startsWith("is") &&
                    method.getName().length() > 2) {
                    return true;
                }
            }
        }
        return false;
    }

    static void verifyWrapperType(Class wrapperType) {
        String className = wrapperType.getName();
        if (className.startsWith("java.") || className.startsWith("javax.")) {
            throw new WebServiceException("Invalid wrapper type " + className);
        }
    }
}
