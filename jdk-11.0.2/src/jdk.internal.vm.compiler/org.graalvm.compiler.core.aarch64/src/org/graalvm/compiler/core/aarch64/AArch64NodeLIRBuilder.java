/*
 * Copyright (c) 2015, Oracle and/or its affiliates. All rights reserved.
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



package org.graalvm.compiler.core.aarch64;

import org.graalvm.compiler.core.gen.NodeLIRBuilder;
import org.graalvm.compiler.lir.gen.LIRGeneratorTool;
import org.graalvm.compiler.nodes.StructuredGraph;
import org.graalvm.compiler.nodes.ValueNode;

/**
 * This class implements the AArch64 specific portion of the LIR generator.
 */
public abstract class AArch64NodeLIRBuilder extends NodeLIRBuilder {

    public AArch64NodeLIRBuilder(StructuredGraph graph, LIRGeneratorTool lirGen, AArch64NodeMatchRules nodeMatchRules) {
        super(graph, lirGen, nodeMatchRules);
    }

    @Override
    protected boolean peephole(ValueNode valueNode) {
        // No peephole optimizations for now
        return false;
    }

    @Override
    public AArch64LIRGenerator getLIRGeneratorTool() {
        return (AArch64LIRGenerator) super.getLIRGeneratorTool();
    }

    @Override
    protected void emitPrologue(StructuredGraph graph) {
        // XXX Maybe we need something like this.
        // getLIRGeneratorTool().emitLoadConstantTableBase();
        super.emitPrologue(graph);
    }
}
