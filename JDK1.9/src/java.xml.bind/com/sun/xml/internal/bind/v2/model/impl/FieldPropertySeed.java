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

import java.lang.annotation.Annotation;

import com.sun.xml.internal.bind.v2.model.annotation.Locatable;
import com.sun.xml.internal.bind.v2.model.core.PropertyInfo;
import com.sun.xml.internal.bind.v2.runtime.Location;

/**
 * {@link PropertyInfo} implementation backed by a field.
 */
class FieldPropertySeed<TypeT,ClassDeclT,FieldT,MethodT> implements
        PropertySeed<TypeT,ClassDeclT,FieldT,MethodT> {

    protected final FieldT field;
    private ClassInfoImpl<TypeT,ClassDeclT,FieldT,MethodT> parent;

    FieldPropertySeed(ClassInfoImpl<TypeT,ClassDeclT,FieldT,MethodT> classInfo, FieldT field) {
        this.parent = classInfo;
        this.field = field;
    }

    public <A extends Annotation> A readAnnotation(Class<A> a) {
        return parent.reader().getFieldAnnotation(a, field,this);
    }

    public boolean hasAnnotation(Class<? extends Annotation> annotationType) {
        return parent.reader().hasFieldAnnotation(annotationType,field);
    }

    public String getName() {
        // according to the spec team, the BeanIntrospector.decapitalize does not apply
        // to the fields. Don't call Introspector.decapitalize
        return parent.nav().getFieldName(field);
    }

    public TypeT getRawType() {
        return parent.nav().getFieldType(field);
    }

    /**
     * Use the enclosing class as the upsream {@link Location}.
     */
    public Locatable getUpstream() {
        return parent;
    }

    public Location getLocation() {
        return parent.nav().getFieldLocation(field);
    }
}
