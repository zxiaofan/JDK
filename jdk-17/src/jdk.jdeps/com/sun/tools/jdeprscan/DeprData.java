/*
 * Copyright (c) 2016, Oracle and/or its affiliates. All rights reserved.
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

package com.sun.tools.jdeprscan;

import javax.lang.model.element.ElementKind;
import javax.lang.model.element.TypeElement;

/**
 * A simple data class that contains language model data (TypeElement, etc.)
 * about a deprecated API.
 */
public class DeprData {
    final ElementKind kind;
    final TypeElement type; // null if data loaded from file
    final String typeName;
    final String nameSig;
    final String since;
    final boolean forRemoval;

    public DeprData(ElementKind kind, TypeElement type, String typeName, String nameSig,
                    String since, boolean forRemoval) {
        this.kind = kind;
        this.type = type;
        this.typeName = typeName;
        this.nameSig = nameSig;
        this.since = since;
        this.forRemoval = forRemoval;
    }

    public boolean isForRemoval() {
        return forRemoval;
    }

    @Override
    public String toString() {
        return String.format("DeprData(%s,%s,%s,%s,%s,%s)",
                             kind, type, typeName, nameSig, since, forRemoval);
    }
}
