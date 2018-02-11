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

package com.sun.xml.internal.bind.v2.model.nav;

import java.lang.reflect.GenericArrayType;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.lang.reflect.WildcardType;

/**
 * @author Kohsuke Kawaguchi
 */
abstract class TypeVisitor<T,P> {
    public final T visit( Type t, P param ) {
        assert t!=null;

        if (t instanceof Class)
            return onClass((Class)t,param);
        if (t instanceof ParameterizedType)
            return onParameterizdType( (ParameterizedType)t,param);
        if(t instanceof GenericArrayType)
            return onGenericArray((GenericArrayType)t,param);
        if(t instanceof WildcardType)
            return onWildcard((WildcardType)t,param);
        if(t instanceof TypeVariable)
            return onVariable((TypeVariable)t,param);

        // covered all the cases
        assert false;
        throw new IllegalArgumentException();
    }

    protected abstract T onClass(Class c, P param);
    protected abstract T onParameterizdType(ParameterizedType p, P param);
    protected abstract T onGenericArray(GenericArrayType g, P param);
    protected abstract T onVariable(TypeVariable v, P param);
    protected abstract T onWildcard(WildcardType w, P param);
}
