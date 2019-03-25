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


package org.graalvm.compiler.nodes;

import org.graalvm.compiler.core.common.type.Stamp;
import org.graalvm.compiler.graph.NodeClass;
import org.graalvm.compiler.nodeinfo.NodeInfo;

@NodeInfo
public abstract class FixedNode extends ValueNode implements FixedNodeInterface {
    public static final NodeClass<FixedNode> TYPE = NodeClass.create(FixedNode.class);

    protected FixedNode(NodeClass<? extends FixedNode> c, Stamp stamp) {
        super(c, stamp);
    }

    @Override
    public boolean verify() {
        assertTrue(this.successors().isNotEmpty() || this.predecessor() != null, "FixedNode should not float");
        return super.verify();
    }

    @Override
    public FixedNode asNode() {
        return this;
    }
}
