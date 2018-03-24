/*
 * Copyright (c) 2005, 2013, Oracle and/or its affiliates. All rights reserved.
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

package com.sun.xml.internal.stream.buffer.sax;

import org.xml.sax.SAXException;
import org.xml.sax.ext.LexicalHandler;
import org.xml.sax.helpers.DefaultHandler;

public class DefaultWithLexicalHandler extends DefaultHandler implements LexicalHandler {

    public void comment(char[] ch, int start, int length) throws SAXException { }

    public void startDTD(String name, String publicId, String systemId) throws SAXException { }

    public void endDTD() throws SAXException { }

    public void startEntity(String name) throws SAXException { }

    public void endEntity(String name) throws SAXException { }

    public void startCDATA() throws SAXException { }

    public void endCDATA() throws SAXException { }

}
