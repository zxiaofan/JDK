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

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.helpers.AttributesImpl;

/**
 * Sniffs the root element name and its attributes from SAX events.
 *
 * @author Kohsuke Kawaguchi
 */
public final class RootElementSniffer extends DefaultHandler {
    private String nsUri = "##error";
    private String localName = "##error";
    private Attributes atts;

    private final boolean parseAttributes;

    public RootElementSniffer(boolean parseAttributes) {
        this.parseAttributes = parseAttributes;
    }

    public RootElementSniffer() {
        this(true);
    }

    public void startElement(String uri, String localName, String qName, Attributes a) throws SAXException {
        this.nsUri = uri;
        this.localName = localName;

        if(parseAttributes) {
            if(a.getLength()==0)    // often there's no attribute
                this.atts = EMPTY_ATTRIBUTES;
            else
                this.atts = new AttributesImpl(a);
        }

        // no need to parse any further.
        throw aSAXException;
    }

    public String getNsUri() {
        return nsUri;
    }

    public String getLocalName() {
        return localName;
    }

    public Attributes getAttributes() {
        return atts;
    }

    private static final SAXException aSAXException = new SAXException();
    private static final Attributes EMPTY_ATTRIBUTES = new AttributesImpl();
}
