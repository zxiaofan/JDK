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

package com.sun.tools.internal.xjc.util;

import org.xml.sax.Attributes;
import org.xml.sax.ContentHandler;
import org.xml.sax.Locator;
import org.xml.sax.SAXException;

/**
 * ContentHandler that "forks" the incoming SAX2 events to
 * two ContentHandlers.
 *
 *
 * @author  <a href="mailto:kohsuke.kawaguchi@sun.com">Kohsuke KAWAGUCHI</a>
 */
public class ForkContentHandler implements ContentHandler {

        /**
         * Creates a ForkContentHandler.
         *
         * @param first
         *     This handler will receive a SAX event first.
         * @param second
         *     This handler will receive a SAX event after the first handler
         *     receives it.
         */
        public ForkContentHandler( ContentHandler first, ContentHandler second ) {
                lhs = first;
                rhs = second;
        }

        /**
         * Creates ForkContentHandlers so that the specified handlers
         * will receive SAX events in the order of the array.
         */
        public static ContentHandler create( ContentHandler[] handlers ) {
                if(handlers.length==0)
                        throw new IllegalArgumentException();

                ContentHandler result = handlers[0];
                for( int i=1; i<handlers.length; i++ )
                        result = new ForkContentHandler( result, handlers[i] );
                return result;
        }


        private final ContentHandler lhs,rhs;

        public void setDocumentLocator (Locator locator) {
                lhs.setDocumentLocator(locator);
                rhs.setDocumentLocator(locator);
        }

        public void startDocument() throws SAXException {
                lhs.startDocument();
                rhs.startDocument();
        }

        public void endDocument () throws SAXException {
                lhs.endDocument();
                rhs.endDocument();
        }

        public void startPrefixMapping (String prefix, String uri) throws SAXException {
                lhs.startPrefixMapping(prefix,uri);
                rhs.startPrefixMapping(prefix,uri);
        }

        public void endPrefixMapping (String prefix) throws SAXException {
                lhs.endPrefixMapping(prefix);
                rhs.endPrefixMapping(prefix);
        }

        public void startElement (String uri, String localName, String qName, Attributes attributes) throws SAXException {
                lhs.startElement(uri,localName,qName,attributes);
                rhs.startElement(uri,localName,qName,attributes);
        }

        public void endElement (String uri, String localName, String qName) throws SAXException {
                lhs.endElement(uri,localName,qName);
                rhs.endElement(uri,localName,qName);
        }

        public void characters (char ch[], int start, int length) throws SAXException {
                lhs.characters(ch,start,length);
                rhs.characters(ch,start,length);
        }

        public void ignorableWhitespace (char ch[], int start, int length) throws SAXException {
                lhs.ignorableWhitespace(ch,start,length);
                rhs.ignorableWhitespace(ch,start,length);
        }

        public void processingInstruction (String target, String data) throws SAXException {
                lhs.processingInstruction(target,data);
                rhs.processingInstruction(target,data);
        }

        public void skippedEntity (String name) throws SAXException {
                lhs.skippedEntity(name);
                rhs.skippedEntity(name);
        }

}
