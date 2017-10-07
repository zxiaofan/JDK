/*
 * Copyright (c) 1997, 2015, Oracle and/or its affiliates. All rights reserved.
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

package com.sun.tools.internal.xjc.util;

import java.util.Collections;
import java.util.Iterator;

import javax.xml.namespace.NamespaceContext;

import com.sun.xml.internal.xsom.XmlString;

import com.sun.xml.internal.org.relaxng.datatype.ValidationContext;

/**
 * Take a {@link ValidationContext} and make it look like a {@link NamespaceContext}.
 *
 * @author Kohsuke Kawaguchi
 */
public final class NamespaceContextAdapter implements NamespaceContext {
    private XmlString xstr;

    public NamespaceContextAdapter(XmlString xstr) {
        this.xstr = xstr;
    }

    public String getNamespaceURI(String prefix) {
        return xstr.resolvePrefix(prefix);
    }

    public String getPrefix(String namespaceURI) {
        return null;
    }

    public Iterator getPrefixes(String namespaceURI) {
        return Collections.EMPTY_LIST.iterator();
    }
}
