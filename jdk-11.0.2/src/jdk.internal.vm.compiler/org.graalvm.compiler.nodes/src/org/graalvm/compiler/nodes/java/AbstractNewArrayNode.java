/*
 * Copyright (c) 2009, 2011, Oracle and/or its affiliates. All rights reserved.
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


package org.graalvm.compiler.nodes.java;

import org.graalvm.compiler.core.common.type.Stamp;
import org.graalvm.compiler.graph.NodeClass;
import org.graalvm.compiler.nodeinfo.NodeInfo;
import org.graalvm.compiler.nodes.FrameState;
import org.graalvm.compiler.nodes.ValueNode;
import org.graalvm.compiler.nodes.spi.ArrayLengthProvider;

/**
 * The {@code AbstractNewArrayNode} is used for all 1-dimensional array allocations.
 */
@NodeInfo
public abstract class AbstractNewArrayNode extends AbstractNewObjectNode implements ArrayLengthProvider {

    public static final NodeClass<AbstractNewArrayNode> TYPE = NodeClass.create(AbstractNewArrayNode.class);
    @Input protected ValueNode length;

    public ValueNode length() {
        return length;
    }

    @Override
    public ValueNode findLength(ArrayLengthProvider.FindLengthMode mode) {
        return length;
    }

    protected AbstractNewArrayNode(NodeClass<? extends AbstractNewArrayNode> c, Stamp stamp, ValueNode length, boolean fillContents, FrameState stateBefore) {
        super(c, stamp, fillContents, stateBefore);
        this.length = length;
    }

    /**
     * The list of node which produce input for this instruction.
     */
    public ValueNode dimension(int index) {
        assert index == 0;
        return length();
    }

    /**
     * The rank of the array allocated by this node, i.e. how many array dimensions.
     */
    public int dimensionCount() {
        return 1;
    }
}
