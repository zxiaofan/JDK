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
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlElementRefs;


/**
 * <p><b>Auto-generated, do not edit.</b></p>
 *
 */
final class XmlElementRefsQuick
    extends Quick
    implements XmlElementRefs
{

    private final XmlElementRefs core;

    public XmlElementRefsQuick(Locatable upstream, XmlElementRefs core) {
        super(upstream);
        this.core = core;
    }

    protected Annotation getAnnotation() {
        return core;
    }

    protected Quick newInstance(Locatable upstream, Annotation core) {
        return new XmlElementRefsQuick(upstream, ((XmlElementRefs) core));
    }

    public Class<XmlElementRefs> annotationType() {
        return XmlElementRefs.class;
    }

    public XmlElementRef[] value() {
        return core.value();
    }

}
