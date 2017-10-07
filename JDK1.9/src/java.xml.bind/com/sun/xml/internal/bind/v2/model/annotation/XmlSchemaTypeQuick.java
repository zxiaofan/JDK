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
import javax.xml.bind.annotation.XmlSchemaType;


/**
 * <p><b>Auto-generated, do not edit.</b></p>
 *
 */
final class XmlSchemaTypeQuick
    extends Quick
    implements XmlSchemaType
{

    private final XmlSchemaType core;

    public XmlSchemaTypeQuick(Locatable upstream, XmlSchemaType core) {
        super(upstream);
        this.core = core;
    }

    protected Annotation getAnnotation() {
        return core;
    }

    protected Quick newInstance(Locatable upstream, Annotation core) {
        return new XmlSchemaTypeQuick(upstream, ((XmlSchemaType) core));
    }

    public Class<XmlSchemaType> annotationType() {
        return XmlSchemaType.class;
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

}
