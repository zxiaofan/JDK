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

package com.sun.tools.internal.ws.wsdl.parser;

import com.sun.tools.internal.ws.wsdl.document.jaxws.JAXWSBindingsConstants;
import com.sun.tools.internal.xjc.reader.internalizer.LocatorTable;
import com.sun.xml.internal.bind.marshaller.SAX2DOMEx;
import org.w3c.dom.Comment;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.xml.sax.Attributes;
import org.xml.sax.Locator;
import org.xml.sax.SAXException;
import org.xml.sax.ext.LexicalHandler;

import java.util.Set;

/**
 * Builds DOM while keeping the location information.
 *
 * <p>
 * This class also looks for outer most &lt;jaxws:bindings>
 * customizations.
 *
 * @author
 *     Kohsuke Kawaguchi (kohsuke.kawaguchi@sun.com)
 *     Vivek Pandey
 */
class DOMBuilder extends SAX2DOMEx implements LexicalHandler {
    /**
     * Grows a DOM tree under the given document, and
     * stores location information to the given table.
     *
     * @param outerMostBindings
     *      This set will receive newly found outermost
     *      jaxb:bindings customizations.
     */
    public DOMBuilder( Document dom, LocatorTable ltable, Set outerMostBindings ) {
        super( dom );
        this.locatorTable = ltable;
        this.outerMostBindings = outerMostBindings;
    }

    /** Location information will be stored into this object. */
    private final LocatorTable locatorTable;

    private final Set outerMostBindings;

    private Locator locator;

    public void setDocumentLocator(Locator locator) {
        this.locator = locator;
        super.setDocumentLocator(locator);
    }


    public void startElement(String namespaceURI, String localName, String qName, Attributes atts) {
        super.startElement(namespaceURI, localName, qName, atts);

        Element e = getCurrentElement();
        locatorTable.storeStartLocation( e, locator );

        // check if this element is an outer-most <jaxb:bindings>
        if( JAXWSBindingsConstants.JAXWS_BINDINGS.getNamespaceURI().equals(e.getNamespaceURI())
        &&  "bindings".equals(e.getLocalName()) ) {

            // if this is the root node (meaning that this file is an
            // external binding file) or if the parent is XML Schema element
            // (meaning that this is an "inlined" external binding)
            Node p = e.getParentNode();
            if( p instanceof Document) {
                outerMostBindings.add(e);   // remember this value
            }
        }
    }

    public void endElement(String namespaceURI, String localName, String qName) {
        locatorTable.storeEndLocation( getCurrentElement(), locator );
        super.endElement(namespaceURI, localName, qName);
    }

    public void startDTD(String name, String publicId, String systemId) throws SAXException {}

    public void endDTD() throws SAXException {}

    public void startEntity(String name) throws SAXException {}

    public void endEntity(String name) throws SAXException {}

    public void startCDATA() throws SAXException {}

    public void endCDATA() throws SAXException {}

    public void comment(char[] ch, int start, int length) throws SAXException {
        //Element e = getCurrentElement(); // does not work as the comments at the top of the document would return Document Node
        // instead of Element
        Node parent = nodeStack.peek();
        Comment comment = document.createComment(new String(ch,start,length));
        parent.appendChild(comment);
    }
}
