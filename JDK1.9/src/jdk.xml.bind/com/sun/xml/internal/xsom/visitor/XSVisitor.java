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

package com.sun.xml.internal.xsom.visitor;

import com.sun.xml.internal.xsom.XSAnnotation;
import com.sun.xml.internal.xsom.XSAttGroupDecl;
import com.sun.xml.internal.xsom.XSAttributeDecl;
import com.sun.xml.internal.xsom.XSAttributeUse;
import com.sun.xml.internal.xsom.XSComplexType;
import com.sun.xml.internal.xsom.XSFacet;
import com.sun.xml.internal.xsom.XSNotation;
import com.sun.xml.internal.xsom.XSSchema;
import com.sun.xml.internal.xsom.XSIdentityConstraint;
import com.sun.xml.internal.xsom.XSXPath;
import com.sun.xml.internal.xsom.impl.IdentityConstraintImpl;
import com.sun.xml.internal.xsom.impl.XPathImpl;

/**
 * Visitor for {@link com.sun.xml.internal.xsom.XSComponent}
 */
public interface XSVisitor extends XSTermVisitor, XSContentTypeVisitor {
    void annotation( XSAnnotation ann );
    void attGroupDecl( XSAttGroupDecl decl );
    void attributeDecl( XSAttributeDecl decl );
    void attributeUse( XSAttributeUse use );
    void complexType( XSComplexType type );
    void schema( XSSchema schema );
//    void schemaSet( XSSchemaSet schema );
    void facet( XSFacet facet );
    void notation( XSNotation notation );
    void identityConstraint( XSIdentityConstraint decl);
    void xpath(XSXPath xp);
}
