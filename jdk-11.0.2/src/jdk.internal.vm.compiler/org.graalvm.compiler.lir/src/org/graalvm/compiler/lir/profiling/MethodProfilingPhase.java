/*
 * Copyright (c) 2016, Oracle and/or its affiliates. All rights reserved.
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


package org.graalvm.compiler.lir.profiling;

import java.util.ArrayList;

import org.graalvm.compiler.core.common.LIRKind;
import org.graalvm.compiler.core.common.cfg.AbstractBlockBase;
import org.graalvm.compiler.lir.ConstantValue;
import org.graalvm.compiler.lir.LIR;
import org.graalvm.compiler.lir.LIRInsertionBuffer;
import org.graalvm.compiler.lir.LIRInstruction;
import org.graalvm.compiler.lir.StandardOp.BlockEndOp;
import org.graalvm.compiler.lir.StandardOp.LabelOp;
import org.graalvm.compiler.lir.gen.DiagnosticLIRGeneratorTool;
import org.graalvm.compiler.lir.gen.LIRGenerationResult;
import org.graalvm.compiler.lir.phases.PostAllocationOptimizationPhase;

import jdk.vm.ci.code.TargetDescription;
import jdk.vm.ci.meta.JavaConstant;
import jdk.vm.ci.meta.JavaKind;

public class MethodProfilingPhase extends PostAllocationOptimizationPhase {
    public static final String INVOCATION_GROUP = "METHOD_INVOCATION_COUNTER";
    public static final String ITERATION_GROUP = "METHOD_ITERATION_COUNTER";

    @Override
    protected void run(TargetDescription target, LIRGenerationResult lirGenRes, PostAllocationOptimizationContext context) {
        new Analyzer(target, lirGenRes.getCompilationUnitName(), lirGenRes.getLIR(), context.diagnosticLirGenTool).run();
    }

    private class Analyzer {
        private final LIR lir;
        private final DiagnosticLIRGeneratorTool diagnosticLirGenTool;
        private final LIRInsertionBuffer buffer;
        private final String compilationUnitName;
        private final ConstantValue increment;

        Analyzer(TargetDescription target, String compilationUnitName, LIR lir, DiagnosticLIRGeneratorTool diagnosticLirGenTool) {
            this.lir = lir;
            this.compilationUnitName = compilationUnitName;
            this.diagnosticLirGenTool = diagnosticLirGenTool;
            this.buffer = new LIRInsertionBuffer();
            this.increment = new ConstantValue(LIRKind.fromJavaKind(target.arch, JavaKind.Int), JavaConstant.INT_1);
        }

        public void run() {
            // insert counter at method entry
            doBlock(lir.getControlFlowGraph().getStartBlock(), INVOCATION_GROUP);
            for (AbstractBlockBase<?> block : lir.getControlFlowGraph().getBlocks()) {
                if (block.isLoopHeader()) {
                    // insert counter at loop header
                    doBlock(block, ITERATION_GROUP);
                }
            }
        }

        public void doBlock(AbstractBlockBase<?> block, String group) {
            ArrayList<LIRInstruction> instructions = lir.getLIRforBlock(block);
            assert instructions.size() >= 2 : "Malformed block: " + block + ", " + instructions;
            assert instructions.get(instructions.size() - 1) instanceof BlockEndOp : "Not a BlockEndOp: " + instructions.get(instructions.size() - 1);
            assert !(instructions.get(instructions.size() - 2) instanceof BlockEndOp) : "Is a BlockEndOp: " + instructions.get(instructions.size() - 2);
            assert instructions.get(0) instanceof LabelOp : "Not a LabelOp: " + instructions.get(0);
            assert !(instructions.get(1) instanceof LabelOp) : "Is a LabelOp: " + instructions.get(1);

            LIRInstruction op = diagnosticLirGenTool.createBenchmarkCounter(compilationUnitName, group, increment);
            buffer.init(instructions);
            buffer.append(1, op);
            buffer.finish();
        }
    }

}
