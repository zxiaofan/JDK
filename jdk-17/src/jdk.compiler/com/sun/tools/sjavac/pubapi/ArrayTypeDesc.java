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

public class ArrayTypeDesc extends TypeDesc implements Serializable {

    private static final long serialVersionUID = -1177329549163314996L;

    TypeDesc compTypeDesc;

    public ArrayTypeDesc(TypeDesc compTypeDesc) {
        super(TypeKind.ARRAY);
        this.compTypeDesc = compTypeDesc;
    }

    @Override
    public boolean equals(Object obj) {
        if (!super.equals(obj))
            return false;
        return compTypeDesc.equals(((ArrayTypeDesc) obj).compTypeDesc);
    }

    @Override
    public int hashCode() {
        return super.hashCode() ^ compTypeDesc.hashCode();
    }

}
