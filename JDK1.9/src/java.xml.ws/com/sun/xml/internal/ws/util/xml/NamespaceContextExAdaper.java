/*
 * Copyright (c) 2013, Oracle and/or its affiliates. All rights reserved.
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

package com.sun.xml.internal.ws.util.xml;

import java.util.Iterator;

import javax.xml.namespace.NamespaceContext;

import com.sun.xml.internal.org.jvnet.staxex.NamespaceContextEx;

public class NamespaceContextExAdaper implements NamespaceContextEx {

    private final NamespaceContext nsContext;

    public NamespaceContextExAdaper(NamespaceContext nsContext) {
        this.nsContext = nsContext;
    }

    @Override //Who wants this?
    public Iterator<Binding> iterator() {
        throw new UnsupportedOperationException();
    }

    @Override
    public String getNamespaceURI(String prefix) {
        return nsContext.getNamespaceURI(prefix);
    }

    @Override
    public String getPrefix(String namespaceURI) {
        return nsContext.getPrefix(namespaceURI);
    }

    @Override
    public Iterator getPrefixes(String namespaceURI) {
        return nsContext.getPrefixes(namespaceURI);
    }
}
