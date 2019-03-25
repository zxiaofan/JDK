/*
 * Copyright (c) 2017, Oracle and/or its affiliates. All rights reserved.
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


package org.graalvm.compiler.nodes.calc;

import java.nio.ByteOrder;

import org.graalvm.compiler.core.common.type.StampFactory;
import org.graalvm.compiler.graph.Node;
import org.graalvm.compiler.graph.NodeClass;
import org.graalvm.compiler.graph.spi.CanonicalizerTool;
import org.graalvm.compiler.nodeinfo.NodeCycles;
import org.graalvm.compiler.nodeinfo.NodeInfo;
import org.graalvm.compiler.nodes.ConstantNode;
import org.graalvm.compiler.nodes.NodeView;
import org.graalvm.compiler.nodes.ValueNode;
import org.graalvm.compiler.nodes.spi.Lowerable;
import org.graalvm.compiler.nodes.spi.LoweringTool;

import jdk.vm.ci.meta.JavaKind;

/**
 * Produces the platform dependent first or second half of a long or double value as an int.
 */
@NodeInfo(cycles = NodeCycles.CYCLES_2)
public final class UnpackEndianHalfNode extends UnaryNode implements Lowerable {
    public static final NodeClass<UnpackEndianHalfNode> TYPE = NodeClass.create(UnpackEndianHalfNode.class);

    private final boolean firstHalf;

    protected UnpackEndianHalfNode(ValueNode value, boolean firstHalf) {
        super(TYPE, StampFactory.forKind(JavaKind.Int), value);
        assert value.getStackKind() == JavaKind.Double || value.getStackKind() == JavaKind.Long : "unexpected kind " + value.getStackKind();
        this.firstHalf = firstHalf;
    }

    @SuppressWarnings("unused")
    public static ValueNode create(ValueNode value, boolean firstHalf, NodeView view) {
        if (value.isConstant() && value.asConstant().isDefaultForKind()) {
            return ConstantNode.defaultForKind(JavaKind.Int);
        }
        return new UnpackEndianHalfNode(value, firstHalf);
    }

    public boolean isFirstHalf() {
        return firstHalf;
    }

    @Override
    public Node canonical(CanonicalizerTool tool, ValueNode forValue) {
        if (forValue.isConstant() && forValue.asConstant().isDefaultForKind()) {
            return ConstantNode.defaultForKind(stamp.getStackKind());
        }
        return this;
    }

    @Override
    public void lower(LoweringTool tool) {
        tool.getLowerer().lower(this, tool);
    }

    public void lower(ByteOrder byteOrder) {
        ValueNode result = value;
        if (value.getStackKind() == JavaKind.Double) {
            result = graph().unique(new ReinterpretNode(JavaKind.Long, value));
        }
        if ((byteOrder == ByteOrder.BIG_ENDIAN) == firstHalf) {
            result = graph().unique(new UnsignedRightShiftNode(result, ConstantNode.forInt(32, graph())));
        }
        result = IntegerConvertNode.convert(result, StampFactory.forKind(JavaKind.Int), graph(), NodeView.DEFAULT);
        replaceAtUsagesAndDelete(result);
    }
}
