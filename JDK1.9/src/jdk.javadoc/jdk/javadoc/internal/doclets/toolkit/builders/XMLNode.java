/*
 * Copyright (c) 2010, 2015, Oracle and/or its affiliates. All rights reserved.
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

package jdk.javadoc.internal.doclets.toolkit.builders;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Simple class to represent the attribute and elements of an XML node.
 *
 *  <p><b>This is NOT part of any supported API.
 *  If you write code that depends on this, you do so at your own risk.
 *  This code and its internal interfaces are subject to change or
 *  deletion without notice.</b>
 */
public class XMLNode {
    XMLNode(XMLNode parent, String qname) {
        this.parent = parent;
        name = qname;
        attrs = new HashMap<>();
        children = new ArrayList<>();

        if (parent != null)
            parent.children.add(this);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("<");
        sb.append(name);
        for (Map.Entry<String,String> e: attrs.entrySet())
            sb.append(" " + e.getKey() + "=\"" + e.getValue() + "\"");
        if (children.size() == 0)
            sb.append("/>");
        else {
            sb.append(">");
            for (XMLNode c: children)
                sb.append(c.toString());
            sb.append("</" + name + ">");
        }
        return sb.toString();
    }

    final XMLNode parent;
    final String name;
    final Map<String,String> attrs;
    final List<XMLNode> children;
}
