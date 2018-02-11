/*
 * Copyright (c) 1997, 2013, Oracle and/or its affiliates. All rights reserved.
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

package com.sun.xml.internal.ws.message;

import com.sun.xml.internal.ws.api.message.Message;
import org.xml.sax.ContentHandler;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.helpers.XMLFilterImpl;

import javax.xml.transform.sax.SAXSource;

/**
 * @author Kohsuke Kawaguchi
 */
final class XMLReaderImpl extends XMLFilterImpl {

    private final Message msg;

    XMLReaderImpl(Message msg) {
        this.msg = msg;
    }

    public void parse(String systemId) {
        reportError();
    }

    private void reportError() {
        // TODO: i18n
        throw new IllegalStateException(
            "This is a special XMLReader implementation that only works with the InputSource given in SAXSource.");
    }

    public void parse(InputSource input) throws SAXException {
        if(input!=THE_SOURCE)
            reportError();
        msg.writeTo(this,this);
    }

    @Override
    public ContentHandler getContentHandler() {
        if(super.getContentHandler()==DUMMY)   return null;
        return super.getContentHandler();
    }

    @Override
    public void setContentHandler(ContentHandler contentHandler) {
        if(contentHandler==null)    contentHandler = DUMMY;
        super.setContentHandler(contentHandler);
    }

    private static final ContentHandler DUMMY = new DefaultHandler();

    /**
     * Special {@link InputSource} instance that we use to pass to {@link SAXSource}.
     */
    protected static final InputSource THE_SOURCE = new InputSource();
}
