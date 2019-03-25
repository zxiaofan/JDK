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


package org.graalvm.compiler.lir;

import java.util.ArrayList;

import org.graalvm.compiler.core.common.cfg.AbstractBlockBase;
import org.graalvm.compiler.lir.StandardOp.ImplicitNullCheck;
import org.graalvm.compiler.lir.StandardOp.NullCheck;
import org.graalvm.compiler.lir.gen.LIRGenerationResult;
import org.graalvm.compiler.lir.phases.PostAllocationOptimizationPhase;

import jdk.vm.ci.code.TargetDescription;

public final class NullCheckOptimizer extends PostAllocationOptimizationPhase {

    @Override
    protected void run(TargetDescription target, LIRGenerationResult lirGenRes, PostAllocationOptimizationContext context) {
        LIR ir = lirGenRes.getLIR();
        AbstractBlockBase<?>[] blocks = ir.codeEmittingOrder();
        NullCheckOptimizer.foldNullChecks(ir, blocks, target.implicitNullCheckLimit);
    }

    private static void foldNullChecks(LIR ir, AbstractBlockBase<?>[] blocks, int implicitNullCheckLimit) {
        for (AbstractBlockBase<?> block : blocks) {
            if (block == null) {
                continue;
            }
            ArrayList<LIRInstruction> list = ir.getLIRforBlock(block);

            if (!list.isEmpty()) {

                LIRInstruction lastInstruction = list.get(0);
                for (int i = 0; i < list.size(); i++) {
                    LIRInstruction instruction = list.get(i);

                    if (instruction instanceof ImplicitNullCheck && lastInstruction instanceof NullCheck) {
                        NullCheck nullCheck = (NullCheck) lastInstruction;
                        ImplicitNullCheck implicitNullCheck = (ImplicitNullCheck) instruction;
                        if (implicitNullCheck.makeNullCheckFor(nullCheck.getCheckedValue(), nullCheck.getState(), implicitNullCheckLimit)) {
                            list.remove(i - 1);
                            if (i < list.size()) {
                                instruction = list.get(i);
                            }
                        }
                    }
                    lastInstruction = instruction;
                }
            }
        }
    }

}
