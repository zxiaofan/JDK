/*
 * Copyright (c) 2015, 2015, Oracle and/or its affiliates. All rights reserved.
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

import static org.graalvm.compiler.nodeinfo.InputType.Association;
import static org.graalvm.compiler.nodeinfo.NodeCycles.CYCLES_0;
import static org.graalvm.compiler.nodeinfo.NodeSize.SIZE_0;

import org.graalvm.compiler.graph.NodeClass;
import org.graalvm.compiler.nodeinfo.NodeInfo;
import org.graalvm.compiler.nodes.calc.FloatingNode;
import org.graalvm.compiler.nodes.extended.GuardingNode;
import org.graalvm.compiler.nodes.spi.ValueProxy;

/**
 * Proxy node that is used in OSR. This node drops the stamp information from the value, since the
 * types we see during OSR may be too precise (if a branch was not parsed for example).
 */
@NodeInfo(nameTemplate = "EntryProxy({i#value})", cycles = CYCLES_0, size = SIZE_0)
public final class EntryProxyNode extends FloatingNode implements ValueProxy {

    public static final NodeClass<EntryProxyNode> TYPE = NodeClass.create(EntryProxyNode.class);
    @Input(Association) EntryMarkerNode proxyPoint;
    @Input ValueNode value;

    public EntryProxyNode(ValueNode value, EntryMarkerNode proxyPoint) {
        super(TYPE, value.stamp(NodeView.DEFAULT).unrestricted());
        this.value = value;
        this.proxyPoint = proxyPoint;
    }

    public ValueNode value() {
        return value;
    }

    @Override
    public ValueNode getOriginalNode() {
        return value();
    }

    @Override
    public GuardingNode getGuard() {
        return proxyPoint;
    }
}
