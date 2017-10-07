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
import javax.xml.bind.annotation.XmlElement;


/**
 * <p><b>Auto-generated, do not edit.</b></p>
 *
 */
final class XmlElementQuick
    extends Quick
    implements XmlElement
{

    private final XmlElement core;

    public XmlElementQuick(Locatable upstream, XmlElement core) {
        super(upstream);
        this.core = core;
    }

    protected Annotation getAnnotation() {
        return core;
    }

    protected Quick newInstance(Locatable upstream, Annotation core) {
        return new XmlElementQuick(upstream, ((XmlElement) core));
    }

    public Class<XmlElement> annotationType() {
        return XmlElement.class;
    }

    public String name() {
        return core.name();
    }

    public Class type() {
        return core.type();
    }

    public String namespace() {
        return core.namespace();
    }

    public String defaultValue() {
        return core.defaultValue();
    }

    public boolean required() {
        return core.required();
    }

    public boolean nillable() {
        return core.nillable();
    }

}
