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


package org.graalvm.compiler.nodes.java;

import static org.graalvm.compiler.nodeinfo.NodeCycles.CYCLES_8;
import static org.graalvm.compiler.nodeinfo.NodeSize.SIZE_8;

import org.graalvm.compiler.core.common.type.StampFactory;
import org.graalvm.compiler.core.common.type.TypeReference;
import org.graalvm.compiler.graph.NodeClass;
import org.graalvm.compiler.graph.NodeInputList;
import org.graalvm.compiler.graph.NodeList;
import org.graalvm.compiler.nodeinfo.NodeInfo;
import org.graalvm.compiler.nodes.DeoptimizingFixedWithNextNode;
import org.graalvm.compiler.nodes.ValueNode;
import org.graalvm.compiler.nodes.spi.ArrayLengthProvider;
import org.graalvm.compiler.nodes.spi.Lowerable;
import org.graalvm.compiler.nodes.spi.LoweringTool;

import jdk.vm.ci.meta.ResolvedJavaType;

/**
 * The {@code NewMultiArrayNode} represents an allocation of a multi-dimensional object array.
 */
@NodeInfo(cycles = CYCLES_8, size = SIZE_8)
public class NewMultiArrayNode extends DeoptimizingFixedWithNextNode implements Lowerable, ArrayLengthProvider {

    public static final NodeClass<NewMultiArrayNode> TYPE = NodeClass.create(NewMultiArrayNode.class);
    @Input protected NodeInputList<ValueNode> dimensions;
    protected final ResolvedJavaType type;

    public ValueNode dimension(int index) {
        return dimensions.get(index);
    }

    public int dimensionCount() {
        return dimensions.size();
    }

    public NodeList<ValueNode> dimensions() {
        return dimensions;
    }

    public NewMultiArrayNode(ResolvedJavaType type, ValueNode[] dimensions) {
        this(TYPE, type, dimensions);
    }

    protected NewMultiArrayNode(NodeClass<? extends NewMultiArrayNode> c, ResolvedJavaType type, ValueNode[] dimensions) {
        super(c, StampFactory.objectNonNull(TypeReference.createExactTrusted(type)));
        this.type = type;
        this.dimensions = new NodeInputList<>(this, dimensions);
        assert dimensions.length > 0 && type.isArray();
    }

    @Override
    public void lower(LoweringTool tool) {
        tool.getLowerer().lower(this, tool);
    }

    public ResolvedJavaType type() {
        return type;
    }

    @Override
    public boolean canDeoptimize() {
        return true;
    }

    @Override
    public ValueNode findLength(ArrayLengthProvider.FindLengthMode mode) {
        return dimension(0);
    }
}
