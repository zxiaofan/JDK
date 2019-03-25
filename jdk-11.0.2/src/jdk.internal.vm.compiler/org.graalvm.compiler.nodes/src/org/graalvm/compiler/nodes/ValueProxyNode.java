/*
 * Copyright (c) 2012, 2015, Oracle and/or its affiliates. All rights reserved.
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

import org.graalvm.compiler.graph.Node;
import org.graalvm.compiler.graph.NodeClass;
import org.graalvm.compiler.graph.spi.Canonicalizable;
import org.graalvm.compiler.graph.spi.CanonicalizerTool;
import org.graalvm.compiler.nodeinfo.NodeInfo;
import org.graalvm.compiler.nodes.extended.GuardingNode;
import org.graalvm.compiler.nodes.spi.ValueProxy;
import org.graalvm.compiler.nodes.spi.Virtualizable;
import org.graalvm.compiler.nodes.spi.VirtualizerTool;
import org.graalvm.compiler.nodes.virtual.VirtualObjectNode;

@NodeInfo(nameTemplate = "Proxy({i#value})")
public final class ValueProxyNode extends ProxyNode implements Canonicalizable, Virtualizable, ValueProxy {

    public static final NodeClass<ValueProxyNode> TYPE = NodeClass.create(ValueProxyNode.class);
    @Input ValueNode value;
    private final boolean loopPhiProxy;

    public ValueProxyNode(ValueNode value, LoopExitNode loopExit) {
        super(TYPE, value.stamp(NodeView.DEFAULT), loopExit);
        this.value = value;
        loopPhiProxy = loopExit.loopBegin().isPhiAtMerge(value);
    }

    @Override
    public ValueNode value() {
        return value;
    }

    @Override
    public boolean inferStamp() {
        return updateStamp(value.stamp(NodeView.DEFAULT));
    }

    @Override
    public Node canonical(CanonicalizerTool tool) {
        ValueNode curValue = value;
        if (curValue.isConstant()) {
            return curValue;
        }
        if (loopPhiProxy && !loopExit.loopBegin().isPhiAtMerge(curValue)) {
            return curValue;
        }
        return this;
    }

    @Override
    public void virtualize(VirtualizerTool tool) {
        ValueNode alias = tool.getAlias(value);
        if (alias instanceof VirtualObjectNode) {
            tool.replaceWithVirtual((VirtualObjectNode) alias);
        }
    }

    @Override
    public ValueNode getOriginalNode() {
        return value();
    }

    @Override
    public GuardingNode getGuard() {
        return this.proxyPoint();
    }
}
