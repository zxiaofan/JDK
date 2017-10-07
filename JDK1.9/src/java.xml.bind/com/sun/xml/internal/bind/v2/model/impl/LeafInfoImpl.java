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

import javax.xml.namespace.QName;

import com.sun.xml.internal.bind.v2.model.annotation.Locatable;
import com.sun.xml.internal.bind.v2.model.core.LeafInfo;
import com.sun.xml.internal.bind.v2.runtime.Location;

/**
 * @author Kohsuke Kawaguchi
 */
abstract class LeafInfoImpl<TypeT,ClassDeclT> implements LeafInfo<TypeT,ClassDeclT>, Location {
    private final TypeT type;
    /**
     * Can be null for anonymous types.
     */
    private final QName typeName;

    protected LeafInfoImpl(TypeT type,QName typeName) {
        assert type!=null;

        this.type = type;
        this.typeName = typeName;
    }

    /**
     * A reference to the representation of the type.
     */
    public TypeT getType() {
        return type;
    }

    /**
     * Leaf-type cannot be referenced from IDREF.
     *
     * @deprecated
     *      why are you calling a method whose return value is always known?
     */
    public final boolean canBeReferencedByIDREF() {
        return false;
    }

    public QName getTypeName() {
        return typeName;
    }

    public Locatable getUpstream() {
        return null;
    }

    public Location getLocation() {
        // this isn't very accurate, but it's not too bad
        // doing it correctly need leaves to hold navigator.
        // otherwise revisit the design so that we take navigator as a parameter
        return this;
    }

    public boolean isSimpleType() {
        return true;
    }

    public String toString() {
        return type.toString();
    }

}
