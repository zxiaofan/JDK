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

import static org.graalvm.compiler.graph.Edges.Type.Successors;

import java.util.ArrayList;

import org.graalvm.compiler.graph.NodeClass.EdgeInfo;

public final class SuccessorEdges extends Edges {

    public SuccessorEdges(int directCount, ArrayList<EdgeInfo> edges) {
        super(Successors, directCount, edges);
    }

    @Override
    public void update(Node node, Node oldValue, Node newValue) {
        node.updatePredecessor(oldValue, newValue);
    }
}
