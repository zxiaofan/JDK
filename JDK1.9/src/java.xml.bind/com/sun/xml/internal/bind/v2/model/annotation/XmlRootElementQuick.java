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
import javax.xml.bind.annotation.XmlRootElement;


/**
 * <p><b>Auto-generated, do not edit.</b></p>
 *
 */
final class XmlRootElementQuick
    extends Quick
    implements XmlRootElement
{

    private final XmlRootElement core;

    public XmlRootElementQuick(Locatable upstream, XmlRootElement core) {
        super(upstream);
        this.core = core;
    }

    protected Annotation getAnnotation() {
        return core;
    }

    protected Quick newInstance(Locatable upstream, Annotation core) {
        return new XmlRootElementQuick(upstream, ((XmlRootElement) core));
    }

    public Class<XmlRootElement> annotationType() {
        return XmlRootElement.class;
    }

    public String name() {
        return core.name();
    }

    public String namespace() {
        return core.namespace();
    }

}
