/*
 * Copyright (c) 2014, Oracle and/or its affiliates. All rights reserved.
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
 */


package org.graalvm.compiler.graph;

import java.util.Iterator;
import java.util.NoSuchElementException;

class NodeUsageIterator implements Iterator<Node> {

    final Node node;
    int index = -1;
    Node current;

    void advance() {
        current = null;
        index++;
        if (index == 0) {
            current = node.usage0;
        } else if (index == 1) {
            current = node.usage1;
        } else {
            int relativeIndex = index - Node.INLINE_USAGE_COUNT;
            if (relativeIndex < node.extraUsagesCount) {
                current = node.extraUsages[relativeIndex];
            }
        }
    }

    NodeUsageIterator(Node node) {
        this.node = node;
        advance();
    }

    @Override
    public boolean hasNext() {
        return current != null;
    }

    @Override
    public Node next() {
        Node result = current;
        if (result == null) {
            throw new NoSuchElementException();
        }
        advance();
        return result;
    }

    @Override
    public void remove() {
        throw new UnsupportedOperationException();
    }
}
