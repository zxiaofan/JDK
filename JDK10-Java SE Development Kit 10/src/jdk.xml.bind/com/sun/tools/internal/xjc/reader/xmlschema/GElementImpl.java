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

import javax.xml.namespace.QName;

import com.sun.tools.internal.xjc.reader.gbind.Element;
import com.sun.xml.internal.xsom.XSElementDecl;

/**
 * {@link Element} that wraps {@link XSElementDecl}.
 *
 * @author Kohsuke Kawaguchi
 */
final class GElementImpl extends GElement {
    public final QName tagName;

    /**
     * The representative {@link XSElementDecl}.
     *
     * Even though multiple {@link XSElementDecl}s maybe represented by
     * a single {@link GElementImpl} (especially when they are local),
     * the schema spec requires that they share the same type and other
     * characteristic.
     *
     * (To be really precise, you may have different default values,
     * nillability, all that, so if that becomes a real issue we have
     * to reconsider this design.)
     */
    public final XSElementDecl decl;

    public GElementImpl(QName tagName, XSElementDecl decl) {
        this.tagName = tagName;
        this.decl = decl;
    }

    public String toString() {
        return tagName.toString();
    }

    String getPropertyNameSeed() {
        return tagName.getLocalPart();
    }
}
