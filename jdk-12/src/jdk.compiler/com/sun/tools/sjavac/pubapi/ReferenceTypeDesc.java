/*
 * Copyright (c) 2014, 2015, Oracle and/or its affiliates. All rights reserved.
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

package com.sun.tools.sjavac.pubapi;

import java.io.Serializable;

import javax.lang.model.type.TypeKind;

public class ReferenceTypeDesc extends TypeDesc implements Serializable {

    private static final long serialVersionUID = 3357616754544796372L;

    // Example: "java.util.Vector<java.lang.String>"
    String javaType;

    public ReferenceTypeDesc(String javaType) {
        super(TypeKind.DECLARED);
        this.javaType = javaType;
    }

    @Override
    public boolean equals(Object obj) {
        if (!super.equals(obj))
            return false;
        return javaType.equals(((ReferenceTypeDesc) obj).javaType);
    }

    @Override
    public int hashCode() {
        return super.hashCode() ^ javaType.hashCode();
    }

    @Override
    public String toString() {
        return String.format("%s[type: %s]", getClass().getSimpleName(), javaType);
    }
}
