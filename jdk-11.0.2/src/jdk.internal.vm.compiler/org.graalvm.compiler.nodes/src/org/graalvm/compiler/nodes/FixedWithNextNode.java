/*
 * Copyright (c) 2009, 2014, Oracle and/or its affiliates. All rights reserved.
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

import org.graalvm.compiler.core.common.type.Stamp;
import org.graalvm.compiler.graph.NodeClass;
import org.graalvm.compiler.nodeinfo.NodeInfo;

/**
 * Base class of all nodes that are fixed within the control flow graph and have an immediate
 * successor.
 */
@NodeInfo
public abstract class FixedWithNextNode extends FixedNode {
    public static final NodeClass<FixedWithNextNode> TYPE = NodeClass.create(FixedWithNextNode.class);

    @Successor protected FixedNode next;

    public FixedNode next() {
        return next;
    }

    public void setNext(FixedNode x) {
        updatePredecessor(next, x);
        next = x;
    }

    public FixedWithNextNode(NodeClass<? extends FixedWithNextNode> c, Stamp stamp) {
        super(c, stamp);
    }

    @Override
    public FixedWithNextNode asNode() {
        return this;
    }
}
