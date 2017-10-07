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

package com.sun.xml.internal.bind.v2.model.annotation;

import java.lang.annotation.Annotation;
import javax.xml.bind.annotation.XmlType;


/**
 * <p><b>Auto-generated, do not edit.</b></p>
 *
 */
final class XmlTypeQuick
    extends Quick
    implements XmlType
{

    private final XmlType core;

    public XmlTypeQuick(Locatable upstream, XmlType core) {
        super(upstream);
        this.core = core;
    }

    protected Annotation getAnnotation() {
        return core;
    }

    protected Quick newInstance(Locatable upstream, Annotation core) {
        return new XmlTypeQuick(upstream, ((XmlType) core));
    }

    public Class<XmlType> annotationType() {
        return XmlType.class;
    }

    public String name() {
        return core.name();
    }

    public String namespace() {
        return core.namespace();
    }

    public String[] propOrder() {
        return core.propOrder();
    }

    public Class factoryClass() {
        return core.factoryClass();
    }

    public String factoryMethod() {
        return core.factoryMethod();
    }

}
