/*
 * Copyright (c) 2015, Oracle and/or its affiliates. All rights reserved.
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

package com.sun.org.apache.xpath.internal.jaxp;

import java.util.Iterator;
import javax.xml.xpath.XPathException;
import javax.xml.xpath.XPathNodes;
import javax.xml.xpath.XPathEvaluationResult.XPathResultType;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

/**
 * This class implements XPathNodes that represents a set of nodes selected by
 * evaluating an expression.
 */
public class XPathNodesImpl implements XPathNodes {
    Class<Node> elementType;
    NodeList nodeList = null;

    public XPathNodesImpl(NodeList nodeList, Class<Node> elementType) {
        this.nodeList = nodeList;
        this.elementType = elementType;
    }

    @Override
    public Iterator<Node> iterator() {
        return new NodeSetIterator<>(elementType);
    }

    class NodeSetIterator<E> implements Iterator<E> {
        int currentIndex;
        Class<E> elementType;
        NodeSetIterator(Class<E> elementType) {
            this.elementType = elementType;
        }
        public boolean hasNext() {
            if (nodeList != null) {
                return currentIndex < nodeList.getLength();
            }

            return false;
        }

        public E next() {
            if (nodeList != null && nodeList.getLength() > 0) {
                return elementType.cast(nodeList.item(currentIndex++));
            }
            return null;
        }
    }

    @Override
    public int size() {
        if (nodeList != null) {
            return nodeList.getLength();
        }
        return 0;
    }

    @Override
    public Node get(int index) throws XPathException {
        if (index <0 || index >= size()) {
            throw new IndexOutOfBoundsException("Index " + index + " is out of bounds");
        }
        if (nodeList != null) {
            return nodeList.item(index);
        }
        return null;
    }
}
