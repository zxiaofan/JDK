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

package com.sun.tools.internal.xjc.model;

import javax.xml.namespace.QName;

import com.sun.tools.internal.xjc.model.nav.NClass;
import com.sun.tools.internal.xjc.model.nav.NType;
import com.sun.xml.internal.bind.v2.model.core.AttributePropertyInfo;
import com.sun.xml.internal.bind.v2.model.core.PropertyKind;
import com.sun.xml.internal.xsom.XSComponent;
import com.sun.istack.internal.Nullable;

import org.xml.sax.Locator;

/**
 * {@link AttributePropertyInfo} for the compiler.
 *
 * @author Kohsuke Kawaguchi
 */
public final class CAttributePropertyInfo extends CSingleTypePropertyInfo implements AttributePropertyInfo<NType,NClass> {

    private final QName attName;
    private final boolean isRequired;

    /**
     * @param type
     *      Represents the bound type of this attribute.
     * @param typeName
     *      XML Schema type name of this attribute. Optional for other schema languages.
     */
    public CAttributePropertyInfo(String name, XSComponent source, CCustomizations customizations,
                                  Locator locator, QName attName, TypeUse type, @Nullable QName typeName,
                                  boolean required ) {
        super(name, type, typeName, source, customizations, locator);
        isRequired = required;
        this.attName = attName;
    }

    public boolean isRequired() {
        return isRequired;
    }

    public QName getXmlName() {
        return attName;
    }

    /**
     * An optional attribute can never be unboxable,
     * for we need null to represent the absence.
     */
    public boolean isUnboxable() {
        if(!isRequired) return false;
        return super.isUnboxable();
    }

    @Override
    public boolean isOptionalPrimitive() {
        return !isRequired && super.isUnboxable();
    }

    public <V> V accept(CPropertyVisitor<V> visitor) {
        return visitor.onAttribute(this);
    }
    @Override
    public <R, P> R accept(CPropertyVisitor2<R, P> visitor, P p) {
        return visitor.visit(this, p);
    }

    public final PropertyKind kind() {
        return  PropertyKind.ATTRIBUTE;
    }
}
