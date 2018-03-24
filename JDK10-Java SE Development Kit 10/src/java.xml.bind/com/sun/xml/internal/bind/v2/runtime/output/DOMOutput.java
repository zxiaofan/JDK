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

package com.sun.xml.internal.bind.v2.runtime.output;

import com.sun.xml.internal.bind.v2.runtime.AssociationMap;
import com.sun.xml.internal.bind.marshaller.SAX2DOMEx;

import org.w3c.dom.Node;
import org.xml.sax.SAXException;

/**
 * {@link XmlOutput} implementation that does associative marshalling to DOM.
 *
 * <p>
 * This is used for binder.
 *
 * @author Kohsuke Kawaguchi
 */
public final class DOMOutput extends SAXOutput {
    private final AssociationMap assoc;

    public DOMOutput(Node node, AssociationMap assoc) {
        super(new SAX2DOMEx(node));
        this.assoc = assoc;
        assert assoc!=null;
    }

    private SAX2DOMEx getBuilder() {
        return (SAX2DOMEx)out;
    }

    @Override
    public void endStartTag() throws SAXException {
        super.endStartTag();

        Object op = nsContext.getCurrent().getOuterPeer();
        if(op!=null)
            assoc.addOuter( getBuilder().getCurrentElement(), op );

        Object ip = nsContext.getCurrent().getInnerPeer();
        if(ip!=null)
            assoc.addInner( getBuilder().getCurrentElement(), ip );
    }
}
