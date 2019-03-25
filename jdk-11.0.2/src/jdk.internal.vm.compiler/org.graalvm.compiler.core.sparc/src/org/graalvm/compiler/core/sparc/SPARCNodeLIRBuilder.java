/*
 * Copyright (c) 2009, 2015, Oracle and/or its affiliates. All rights reserved.
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



package org.graalvm.compiler.core.sparc;

import org.graalvm.compiler.core.gen.NodeLIRBuilder;
import org.graalvm.compiler.lir.LabelRef;
import org.graalvm.compiler.lir.StandardOp.JumpOp;
import org.graalvm.compiler.lir.gen.LIRGeneratorTool;
import org.graalvm.compiler.lir.sparc.SPARCJumpOp;
import org.graalvm.compiler.nodes.StructuredGraph;
import org.graalvm.compiler.nodes.ValueNode;

/**
 * This class implements the SPARC specific portion of the LIR generator.
 */
public abstract class SPARCNodeLIRBuilder extends NodeLIRBuilder {

    public SPARCNodeLIRBuilder(StructuredGraph graph, LIRGeneratorTool lirGen, SPARCNodeMatchRules nodeMatchRules) {
        super(graph, lirGen, nodeMatchRules);
    }

    @Override
    protected boolean peephole(ValueNode valueNode) {
        // No peephole optimizations for now
        return false;
    }

    @Override
    protected JumpOp newJumpOp(LabelRef ref) {
        return new SPARCJumpOp(ref);
    }

    @Override
    public SPARCLIRGenerator getLIRGeneratorTool() {
        return (SPARCLIRGenerator) super.getLIRGeneratorTool();
    }

    @Override
    protected void emitPrologue(StructuredGraph graph) {
        getLIRGeneratorTool().emitLoadConstantTableBase();
        super.emitPrologue(graph);
    }
}
