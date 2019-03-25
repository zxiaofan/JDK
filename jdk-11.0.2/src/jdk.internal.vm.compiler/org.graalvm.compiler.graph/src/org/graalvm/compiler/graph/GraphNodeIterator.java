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

/**
 * Iterates over the nodes in a given graph.
 */
class GraphNodeIterator implements Iterator<Node> {

    private final Graph graph;
    private int index;

    GraphNodeIterator(Graph graph) {
        this(graph, 0);
    }

    GraphNodeIterator(Graph graph, int index) {
        this.graph = graph;
        this.index = index - 1;
        forward();
    }

    private void forward() {
        if (index < graph.nodesSize) {
            do {
                index++;
            } while (index < graph.nodesSize && graph.nodes[index] == null);
        }
    }

    @Override
    public boolean hasNext() {
        checkForDeletedNode();
        return index < graph.nodesSize;
    }

    private void checkForDeletedNode() {
        while (index < graph.nodesSize && graph.nodes[index] == null) {
            index++;
        }
    }

    @Override
    public Node next() {
        try {
            return graph.nodes[index];
        } finally {
            forward();
        }
    }

    @Override
    public void remove() {
        throw new UnsupportedOperationException();
    }
}
