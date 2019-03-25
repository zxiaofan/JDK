/*
 * Copyright (c) 2012, 2014, Oracle and/or its affiliates. All rights reserved.
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

import org.graalvm.compiler.core.common.type.StampFactory;
import org.graalvm.compiler.graph.Node;
import org.graalvm.compiler.graph.NodeClass;
import org.graalvm.compiler.graph.spi.Canonicalizable;
import org.graalvm.compiler.graph.spi.CanonicalizerTool;
import org.graalvm.compiler.nodeinfo.InputType;
import org.graalvm.compiler.nodeinfo.NodeInfo;
import org.graalvm.compiler.nodes.extended.GuardingNode;
import org.graalvm.compiler.nodes.spi.LIRLowerable;
import org.graalvm.compiler.nodes.spi.NodeLIRBuilderTool;
import org.graalvm.compiler.nodes.spi.Proxy;

@NodeInfo(allowedUsageTypes = {InputType.Guard}, nameTemplate = "Proxy({i#value})")
public final class GuardProxyNode extends ProxyNode implements GuardingNode, Proxy, LIRLowerable, Canonicalizable {

    public static final NodeClass<GuardProxyNode> TYPE = NodeClass.create(GuardProxyNode.class);
    @OptionalInput(InputType.Guard) GuardingNode value;

    public GuardProxyNode(GuardingNode value, LoopExitNode proxyPoint) {
        super(TYPE, StampFactory.forVoid(), proxyPoint);
        this.value = value;
    }

    @Override
    public void generate(NodeLIRBuilderTool generator) {
    }

    public void setValue(GuardingNode newValue) {
        this.updateUsages(value.asNode(), newValue.asNode());
        this.value = newValue;
    }

    @Override
    public ValueNode value() {
        return (value == null ? null : value.asNode());
    }

    @Override
    public Node getOriginalNode() {
        return (value == null ? null : value.asNode());
    }

    @Override
    public Node canonical(CanonicalizerTool tool) {
        if (value == null) {
            return null;
        }
        return this;
    }
}
