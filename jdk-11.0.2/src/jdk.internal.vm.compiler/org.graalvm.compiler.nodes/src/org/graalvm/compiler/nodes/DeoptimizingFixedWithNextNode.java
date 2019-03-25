/*
 * Copyright (c) 2013, 2014, Oracle and/or its affiliates. All rights reserved.
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

@NodeInfo
public abstract class DeoptimizingFixedWithNextNode extends FixedWithNextNode implements DeoptimizingNode.DeoptBefore {

    public static final NodeClass<DeoptimizingFixedWithNextNode> TYPE = NodeClass.create(DeoptimizingFixedWithNextNode.class);
    @OptionalInput(InputType.State) protected FrameState stateBefore;

    protected DeoptimizingFixedWithNextNode(NodeClass<? extends DeoptimizingFixedWithNextNode> c, Stamp stamp) {
        super(c, stamp);
    }

    protected DeoptimizingFixedWithNextNode(NodeClass<? extends DeoptimizingFixedWithNextNode> c, Stamp stamp, FrameState stateBefore) {
        super(c, stamp);
        this.stateBefore = stateBefore;
    }

    @Override
    public FrameState stateBefore() {
        return stateBefore;
    }

    @Override
    public void setStateBefore(FrameState f) {
        updateUsages(stateBefore, f);
        stateBefore = f;
    }
}
