/*
 * Copyright (c) 2013, Oracle and/or its affiliates. All rights reserved.
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

import org.graalvm.compiler.core.common.type.Stamp;
import org.graalvm.compiler.graph.NodeClass;
import org.graalvm.compiler.nodeinfo.InputType;
import org.graalvm.compiler.nodeinfo.NodeInfo;
import org.graalvm.compiler.nodes.calc.FloatingNode;
import org.graalvm.compiler.nodes.extended.GuardedNode;
import org.graalvm.compiler.nodes.extended.GuardingNode;

@NodeInfo
public abstract class FloatingGuardedNode extends FloatingNode implements GuardedNode {
    public static final NodeClass<FloatingGuardedNode> TYPE = NodeClass.create(FloatingGuardedNode.class);

    @OptionalInput(InputType.Guard) protected GuardingNode guard;

    protected FloatingGuardedNode(NodeClass<? extends FloatingGuardedNode> c, Stamp stamp) {
        super(c, stamp);
    }

    protected FloatingGuardedNode(NodeClass<? extends FloatingGuardedNode> c, Stamp stamp, GuardingNode guard) {
        super(c, stamp);
        this.guard = guard;
    }

    @Override
    public GuardingNode getGuard() {
        return guard;
    }

    @Override
    public void setGuard(GuardingNode guard) {
        updateUsagesInterface(this.guard, guard);
        this.guard = guard;
    }
}
