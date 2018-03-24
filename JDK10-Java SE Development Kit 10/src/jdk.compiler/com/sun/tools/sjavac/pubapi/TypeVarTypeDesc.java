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

public class TypeVarTypeDesc extends TypeDesc implements Serializable {

    private static final long serialVersionUID = 3357616754544796373L;

    String identifier; // Example: "T"

    public TypeVarTypeDesc(String identifier) {
        super(TypeKind.TYPEVAR);
        this.identifier = identifier;
    }

    @Override
    public boolean equals(Object obj) {
        if (!super.equals(obj))
            return false;
        return identifier.equals(((TypeVarTypeDesc) obj).identifier);
    }

    @Override
    public int hashCode() {
        return super.hashCode() ^ identifier.hashCode();
    }

    @Override
    public String toString() {
        return String.format("%s[identifier: %s]",
                             getClass().getSimpleName(),
                             identifier);
    }
}
