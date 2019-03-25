/*
 * Copyright (c) 2013, 2015, Oracle and/or its affiliates. All rights reserved.
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


package org.graalvm.compiler.nodes.virtual;

import org.graalvm.compiler.graph.NodeClass;
import org.graalvm.compiler.nodeinfo.NodeInfo;
import org.graalvm.compiler.nodes.FixedNode;
import org.graalvm.compiler.nodes.ValueNode;
import org.graalvm.compiler.nodes.extended.BoxNode;

import org.graalvm.compiler.nodes.spi.VirtualizerTool;
import jdk.vm.ci.meta.JavaKind;
import jdk.vm.ci.meta.ResolvedJavaType;

@NodeInfo
public class VirtualBoxingNode extends VirtualInstanceNode {

    public static final NodeClass<VirtualBoxingNode> TYPE = NodeClass.create(VirtualBoxingNode.class);
    protected final JavaKind boxingKind;

    public VirtualBoxingNode(ResolvedJavaType type, JavaKind boxingKind) {
        this(TYPE, type, boxingKind);
    }

    public VirtualBoxingNode(NodeClass<? extends VirtualBoxingNode> c, ResolvedJavaType type, JavaKind boxingKind) {
        super(c, type, false);
        this.boxingKind = boxingKind;
    }

    public JavaKind getBoxingKind() {
        return boxingKind;
    }

    @Override
    public VirtualBoxingNode duplicate() {
        VirtualBoxingNode node = new VirtualBoxingNode(type(), boxingKind);
        node.setNodeSourcePosition(this.getNodeSourcePosition());
        return node;
    }

    @Override
    public ValueNode getMaterializedRepresentation(FixedNode fixed, ValueNode[] entries, LockState locks) {
        assert entries.length == 1;
        assert locks == null;

        BoxNode node = new BoxNode(entries[0], type(), boxingKind);
        node.setNodeSourcePosition(this.getNodeSourcePosition());
        return node;
    }

    public ValueNode getBoxedValue(VirtualizerTool tool) {
        return tool.getEntry(this, 0);
    }
}
