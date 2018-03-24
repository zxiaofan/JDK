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

package com.sun.xml.internal.ws.db.glassfish;

import com.sun.xml.internal.ws.spi.db.DatabindingException;
import com.sun.xml.internal.ws.spi.db.PropertyAccessor;
import com.sun.xml.internal.bind.api.AccessorException;
import com.sun.xml.internal.bind.api.RawAccessor;

@SuppressWarnings("unchecked")
public class RawAccessorWrapper implements PropertyAccessor {

    private RawAccessor accessor;

    public RawAccessorWrapper(RawAccessor a) {
        accessor = a;
    }

    @Override
    public boolean equals(Object obj) {
        return accessor.equals(obj);
    }

    @Override
    public Object get(Object bean) throws DatabindingException {
        try {
            return accessor.get(bean);
        } catch (AccessorException e) {
            throw new DatabindingException(e);
        }
    }

    @Override
    public int hashCode() {
        return accessor.hashCode();
    }

    @Override
    public void set(Object bean, Object value) throws DatabindingException {
        try {
            accessor.set(bean, value);
        } catch (AccessorException e) {
            throw new DatabindingException(e);
        }
    }

    @Override
    public String toString() {
        return accessor.toString();
    }
}
