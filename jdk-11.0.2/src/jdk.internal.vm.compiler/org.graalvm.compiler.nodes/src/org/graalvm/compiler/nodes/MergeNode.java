/*
 * Copyright (c) 2009, 2015, Oracle and/or its affiliates. All rights reserved.
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


package org.graalvm.compiler.nodes;

import org.graalvm.compiler.graph.NodeClass;
import org.graalvm.compiler.nodeinfo.NodeInfo;

/**
 * Denotes the merging of multiple control-flow paths.
 */
@NodeInfo
public final class MergeNode extends AbstractMergeNode {

    public static final NodeClass<MergeNode> TYPE = NodeClass.create(MergeNode.class);

    public MergeNode() {
        super(TYPE);
    }

    public static void removeMergeIfDegenerated(MergeNode node) {
        if (node.forwardEndCount() == 1 && node.hasNoUsages()) {
            FixedNode currentNext = node.next();
            node.setNext(null);
            EndNode forwardEnd = node.forwardEndAt(0);
            forwardEnd.replaceAtPredecessor(currentNext);
            node.markDeleted();
            forwardEnd.markDeleted();
        }
    }

    @Override
    public boolean verify() {
        assertTrue(this.forwardEndCount() > 1, "Must merge more than one end.");
        return true;
    }
}
