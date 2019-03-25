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

import static org.graalvm.compiler.graph.Edges.Type.Inputs;

import java.util.Collection;
import java.util.List;

import org.graalvm.compiler.graph.Edges.Type;

public final class NodeInputList<T extends Node> extends NodeList<T> {

    public NodeInputList(Node self, int initialSize) {
        super(self, initialSize);
    }

    public NodeInputList(Node self) {
        super(self);
    }

    public NodeInputList(Node self, T[] elements) {
        super(self, elements);
        assert self.hasNoUsages();
    }

    public NodeInputList(Node self, List<? extends T> elements) {
        super(self, elements);
        assert self.hasNoUsages();
    }

    public NodeInputList(Node self, Collection<? extends NodeInterface> elements) {
        super(self, elements);
        assert self.hasNoUsages();
    }

    @Override
    protected void update(T oldNode, T newNode) {
        self.updateUsages(oldNode, newNode);
    }

    @Override
    public Type getEdgesType() {
        return Inputs;
    }
}
