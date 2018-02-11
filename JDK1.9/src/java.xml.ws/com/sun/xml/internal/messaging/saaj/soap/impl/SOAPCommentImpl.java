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

import org.w3c.dom.CharacterData;
import org.w3c.dom.Comment;
import org.w3c.dom.DOMException;
import org.w3c.dom.Text;

import com.sun.xml.internal.messaging.saaj.soap.SOAPDocumentImpl;
import static com.sun.xml.internal.messaging.saaj.soap.impl.TextImpl.log;

public class SOAPCommentImpl extends TextImpl<Comment> implements Comment {

    public SOAPCommentImpl(SOAPDocumentImpl ownerDoc, String text) {
        super(ownerDoc, text);
    }

    public SOAPCommentImpl(SOAPDocumentImpl ownerDoc, CharacterData data) {
        super(ownerDoc, data);
    }

    @Override
    protected Comment createN(SOAPDocumentImpl ownerDoc, String text) {
        Comment c = ownerDoc.getDomDocument().createComment(text);
//        ownerDoc.register(this);
        return c;
    }

    @Override
    protected Comment createN(SOAPDocumentImpl ownerDoc, CharacterData data) {
        Comment c = (Comment) data;
        return c;
    }

    @Override
    public boolean isComment() {
        return true;
    }

    @Override
    public Text splitText(int offset) throws DOMException {
        log.severe("SAAJ0113.impl.cannot.split.text.from.comment");
        throw new UnsupportedOperationException("Cannot split text from a Comment Node.");
    }

    @Override
    public Text replaceWholeText(String content) throws DOMException {
        log.severe("SAAJ0114.impl.cannot.replace.wholetext.from.comment");
        throw new UnsupportedOperationException("Cannot replace Whole Text from a Comment Node.");
    }

    @Override
    public String getWholeText() {
        //TODO: maybe we have to implement this in future.
        throw new UnsupportedOperationException("Not Supported");
    }

    @Override
    public boolean isElementContentWhitespace() {
        //TODO: maybe we have to implement this in future.
        throw new UnsupportedOperationException("Not Supported");
    }

}
