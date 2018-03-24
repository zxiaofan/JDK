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

import javax.xml.namespace.QName;

import com.sun.xml.internal.bind.v2.model.core.NonElement;
import com.sun.xml.internal.bind.v2.model.core.PropertyInfo;
import com.sun.xml.internal.bind.v2.model.core.TypeRef;

/**
 * @author Kohsuke Kawaguchi
 */
class TypeRefImpl<TypeT,ClassDeclT> implements TypeRef<TypeT,ClassDeclT> {
    private final QName elementName;
    private final TypeT type;
    protected final ElementPropertyInfoImpl<TypeT,ClassDeclT,?,?> owner;
    private NonElement<TypeT,ClassDeclT> ref;
    private final boolean isNillable;
    private String defaultValue;

    public TypeRefImpl(ElementPropertyInfoImpl<TypeT, ClassDeclT, ?, ?> owner, QName elementName, TypeT type, boolean isNillable, String defaultValue) {
        this.owner = owner;
        this.elementName = elementName;
        this.type = type;
        this.isNillable = isNillable;
        this.defaultValue = defaultValue;
        assert owner!=null;
        assert elementName!=null;
        assert type!=null;
    }

    public NonElement<TypeT,ClassDeclT> getTarget() {
        if(ref==null)
            calcRef();
        return ref;
    }

    public QName getTagName() {
        return elementName;
    }

    public boolean isNillable() {
        return isNillable;
    }

    public String getDefaultValue() {
        return defaultValue;
    }

    protected void link() {
        // if we have'nt computed the ref yet, do so now.
        calcRef();
    }

    private void calcRef() {
        // we can't do this eagerly because of a cyclic dependency
        ref = owner.parent.builder.getTypeInfo(type,owner);
        assert ref!=null;
    }

    public PropertyInfo<TypeT,ClassDeclT> getSource() {
        return owner;
    }
}
