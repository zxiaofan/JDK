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
import javax.xml.bind.annotation.XmlElementDecl;


/**
 * <p><b>Auto-generated, do not edit.</b></p>
 *
 */
final class XmlElementDeclQuick
    extends Quick
    implements XmlElementDecl
{

    private final XmlElementDecl core;

    public XmlElementDeclQuick(Locatable upstream, XmlElementDecl core) {
        super(upstream);
        this.core = core;
    }

    protected Annotation getAnnotation() {
        return core;
    }

    protected Quick newInstance(Locatable upstream, Annotation core) {
        return new XmlElementDeclQuick(upstream, ((XmlElementDecl) core));
    }

    public Class<XmlElementDecl> annotationType() {
        return XmlElementDecl.class;
    }

    public String name() {
        return core.name();
    }

    public Class scope() {
        return core.scope();
    }

    public String namespace() {
        return core.namespace();
    }

    public String defaultValue() {
        return core.defaultValue();
    }

    public String substitutionHeadNamespace() {
        return core.substitutionHeadNamespace();
    }

    public String substitutionHeadName() {
        return core.substitutionHeadName();
    }

}
