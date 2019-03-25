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

import static org.graalvm.compiler.nodeinfo.NodeCycles.CYCLES_0;
import static org.graalvm.compiler.nodeinfo.NodeSize.SIZE_0;

import java.util.Collections;

import org.graalvm.compiler.core.common.type.StampFactory;
import org.graalvm.compiler.graph.Node;
import org.graalvm.compiler.graph.NodeClass;
import org.graalvm.compiler.nodeinfo.NodeInfo;
import org.graalvm.compiler.nodes.spi.LIRLowerable;
import org.graalvm.compiler.nodes.spi.NodeLIRBuilderTool;

@NodeInfo(cycles = CYCLES_0, size = SIZE_0)
public abstract class AbstractEndNode extends FixedNode implements LIRLowerable {

    public static final NodeClass<AbstractEndNode> TYPE = NodeClass.create(AbstractEndNode.class);

    protected AbstractEndNode(NodeClass<? extends AbstractEndNode> c) {
        super(c, StampFactory.forVoid());
    }

    @Override
    public void generate(NodeLIRBuilderTool gen) {
        gen.visitEndNode(this);
    }

    public AbstractMergeNode merge() {
        return (AbstractMergeNode) usages().first();
    }

    @Override
    public boolean verify() {
        assertTrue(getUsageCount() <= 1, "at most one usage");
        return super.verify();
    }

    @Override
    public Iterable<? extends Node> cfgSuccessors() {
        AbstractMergeNode merge = merge();
        if (merge != null) {
            return Collections.singletonList(merge);
        }
        return Collections.emptyList();
    }
}
