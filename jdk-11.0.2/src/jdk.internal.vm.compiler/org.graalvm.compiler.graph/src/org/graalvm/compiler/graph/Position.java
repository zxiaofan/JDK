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

import org.graalvm.compiler.nodeinfo.InputType;

/**
 * Describes an edge slot for a {@link NodeClass}.
 */
public final class Position {

    /**
     * The edges in which this position lies.
     */
    private final Edges edges;

    /**
     * Index of the {@link Node} or {@link NodeList} field denoted by this position.
     */
    private final int index;

    /**
     * Index within a {@link NodeList} if {@link #index} denotes a {@link NodeList} field otherwise
     * {@link Node#NOT_ITERABLE}.
     */
    private final int subIndex;

    public Position(Edges edges, int index, int subIndex) {
        this.edges = edges;
        this.index = index;
        this.subIndex = subIndex;
    }

    public Node get(Node node) {
        if (index < edges.getDirectCount()) {
            return Edges.getNode(node, edges.getOffsets(), index);
        } else {
            return Edges.getNodeList(node, edges.getOffsets(), index).get(subIndex);
        }
    }

    public InputType getInputType() {
        return ((InputEdges) edges).getInputType(index);
    }

    public String getName() {
        return edges.getName(index);
    }

    public boolean isInputOptional() {
        return ((InputEdges) edges).isOptional(index);
    }

    public void set(Node node, Node value) {
        if (index < edges.getDirectCount()) {
            edges.setNode(node, index, value);
        } else {
            Edges.getNodeList(node, edges.getOffsets(), index).set(subIndex, value);
        }
    }

    public void initialize(Node node, Node value) {
        if (index < edges.getDirectCount()) {
            edges.initializeNode(node, index, value);
        } else {
            Edges.getNodeList(node, edges.getOffsets(), index).initialize(subIndex, value);
        }
    }

    @Override
    public String toString() {
        String res = edges.getType(index).getSimpleName() + ":" + edges.getName(index);
        if (subIndex != Node.NOT_ITERABLE) {
            res += "[" + subIndex + "]";
        }
        return res;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + index;
        result = prime * result + edges.hashCode();
        result = prime * result + subIndex;
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        Position other = (Position) obj;
        if (index != other.index) {
            return false;
        }
        if (edges != other.edges) {
            return false;
        }
        if (subIndex != other.subIndex) {
            return false;
        }
        return true;
    }

    /**
     * Gets the index within a {@link NodeList} if {@link #getIndex()} denotes a {@link NodeList}
     * field otherwise {@link Node#NOT_ITERABLE}.
     */
    public int getSubIndex() {
        return subIndex;
    }

    /**
     * Gets the index of the {@link Node} or {@link NodeList} field denoted by this position.
     */
    public int getIndex() {
        return index;
    }
}
