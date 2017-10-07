/*
 * Copyright (c) 1997, 2012, Oracle and/or its affiliates. All rights reserved.
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

package com.sun.xml.internal.bind.v2.model.impl;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Type;
import java.util.Set;

import com.sun.xml.internal.bind.v2.model.runtime.RuntimeElement;
import com.sun.xml.internal.bind.v2.model.runtime.RuntimeReferencePropertyInfo;
import com.sun.xml.internal.bind.v2.runtime.reflect.Accessor;

/**
 * @author Kohsuke Kawaguchi
 */
class RuntimeReferencePropertyInfoImpl extends ReferencePropertyInfoImpl<Type,Class,Field,Method>
    implements RuntimeReferencePropertyInfo {

    private final Accessor acc;

    public RuntimeReferencePropertyInfoImpl(RuntimeClassInfoImpl classInfo, PropertySeed<Type,Class,Field,Method> seed) {
        super(classInfo,seed);
        Accessor rawAcc = ((RuntimeClassInfoImpl.RuntimePropertySeed)seed).getAccessor();
        if(getAdapter()!=null && !isCollection())
            // adapter for a single-value property is handled by accessor.
            // adapter for a collection property is handled by lister.
            rawAcc = rawAcc.adapt(getAdapter());
        this.acc = rawAcc;
    }

    public Set<? extends RuntimeElement> getElements() {
        return (Set<? extends RuntimeElement>)super.getElements();
    }

    public Set<? extends RuntimeElement> ref() {
        return (Set<? extends RuntimeElement>)super.ref();
    }

    public Accessor getAccessor() {
        return acc;
    }

    public boolean elementOnlyContent() {
        return !isMixed();
    }
}
