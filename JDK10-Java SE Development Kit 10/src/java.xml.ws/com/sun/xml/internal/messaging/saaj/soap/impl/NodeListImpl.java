/*
 * Copyright (c) 2017, Oracle and/or its affiliates. All rights reserved.
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
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import java.util.Objects;

/**
 * Node list wrapper, finding SOAP elements automatically when possible.
 *
 * @author Roman Grigoriadi
 */
public class NodeListImpl implements NodeList {

    private final SOAPDocumentImpl soapDocument;

    private final NodeList nodeList;

    public NodeListImpl(SOAPDocumentImpl soapDocument, NodeList nodeList) {
        Objects.requireNonNull(soapDocument);
        Objects.requireNonNull(soapDocument);
        this.soapDocument = soapDocument;
        this.nodeList = nodeList;
    }

    @Override
    public Node item(int index) {
        return soapDocument.findIfPresent(nodeList.item(index));
    }

    @Override
    public int getLength() {
        return nodeList.getLength();
    }
}
