/*
 * Copyright (c) 1997, 2016, Oracle and/or its affiliates. All rights reserved.
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

import javax.xml.XMLConstants;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import javax.xml.namespace.QName;

import com.sun.tools.internal.xjc.model.nav.NClass;
import com.sun.tools.internal.xjc.model.nav.NType;
import com.sun.tools.internal.xjc.reader.xmlschema.BGMBuilder;
import com.sun.xml.internal.bind.v2.model.core.PropertyInfo;
import com.sun.xml.internal.bind.v2.model.core.TypeRef;
import com.sun.xml.internal.bind.v2.runtime.RuntimeUtil;
import com.sun.xml.internal.xsom.XSType;
import com.sun.xml.internal.xsom.XmlString;
import com.sun.xml.internal.xsom.XSElementDecl;
import com.sun.istack.internal.Nullable;

/**
 * {@link TypeRef} for XJC.
 *
 * TODO: do we need the source schema component support here?
 *
 * @author Kohsuke Kawaguchi
 */
public final class CTypeRef implements TypeRef<NType,NClass> {
    /**
     * In-memory type.
     *
     * This is the type used when
     */
    @XmlJavaTypeAdapter(RuntimeUtil.ToStringAdapter.class)
    private final CNonElement type;

    private final QName elementName;

    /**
     * XML Schema type name of {@link #type}, if available.
     */
    /*package*/ final @Nullable QName typeName;

    private final boolean nillable;
    public final XmlString defaultValue;

    public CTypeRef(CNonElement type, XSElementDecl decl) {
        this(type, BGMBuilder.getName(decl),getSimpleTypeName(decl), decl.isNillable(), decl.getDefaultValue() );
    }

    public QName getTypeName() {
        return typeName;
    }

    public static QName getSimpleTypeName(XSElementDecl decl) {
        if(decl==null || !decl.getType().isSimpleType())
            return null; // null if not simple type
        return resolveSimpleTypeName(decl.getType());
    }

    /**
     * Recursively search for type name.
     *
     * This is needed to find correct type for refs like:
     *
     *<xs:simpleType name="parent">
     *  <xs:restriction base="xs:date"/>
     *</xs:simpleType>
     *<xs:simpleType name="child">
     *  <xs:restriction base="parent"/>
     *</xs:simpleType>
     *
     *<xs:element name="testField" type="child"/>
     *
     * @param declType given type
     * @return simpleTypeName or null
     */
    private static QName resolveSimpleTypeName(XSType declType) {
        QName name = BGMBuilder.getName(declType);
        QName result = null;
        if (name != null && !XMLConstants.W3C_XML_SCHEMA_NS_URI.equals(name.getNamespaceURI())) {
            result = resolveSimpleTypeName(declType.getBaseType());
        } else {
            if ( !"anySimpleType".equals(declType.getName()) ) {
                result = name;
            }
        }
        return result;
    }

    public CTypeRef(CNonElement type, QName elementName, QName typeName, boolean nillable, XmlString defaultValue) {
        assert type!=null;
        assert elementName!=null;

        this.type = type;
        this.elementName = elementName;
        this.typeName = typeName;
        this.nillable = nillable;
        this.defaultValue = defaultValue;
    }

    public CNonElement getTarget() {
        return type;
    }

    public QName getTagName() {
        return elementName;
    }

    public boolean isNillable() {
        return nillable;
    }

    /**
     * Inside XJC, use {@link #defaultValue} that has context information.
     * This method is to override the one defined in the runtime model.
     *
     * @see #defaultValue
     */
    public String getDefaultValue() {
        if(defaultValue!=null)
            return defaultValue.value;
        else
            return null;
    }

    public boolean isLeaf() {
        // TODO: implement this method later
        throw new UnsupportedOperationException();
    }

    public PropertyInfo<NType, NClass> getSource() {
        // TODO: implement this method later
        throw new UnsupportedOperationException();
    }
}
