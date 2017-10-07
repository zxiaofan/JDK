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

package com.sun.xml.internal.xsom.impl.parser.state;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;

/**
 *
 *
 * @author Kohsuke Kawaguchi (kk@kohsuke.org)
 */
public interface NGCCEventReceiver {
    void enterElement(String uri, String localName, String qname,Attributes atts) throws SAXException;
    void leaveElement(String uri, String localName, String qname) throws SAXException;
    void text(String value) throws SAXException;
    void enterAttribute(String uri, String localName, String qname) throws SAXException;
    void leaveAttribute(String uri, String localName, String qname) throws SAXException;
}
