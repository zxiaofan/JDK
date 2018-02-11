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

package com.sun.tools.internal.xjc.reader.xmlschema;

import com.sun.xml.internal.xsom.XSAttGroupDecl;
import com.sun.xml.internal.xsom.XSAttributeDecl;
import com.sun.xml.internal.xsom.XSAttributeUse;
import com.sun.xml.internal.xsom.XSComplexType;
import com.sun.xml.internal.xsom.XSContentType;
import com.sun.xml.internal.xsom.XSElementDecl;
import com.sun.xml.internal.xsom.XSModelGroup;
import com.sun.xml.internal.xsom.XSModelGroupDecl;
import com.sun.xml.internal.xsom.XSParticle;
import com.sun.xml.internal.xsom.XSSimpleType;
import com.sun.xml.internal.xsom.XSWildcard;

/**
 * @author Kohsuke Kawaguchi
 */
public final class BindYellow extends ColorBinder {
    public void complexType(XSComplexType ct) {
    }

    public void wildcard(XSWildcard xsWildcard) {
        // TODO: implement this method later
        throw new UnsupportedOperationException();
    }

    public void elementDecl(XSElementDecl xsElementDecl) {
        // TODO: implement this method later
        throw new UnsupportedOperationException();
    }

    public void simpleType(XSSimpleType xsSimpleType) {
        // TODO: implement this method later
        throw new UnsupportedOperationException();
    }

    public void attributeDecl(XSAttributeDecl xsAttributeDecl) {
        // TODO: implement this method later
        throw new UnsupportedOperationException();
    }


/*

    Components that can never map to a type

*/
    public void attGroupDecl(XSAttGroupDecl xsAttGroupDecl) {
        throw new IllegalStateException();
    }

    public void attributeUse(XSAttributeUse use) {
        throw new IllegalStateException();
    }

    public void modelGroupDecl(XSModelGroupDecl xsModelGroupDecl) {
        throw new IllegalStateException();
    }

    public void modelGroup(XSModelGroup xsModelGroup) {
        throw new IllegalStateException();
    }

    public void particle(XSParticle xsParticle) {
        throw new IllegalStateException();
    }

    public void empty(XSContentType xsContentType) {
        throw new IllegalStateException();
    }
}
