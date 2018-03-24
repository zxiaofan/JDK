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

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlSchema;
import javax.xml.namespace.QName;

import com.sun.xml.internal.bind.api.impl.NameConverter;
import com.sun.xml.internal.bind.v2.model.core.AttributePropertyInfo;
import com.sun.xml.internal.bind.v2.model.core.PropertyKind;

/**
 * @author Kohsuke Kawaguchi
 */
class AttributePropertyInfoImpl<TypeT,ClassDeclT,FieldT,MethodT>
    extends SingleTypePropertyInfoImpl<TypeT,ClassDeclT,FieldT,MethodT>
    implements AttributePropertyInfo<TypeT,ClassDeclT> {

    private final QName xmlName;

    private final boolean isRequired;

    AttributePropertyInfoImpl(ClassInfoImpl<TypeT,ClassDeclT,FieldT,MethodT> parent, PropertySeed<TypeT,ClassDeclT,FieldT,MethodT> seed ) {
        super(parent,seed);
        XmlAttribute att = seed.readAnnotation(XmlAttribute.class);
        assert att!=null;

        if(att.required())
            isRequired = true;
        else isRequired = nav().isPrimitive(getIndividualType());

        this.xmlName = calcXmlName(att);
    }

    private QName calcXmlName(XmlAttribute att) {
        String uri;
        String local;

        uri = att.namespace();
        local = att.name();

        // compute the default
        if(local.equals("##default"))
            local = NameConverter.standard.toVariableName(getName());
        if(uri.equals("##default")) {
            XmlSchema xs = reader().getPackageAnnotation( XmlSchema.class, parent.getClazz(), this );
            // JAX-RPC doesn't want the default namespace URI swapping to take effect to
            // local "unqualified" elements. UGLY.
            if(xs!=null) {
                switch(xs.attributeFormDefault()) {
                case QUALIFIED:
                    uri = parent.getTypeName().getNamespaceURI();
                    if(uri.length()==0)
                        uri = parent.builder.defaultNsUri;
                    break;
                case UNQUALIFIED:
                case UNSET:
                    uri = "";
                }
            } else
                uri = "";
        }

        return new QName(uri.intern(),local.intern());
    }

    public boolean isRequired() {
        return isRequired;
    }

    public final QName getXmlName() {
        return xmlName;
    }

    public final PropertyKind kind() {
        return PropertyKind.ATTRIBUTE;
    }
}
