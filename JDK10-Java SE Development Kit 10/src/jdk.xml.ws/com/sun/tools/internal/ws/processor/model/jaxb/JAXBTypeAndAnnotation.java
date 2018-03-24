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

package com.sun.tools.internal.ws.processor.model.jaxb;

import com.sun.codemodel.internal.JAnnotatable;
import com.sun.codemodel.internal.JType;
import com.sun.tools.internal.xjc.api.TypeAndAnnotation;

/**
 * Holds JAXB JType and TypeAndAnnotation. This provides abstration over
 * types from JAXBMapping and Property.
 */
public class JAXBTypeAndAnnotation {
    TypeAndAnnotation typeAnn;
    JType type;

    public JAXBTypeAndAnnotation(TypeAndAnnotation typeAnn) {
        this.typeAnn = typeAnn;
        this.type = typeAnn.getTypeClass();
    }

    public JAXBTypeAndAnnotation(JType type) {
        this.type = type;
    }

    public JAXBTypeAndAnnotation(TypeAndAnnotation typeAnn, JType type) {
        this.typeAnn = typeAnn;
        this.type = type;
    }

    public void annotate(JAnnotatable typeVar) {
        if(typeAnn != null)
            typeAnn.annotate(typeVar);
    }

    public JType getType() {
        return type;
    }

    public String getName(){
        return type.fullName();
    }

    public TypeAndAnnotation getTypeAnn() {
        return typeAnn;
    }

    public void setTypeAnn(TypeAndAnnotation typeAnn) {
        this.typeAnn = typeAnn;
    }

    public void setType(JType type) {
        this.type = type;
    }
}
