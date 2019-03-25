/*
 * Copyright (c) 2011, 2018, Oracle and/or its affiliates. All rights reserved.
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

import org.graalvm.compiler.core.common.type.StampFactory;
import org.graalvm.compiler.graph.NodeClass;
import org.graalvm.compiler.nodeinfo.NodeInfo;
import org.graalvm.compiler.nodes.ConstantNode;
import org.graalvm.compiler.nodes.LogicNode;
import org.graalvm.compiler.nodes.NodeView;
import org.graalvm.compiler.nodes.ValueNode;
import org.graalvm.compiler.nodes.calc.ConditionalNode;
import org.graalvm.compiler.nodes.spi.VirtualizerTool;
import jdk.internal.vm.compiler.word.LocationIdentity;

import jdk.vm.ci.meta.JavaKind;

/**
 * Represents an atomic compare-and-swap operation. The result is a boolean that contains whether
 * the value matched the expected value.
 */
@NodeInfo
public final class UnsafeCompareAndSwapNode extends AbstractUnsafeCompareAndSwapNode {

    public static final NodeClass<UnsafeCompareAndSwapNode> TYPE = NodeClass.create(UnsafeCompareAndSwapNode.class);

    public UnsafeCompareAndSwapNode(ValueNode object, ValueNode offset, ValueNode expected, ValueNode newValue, JavaKind valueKind, LocationIdentity locationIdentity) {
        super(TYPE, StampFactory.forKind(JavaKind.Boolean.getStackKind()), object, offset, expected, newValue, valueKind, locationIdentity);
        assert expected.stamp(NodeView.DEFAULT).isCompatible(newValue.stamp(NodeView.DEFAULT));
    }

    @Override
    protected void finishVirtualize(VirtualizerTool tool, LogicNode equalsNode, ValueNode currentValue) {
        ValueNode result = ConditionalNode.create(equalsNode, ConstantNode.forBoolean(true, graph()), ConstantNode.forBoolean(false, graph()), NodeView.DEFAULT);
        if (!result.isAlive()) {
            tool.addNode(result);
        }
        tool.replaceWith(result);
    }
}
