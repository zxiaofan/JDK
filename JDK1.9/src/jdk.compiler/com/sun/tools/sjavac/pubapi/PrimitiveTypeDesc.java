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

import com.sun.tools.javac.util.StringUtils;

public class PrimitiveTypeDesc extends TypeDesc implements Serializable {

    private static final long serialVersionUID = 6051065543149129106L;

    public PrimitiveTypeDesc(TypeKind typeKind) {
        super(typeKind);
        if (!typeKind.isPrimitive() && typeKind != TypeKind.VOID)
            throw new IllegalArgumentException("Only primitives or void accepted");
    }

    // This class has no fields, so the inherited hashCode and equals should do fine.

    @Override
    public String toString() {
        return StringUtils.toLowerCase(typeKind.toString());
    }
}
