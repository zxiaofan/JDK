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

package com.sun.xml.internal.xsom.impl;

import com.sun.xml.internal.xsom.XSAttributeDecl;
import com.sun.xml.internal.xsom.XSAttributeUse;
import com.sun.xml.internal.xsom.XmlString;
import com.sun.xml.internal.xsom.impl.parser.SchemaDocumentImpl;
import com.sun.xml.internal.xsom.visitor.XSFunction;
import com.sun.xml.internal.xsom.visitor.XSVisitor;
import org.xml.sax.Locator;

public class AttributeUseImpl extends ComponentImpl implements XSAttributeUse
{
    public AttributeUseImpl( SchemaDocumentImpl owner, AnnotationImpl ann, Locator loc, ForeignAttributesImpl fa, Ref.Attribute _decl,
        XmlString def, XmlString fixed, boolean req ) {

        super(owner,ann,loc,fa);

        this.att = _decl;
        this.defaultValue = def;
        this.fixedValue = fixed;
        this.required = req;
    }

    private final Ref.Attribute att;
    public XSAttributeDecl getDecl() { return att.getAttribute(); }

    private final XmlString defaultValue;
    public XmlString getDefaultValue() {
        if( defaultValue!=null )    return defaultValue;
        else                        return getDecl().getDefaultValue();
    }

    private final XmlString fixedValue;
    public XmlString getFixedValue() {
        if( fixedValue!=null )      return fixedValue;
        else                        return getDecl().getFixedValue();
    }

    private final boolean required;
    public boolean isRequired() { return required; }

    public Object apply( XSFunction f ) {
        return f.attributeUse(this);
    }
    public void visit( XSVisitor v ) {
        v.attributeUse(this);
    }
}
