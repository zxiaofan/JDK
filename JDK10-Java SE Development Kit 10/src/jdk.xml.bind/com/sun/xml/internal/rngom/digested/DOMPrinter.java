/*
 * Copyright (c) 2005, 2012, Oracle and/or its affiliates. All rights reserved.
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
/*
 * Copyright (C) 2004-2011
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */
package com.sun.xml.internal.rngom.digested;

import org.w3c.dom.Attr;
import org.w3c.dom.CDATASection;
import org.w3c.dom.Comment;
import org.w3c.dom.Document;
import org.w3c.dom.DocumentFragment;
import org.w3c.dom.Element;
import org.w3c.dom.EntityReference;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.w3c.dom.ProcessingInstruction;
import org.w3c.dom.Text;

import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamWriter;

/**
 * Printer of DOM to XML using StAX {@link XMLStreamWriter}.
 *
 * @author <A href="mailto:demakov@ispras.ru">Alexey Demakov</A>
 */
class DOMPrinter {
    protected XMLStreamWriter out;

    public DOMPrinter(XMLStreamWriter out) {
        this.out = out;
    }

    public void print(Node node) throws XMLStreamException {
        switch (node.getNodeType()) {
        case Node.DOCUMENT_NODE:
            visitDocument((Document) node);
            break;
        case Node.DOCUMENT_FRAGMENT_NODE:
            visitDocumentFragment((DocumentFragment) node);
            break;
        case Node.ELEMENT_NODE:
            visitElement((Element) node);
            break;
        case Node.TEXT_NODE:
            visitText((Text) node);
            break;
        case Node.CDATA_SECTION_NODE:
            visitCDATASection((CDATASection) node);
            break;
        case Node.PROCESSING_INSTRUCTION_NODE:
            visitProcessingInstruction((ProcessingInstruction) node);
            break;
        case Node.ENTITY_REFERENCE_NODE:
            visitReference((EntityReference) node);
            break;
        case Node.COMMENT_NODE:
            visitComment((Comment) node);
            break;
        case Node.DOCUMENT_TYPE_NODE:
            break;
        case Node.ATTRIBUTE_NODE:
        case Node.ENTITY_NODE:
        default:
            throw new XMLStreamException("Unexpected DOM Node Type "
                + node.getNodeType()
            );
        }
    }

    protected void visitChildren(Node node)
        throws XMLStreamException {
        NodeList nodeList = node.getChildNodes();
        if (nodeList != null) {
            for (int i = 0; i < nodeList.getLength(); i++) {
                print(nodeList.item(i));
            }
        }
    }

    protected void visitDocument(Document document)
        throws XMLStreamException {
        out.writeStartDocument();
        print(document.getDocumentElement());
        out.writeEndDocument();
    }

    protected void visitDocumentFragment(DocumentFragment documentFragment)
        throws XMLStreamException {
        visitChildren(documentFragment);
    }

    protected void visitElement(Element node)
        throws XMLStreamException {
        out.writeStartElement(node.getPrefix()
            , node.getLocalName()
            , node.getNamespaceURI()
        );
        NamedNodeMap attrs = node.getAttributes();
        for (int i = 0; i < attrs.getLength(); i++) {
            visitAttr((Attr) attrs.item(i));
        }
        visitChildren(node);
        out.writeEndElement();
    }

    protected void visitAttr(Attr node)
        throws XMLStreamException {
        String name = node.getLocalName();
        if (name.equals("xmlns")) {
            out.writeDefaultNamespace(node.getNamespaceURI());
        } else {
            String prefix = node.getPrefix();
            if (prefix != null && prefix.equals("xmlns")) {
                out.writeNamespace(prefix, node.getNamespaceURI());
            } else if (prefix != null) {
                out.writeAttribute(prefix
                    , node.getNamespaceURI()
                    , name
                    , node.getNodeValue()
                );
            } else {
                out.writeAttribute(node.getNamespaceURI()
                        , name
                        , node.getNodeValue());
            }
        }
    }

    protected void visitComment(Comment comment) throws XMLStreamException {
        out.writeComment(comment.getData());
    }

    protected void visitText(Text node) throws XMLStreamException {
        out.writeCharacters(node.getNodeValue());
    }

    protected void visitCDATASection(CDATASection cdata) throws XMLStreamException {
        out.writeCData(cdata.getNodeValue());
    }

    protected void visitProcessingInstruction(ProcessingInstruction processingInstruction)
        throws XMLStreamException {
        out.writeProcessingInstruction(processingInstruction.getNodeName()
            , processingInstruction.getData()
        );
    }

    protected void visitReference(EntityReference entityReference)
        throws XMLStreamException {
        visitChildren(entityReference);
    }
}
