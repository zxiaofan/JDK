/*
 * Copyright (c) 2018, Oracle and/or its affiliates. All rights reserved.
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
import org.graalvm.compiler.nodes.LogicNode;
import org.graalvm.compiler.nodes.NodeView;
import org.graalvm.compiler.nodes.ValueNode;
import org.graalvm.compiler.nodes.spi.VirtualizerTool;
import jdk.internal.vm.compiler.word.LocationIdentity;

import jdk.vm.ci.meta.JavaKind;

/**
 * Represents an atomic compare-and-swap operation. The result is the current value of the memory
 * location that was compared.
 */
@NodeInfo
public final class UnsafeCompareAndExchangeNode extends AbstractUnsafeCompareAndSwapNode {

    public static final NodeClass<UnsafeCompareAndExchangeNode> TYPE = NodeClass.create(UnsafeCompareAndExchangeNode.class);

    public UnsafeCompareAndExchangeNode(ValueNode object, ValueNode offset, ValueNode expected, ValueNode newValue, JavaKind valueKind, LocationIdentity locationIdentity) {
        super(TYPE, meetInputs(expected.stamp(NodeView.DEFAULT), newValue.stamp(NodeView.DEFAULT)), object, offset, expected, newValue, valueKind, locationIdentity);
    }

    private static Stamp meetInputs(Stamp expected, Stamp newValue) {
        assert expected.isCompatible(newValue);
        return expected.unrestricted().meet(newValue.unrestricted());
    }

    @Override
    protected void finishVirtualize(VirtualizerTool tool, LogicNode equalsNode, ValueNode currentValue) {
        tool.replaceWith(currentValue);
    }
}
