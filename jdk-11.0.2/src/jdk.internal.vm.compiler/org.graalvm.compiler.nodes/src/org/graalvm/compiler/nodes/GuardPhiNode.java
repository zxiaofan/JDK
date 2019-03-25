/*
 * Copyright (c) 2009, 2014, Oracle and/or its affiliates. All rights reserved.
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
import org.graalvm.compiler.graph.NodeClass;
import org.graalvm.compiler.graph.NodeInputList;
import org.graalvm.compiler.nodeinfo.InputType;
import org.graalvm.compiler.nodeinfo.NodeInfo;
import org.graalvm.compiler.nodes.extended.GuardingNode;

/**
 * Guard {@link PhiNode}s merge guard dependencies at control flow merges.
 */
@NodeInfo(nameTemplate = "GuardPhi({i#values})", allowedUsageTypes = {InputType.Guard})
public final class GuardPhiNode extends PhiNode implements GuardingNode {

    public static final NodeClass<GuardPhiNode> TYPE = NodeClass.create(GuardPhiNode.class);
    @OptionalInput(InputType.Guard) NodeInputList<ValueNode> values;

    public GuardPhiNode(AbstractMergeNode merge) {
        super(TYPE, StampFactory.forVoid(), merge);
        this.values = new NodeInputList<>(this);
    }

    public GuardPhiNode(AbstractMergeNode merge, ValueNode[] values) {
        super(TYPE, StampFactory.forVoid(), merge);
        this.values = new NodeInputList<>(this, values);
    }

    @Override
    public NodeInputList<ValueNode> values() {
        return values;
    }
}
