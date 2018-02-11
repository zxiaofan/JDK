/*
 * Copyright (c) 1997, 2013, Oracle and/or its affiliates. All rights reserved.
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

import java.util.Map;

import javax.xml.namespace.QName;

/**
 * WrapperAccessor
 *
 * @author shih-chang.chen@oracle.com
 */
public abstract class WrapperAccessor {
        protected Map<Object, PropertySetter> propertySetters;
        protected Map<Object, PropertyGetter> propertyGetters;
        protected boolean elementLocalNameCollision;

        protected PropertySetter getPropertySetter(QName name) {
        Object key = (elementLocalNameCollision) ? name : name.getLocalPart();
        return propertySetters.get(key);
    }
        protected PropertyGetter getPropertyGetter(QName name) {
        Object key = (elementLocalNameCollision) ? name : name.getLocalPart();
        return propertyGetters.get(key);
    }

        public PropertyAccessor getPropertyAccessor(String ns, String name) {
                QName n = new QName(ns, name);
                final PropertySetter setter = getPropertySetter(n);
                final PropertyGetter getter = getPropertyGetter(n);
                return new PropertyAccessor() {
                        public Object get(Object bean) throws DatabindingException {
                                return getter.get(bean);
                        }

                        public void set(Object bean, Object value) throws DatabindingException {
                                setter.set(bean, value);
                        }
                };
        }
}
