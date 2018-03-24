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
 * Function object that works on the entire XML Schema components.
 *
 * @author
 *     Kohsuke Kawaguchi (kohsuke.kawaguchi@sun.com)
 */
public interface XSFunction<T> extends XSContentTypeFunction<T>, XSTermFunction<T> {

    T annotation( XSAnnotation ann );
    T attGroupDecl( XSAttGroupDecl decl );
    T attributeDecl( XSAttributeDecl decl );
    T attributeUse( XSAttributeUse use );
    T complexType( XSComplexType type );
    T schema( XSSchema schema );
//    T schemaSet( XSSchemaSet schema );
    T facet( XSFacet facet );
    T notation( XSNotation notation );
    T identityConstraint(XSIdentityConstraint decl);
    T xpath(XSXPath xpath);
}
