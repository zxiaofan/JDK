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
import com.sun.xml.internal.bind.v2.model.core.PropertyKind;
import com.sun.xml.internal.bind.v2.model.core.ValuePropertyInfo;
import com.sun.xml.internal.xsom.XSComponent;

import org.xml.sax.Locator;

/**
 * {@link ValuePropertyInfo} implementation for XJC.
 *
 * @author Kohsuke Kawaguchi
 */
public final class CValuePropertyInfo extends CSingleTypePropertyInfo implements ValuePropertyInfo<NType,NClass> {
    public CValuePropertyInfo(String name, XSComponent source, CCustomizations customizations, Locator locator, TypeUse type, QName typeName) {
        super(name, type, typeName, source, customizations, locator);
    }

    public final PropertyKind kind() {
        return  PropertyKind.VALUE;
    }

    public <V> V accept(CPropertyVisitor<V> visitor) {
        return visitor.onValue(this);
    }

    @Override
    public <R, P> R accept(CPropertyVisitor2<R, P> visitor, P p) {
        return visitor.visit(this, p);
    }
}
