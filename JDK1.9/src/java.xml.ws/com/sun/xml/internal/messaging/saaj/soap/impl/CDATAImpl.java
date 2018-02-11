/*
 * Copyright (c) 1997, 2017, Oracle and/or its affiliates. All rights reserved.
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

package com.sun.xml.internal.messaging.saaj.soap.impl;

import com.sun.xml.internal.messaging.saaj.soap.SOAPDocumentImpl;
import org.w3c.dom.CDATASection;
import org.w3c.dom.CharacterData;
import org.w3c.dom.DOMException;
import org.w3c.dom.Text;

public class CDATAImpl extends TextImpl<CDATASection> implements CDATASection {

    static final String cdataUC = "<![CDATA[";
    static final String cdataLC = "<![cdata[";

    public CDATAImpl(SOAPDocumentImpl ownerDoc, String text) {
        super(ownerDoc, text);
    }

    public CDATAImpl(SOAPDocumentImpl ownerDoc, CharacterData data) {
        super(ownerDoc, data);
    }

    @Override
    protected CDATASection createN(SOAPDocumentImpl ownerDoc, String text) {
        CDATASection c = ownerDoc.getDomDocument().createCDATASection(text);
//        ownerDoc.register(this);
        return c;
    }

    @Override
    protected CDATASection createN(SOAPDocumentImpl ownerDoc, CharacterData data) {
        CDATASection c = (CDATASection) data;
        return c;
    }

    @Override
    public Text splitText(int offset) throws DOMException {
        return getDomElement().splitText(offset);
    }

    @Override
    public boolean isElementContentWhitespace() {
        return getDomElement().isElementContentWhitespace();
    }

    @Override
    public String getWholeText() {
        return getDomElement().getWholeText();
    }

    @Override
    public Text replaceWholeText(String content) throws DOMException {
        return getDomElement().replaceWholeText(content);
    }

    @Override
    public boolean isComment() {
        return false;
    }

}
