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

import org.graalvm.compiler.graph.Node;
import org.graalvm.compiler.graph.NodeClass;
import org.graalvm.compiler.graph.spi.Canonicalizable;
import org.graalvm.compiler.graph.spi.CanonicalizerTool;
import org.graalvm.compiler.nodeinfo.NodeInfo;
import org.graalvm.compiler.nodes.spi.LIRLowerable;
import org.graalvm.compiler.nodes.spi.Lowerable;
import org.graalvm.compiler.nodes.spi.LoweringTool;
import org.graalvm.compiler.nodes.spi.NodeLIRBuilderTool;

import jdk.vm.ci.meta.JavaConstant;
import jdk.vm.ci.meta.MetaAccessProvider;

@NodeInfo
public final class DynamicDeoptimizeNode extends AbstractDeoptimizeNode implements LIRLowerable, Lowerable, Canonicalizable {
    public static final NodeClass<DynamicDeoptimizeNode> TYPE = NodeClass.create(DynamicDeoptimizeNode.class);
    @Input ValueNode actionAndReason;
    @Input ValueNode speculation;

    public DynamicDeoptimizeNode(ValueNode actionAndReason, ValueNode speculation) {
        super(TYPE, null);
        this.actionAndReason = actionAndReason;
        this.speculation = speculation;
    }

    public ValueNode getActionAndReason() {
        return actionAndReason;
    }

    public ValueNode getSpeculation() {
        return speculation;
    }

    @Override
    public ValueNode getActionAndReason(MetaAccessProvider metaAccess) {
        return getActionAndReason();
    }

    @Override
    public ValueNode getSpeculation(MetaAccessProvider metaAccess) {
        return getSpeculation();
    }

    @Override
    public void lower(LoweringTool tool) {
        tool.getLowerer().lower(this, tool);
    }

    @Override
    public void generate(NodeLIRBuilderTool generator) {
        generator.getLIRGeneratorTool().emitDeoptimize(generator.operand(actionAndReason), generator.operand(speculation), generator.state(this));
    }

    @Override
    public Node canonical(CanonicalizerTool tool) {
        if (actionAndReason.isConstant() && speculation.isConstant()) {
            JavaConstant constant = actionAndReason.asJavaConstant();
            JavaConstant speculationConstant = speculation.asJavaConstant();
            DeoptimizeNode newDeopt = new DeoptimizeNode(tool.getMetaAccess().decodeDeoptAction(constant), tool.getMetaAccess().decodeDeoptReason(constant), tool.getMetaAccess().decodeDebugId(
                            constant), tool.getMetaAccess().decodeSpeculation(speculationConstant, graph().getSpeculationLog()), stateBefore());
            return newDeopt;
        }
        return this;
    }
}
