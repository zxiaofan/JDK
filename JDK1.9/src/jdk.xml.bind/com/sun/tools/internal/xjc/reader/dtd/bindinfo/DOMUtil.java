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

package com.sun.tools.internal.xjc.reader.dtd.bindinfo;

import java.util.ArrayList;
import java.util.List;

import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

/**
 * @author Kohsuke Kawaguchi
 */
public final class DOMUtil {
    final static String getAttribute(Element e,String attName) {
        if(e.getAttributeNode(attName)==null)   return null;
        return e.getAttribute(attName);
    }

    public static String getAttribute(Element e, String nsUri, String local) {
        if(e.getAttributeNodeNS(nsUri,local)==null) return null;
        return e.getAttributeNS(nsUri,local);
    }

    public static Element getElement(Element e, String nsUri, String localName) {
        NodeList l = e.getChildNodes();
        for(int i=0;i<l.getLength();i++) {
            Node n = l.item(i);
            if(n.getNodeType()==Node.ELEMENT_NODE) {
                Element r = (Element)n;
                if(equals(r.getLocalName(),localName) && equals(fixNull(r.getNamespaceURI()),nsUri))
                    return r;
            }
        }
        return null;
    }

    /**
     * Used for defensive string comparisons, as many DOM methods often return null
     * depending on how they are created.
     */
    private static boolean equals(String a,String b) {
        if(a==b)    return true;
        if(a==null || b==null)  return false;
        return a.equals(b);
    }

    /**
     * DOM API returns null for the default namespace whereas it should return "".
     */
    private static String fixNull(String s) {
        if(s==null) return "";
        else        return s;
    }

    public static Element getElement(Element e, String localName) {
        return getElement(e,"",localName);
    }

    public static List<Element> getChildElements(Element e) {
        List<Element> r = new ArrayList<Element>();
        NodeList l = e.getChildNodes();
        for(int i=0;i<l.getLength();i++) {
            Node n = l.item(i);
            if(n.getNodeType()==Node.ELEMENT_NODE)
                r.add((Element)n);
        }
        return r;
    }

    public static List<Element> getChildElements(Element e,String localName) {
        List<Element> r = new ArrayList<Element>();
        NodeList l = e.getChildNodes();
        for(int i=0;i<l.getLength();i++) {
            Node n = l.item(i);
            if(n.getNodeType()==Node.ELEMENT_NODE) {
                Element c = (Element)n;
                if(c.getLocalName().equals(localName))
                    r.add(c);
            }
        }
        return r;
    }
}
