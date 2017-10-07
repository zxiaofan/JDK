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

package com.sun.xml.internal.bind.v2.runtime.unmarshaller;

import javax.xml.namespace.NamespaceContext;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;

/**
 * {@link XmlVisitor} decorator that interns all string tokens.
 *
 * @author Kohsuke Kawaguchi
 */
public final class InterningXmlVisitor implements XmlVisitor {
    private final XmlVisitor next;

    private final AttributesImpl attributes = new AttributesImpl();

    public InterningXmlVisitor(XmlVisitor next) {
        this.next = next;
    }

    public void startDocument(LocatorEx locator, NamespaceContext nsContext) throws SAXException {
        next.startDocument(locator,nsContext);
    }

    public void endDocument() throws SAXException {
        next.endDocument();
    }

    public void startElement(TagName tagName ) throws SAXException {
        attributes.setAttributes(tagName.atts);
        tagName.atts = attributes;
        tagName.uri = intern(tagName.uri);
        tagName.local = intern(tagName.local);
        next.startElement(tagName);
    }

    public void endElement(TagName tagName ) throws SAXException {
        tagName.uri = intern(tagName.uri);
        tagName.local = intern(tagName.local);
        next.endElement(tagName);
    }

    public void startPrefixMapping( String prefix, String nsUri ) throws SAXException {
        next.startPrefixMapping(intern(prefix),intern(nsUri));
    }

    public void endPrefixMapping( String prefix ) throws SAXException {
        next.endPrefixMapping(intern(prefix));
    }

    public void text( CharSequence pcdata ) throws SAXException {
        next.text(pcdata);
    }

    public UnmarshallingContext getContext() {
        return next.getContext();
    }

    public TextPredictor getPredictor() {
        return next.getPredictor();
    }

    private static class AttributesImpl implements Attributes {
        private Attributes core;

        void setAttributes(Attributes att) {
            this.core = att;
        }

        public int getIndex(String qName) {
            return core.getIndex(qName);
        }

        public int getIndex(String uri, String localName) {
            return core.getIndex(uri, localName);
        }

        public int getLength() {
            return core.getLength();
        }

        public String getLocalName(int index) {
            return intern(core.getLocalName(index));
        }

        public String getQName(int index) {
            return intern(core.getQName(index));
        }

        public String getType(int index) {
            return intern(core.getType(index));
        }

        public String getType(String qName) {
            return intern(core.getType(qName));
        }

        public String getType(String uri, String localName) {
            return intern(core.getType(uri, localName));
        }

        public String getURI(int index) {
            return intern(core.getURI(index));
        }

        //
        // since values may vary a lot,
        // we don't (probably shouldn't) intern values.
        //

        public String getValue(int index) {
            return core.getValue(index);
        }

        public String getValue(String qName) {
            return core.getValue(qName);
        }

        public String getValue(String uri, String localName) {
            return core.getValue(uri, localName);
        }
    }

    private static String intern(String s) {
        if(s==null)     return null;
        else            return s.intern();
    }
}
