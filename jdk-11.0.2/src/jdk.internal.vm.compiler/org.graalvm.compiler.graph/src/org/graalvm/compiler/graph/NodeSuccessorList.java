/*
 * Copyright (c) 2011, Oracle and/or its affiliates. All rights reserved.
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

import static org.graalvm.compiler.graph.Edges.Type.Successors;

import java.util.List;

import org.graalvm.compiler.graph.Edges.Type;

public final class NodeSuccessorList<T extends Node> extends NodeList<T> {

    public NodeSuccessorList(Node self, int initialSize) {
        super(self, initialSize);
    }

    protected NodeSuccessorList(Node self) {
        super(self);
    }

    public NodeSuccessorList(Node self, T[] elements) {
        super(self, elements);
        assert self.hasNoUsages();
    }

    public NodeSuccessorList(Node self, List<? extends T> elements) {
        super(self, elements);
        assert self.hasNoUsages();
    }

    @Override
    protected void update(T oldNode, T newNode) {
        self.updatePredecessor(oldNode, newNode);
    }

    @Override
    public Type getEdgesType() {
        return Successors;
    }
}
