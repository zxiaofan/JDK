/*
 * Copyright (c) 2013, 2016, Oracle and/or its affiliates. All rights reserved.
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

import static org.graalvm.compiler.nodeinfo.InputType.State;
import static org.graalvm.compiler.nodeinfo.NodeCycles.CYCLES_0;
import static org.graalvm.compiler.nodeinfo.NodeSize.SIZE_0;

import org.graalvm.compiler.core.common.type.StampFactory;
import org.graalvm.compiler.graph.NodeClass;
import org.graalvm.compiler.graph.spi.Simplifiable;
import org.graalvm.compiler.graph.spi.SimplifierTool;
import org.graalvm.compiler.nodeinfo.NodeInfo;
import org.graalvm.compiler.nodes.spi.LIRLowerable;
import org.graalvm.compiler.nodes.spi.NodeLIRBuilderTool;
import org.graalvm.compiler.nodes.spi.NodeWithState;

import jdk.vm.ci.code.site.InfopointReason;

/**
 * Nodes of this type are inserted into the graph to denote points of interest to debugging.
 */
@NodeInfo(cycles = CYCLES_0, size = SIZE_0)
public final class FullInfopointNode extends FixedWithNextNode implements LIRLowerable, NodeWithState, Simplifiable {
    public static final NodeClass<FullInfopointNode> TYPE = NodeClass.create(FullInfopointNode.class);
    protected final InfopointReason reason;
    @Input(State) FrameState state;
    @OptionalInput ValueNode escapedReturnValue;

    public FullInfopointNode(InfopointReason reason, FrameState state, ValueNode escapedReturnValue) {
        super(TYPE, StampFactory.forVoid());
        this.reason = reason;
        this.state = state;
        this.escapedReturnValue = escapedReturnValue;
    }

    public InfopointReason getReason() {
        return reason;
    }

    private void setEscapedReturnValue(ValueNode x) {
        updateUsages(escapedReturnValue, x);
        escapedReturnValue = x;
    }

    @Override
    public void simplify(SimplifierTool tool) {
        if (escapedReturnValue != null && state != null && state.outerFrameState() != null) {
            ValueNode returnValue = escapedReturnValue;
            setEscapedReturnValue(null);
            tool.removeIfUnused(returnValue);
        }
    }

    @Override
    public void generate(NodeLIRBuilderTool generator) {
        generator.visitFullInfopointNode(this);
    }

    public FrameState getState() {
        return state;
    }

    @Override
    public boolean verify() {
        return state != null && super.verify();
    }

}
