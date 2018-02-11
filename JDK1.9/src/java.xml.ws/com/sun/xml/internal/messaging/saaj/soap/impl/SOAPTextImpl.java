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
import org.w3c.dom.CharacterData;
import org.w3c.dom.DOMException;
import org.w3c.dom.Text;

public class SOAPTextImpl extends TextImpl<Text> implements Text {

    public SOAPTextImpl(SOAPDocumentImpl ownerDoc, String text) {
        super(ownerDoc, text);
    }

    public SOAPTextImpl(SOAPDocumentImpl ownerDoc, CharacterData data) {
        super(ownerDoc, data);
    }

    @Override
    protected Text createN(SOAPDocumentImpl ownerDoc, String text) {
        Text t = ownerDoc.getDomDocument().createTextNode(text);
//        ownerDoc.register(this);
        return t;
    }

    @Override
    protected Text createN(SOAPDocumentImpl ownerDoc, CharacterData data) {
        Text t = (Text) data;
        return t;
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
        String txt = getNodeValue();
        if (txt == null) {
            return false;
        }
        return txt.startsWith("<!--") && txt.endsWith("-->");
    }

}
