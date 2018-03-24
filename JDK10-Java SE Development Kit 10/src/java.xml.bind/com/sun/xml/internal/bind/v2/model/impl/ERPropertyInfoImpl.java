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

import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.namespace.QName;

import com.sun.xml.internal.bind.v2.runtime.IllegalAnnotationException;

/**
 * Common part of {@link ElementPropertyInfoImpl} and {@link ReferencePropertyInfoImpl}.
 *
 * @author Kohsuke Kawaguchi
 */
abstract class ERPropertyInfoImpl<TypeT,ClassDeclT,FieldT,MethodT>
    extends PropertyInfoImpl<TypeT,ClassDeclT,FieldT,MethodT> {

    public ERPropertyInfoImpl(ClassInfoImpl<TypeT, ClassDeclT, FieldT, MethodT> classInfo, PropertySeed<TypeT, ClassDeclT, FieldT, MethodT> propertySeed) {
        super(classInfo, propertySeed);

        XmlElementWrapper e = seed.readAnnotation(XmlElementWrapper.class);

        boolean nil = false;
        boolean required = false;
        if(!isCollection()) {
            xmlName = null;
            if(e!=null)
                classInfo.builder.reportError(new IllegalAnnotationException(
                    Messages.XML_ELEMENT_WRAPPER_ON_NON_COLLECTION.format(
                        nav().getClassName(parent.getClazz())+'.'+seed.getName()),
                    e
                ));
        } else {
            if(e!=null) {
                xmlName = calcXmlName(e);
                nil = e.nillable();
                required = e.required();
            } else
                xmlName = null;
        }

        wrapperNillable = nil;
        wrapperRequired = required;
    }

    private final QName xmlName;

    /**
     * True if the wrapper tag name is nillable.
     */
    private final boolean wrapperNillable;

    /**
     * True if the wrapper tag is required.
     */
    private final boolean wrapperRequired;

    /**
     * Gets the wrapper element name.
     */
    public final QName getXmlName() {
        return xmlName;
    }

    public final boolean isCollectionNillable() {
        return wrapperNillable;
    }

    public final boolean isCollectionRequired() {
        return wrapperRequired;
    }
}
