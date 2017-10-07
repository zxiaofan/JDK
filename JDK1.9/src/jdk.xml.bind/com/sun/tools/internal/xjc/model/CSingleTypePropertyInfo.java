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

package com.sun.tools.internal.xjc.model;

import java.util.Collections;
import java.util.List;

import javax.activation.MimeType;
import javax.xml.namespace.QName;

import com.sun.xml.internal.bind.v2.model.core.ID;
import com.sun.xml.internal.xsom.XSComponent;

import org.xml.sax.Locator;

/**
 * {@link CPropertyInfo} backed by a single {@link TypeUse}.
 *
 * @author Kohsuke Kawaguchi
 */
abstract class CSingleTypePropertyInfo extends CPropertyInfo {
    protected final TypeUse type;

    private final QName schemaType;

    /**
     *
     * @param typeName
     *      XML Schema type name of this property's single value. Optional
     *      for other schema languages. This is used to determine if we should
     *      generate {@link @XmlSchemaType} annotation to improve the roundtrip.
     */
    protected CSingleTypePropertyInfo(String name, TypeUse type, QName typeName, XSComponent source, CCustomizations customizations, Locator locator) {
        super(name, type.isCollection(), source, customizations, locator);
        this.type = type;

        if(needsExplicitTypeName(type,typeName))
            schemaType = typeName;
        else
            schemaType = null;
    }

    public QName getSchemaType() {
        return schemaType;
    }

    public final ID id() {
        return type.idUse();
    }

    public final MimeType getExpectedMimeType() {
        return type.getExpectedMimeType();
    }

    public final List<? extends CTypeInfo> ref() {
        return Collections.singletonList(getTarget());
    }

    public final CNonElement getTarget() {
        CNonElement r = type.getInfo();
        assert r!=null;
        return r;
    }

    public final CAdapter getAdapter() {
        return type.getAdapterUse();
    }

    public final CSingleTypePropertyInfo getSource() {
        return this;
    }
}
