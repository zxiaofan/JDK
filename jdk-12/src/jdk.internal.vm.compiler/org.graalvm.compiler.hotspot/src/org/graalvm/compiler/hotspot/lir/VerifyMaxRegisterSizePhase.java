/*
 * Copyright (c) 2018, Oracle and/or its affiliates. All rights reserved.
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


package org.graalvm.compiler.hotspot.lir;

import java.util.EnumSet;

import org.graalvm.compiler.core.common.cfg.AbstractBlockBase;
import org.graalvm.compiler.lir.LIR;
import org.graalvm.compiler.lir.LIRInstruction;
import org.graalvm.compiler.lir.gen.LIRGenerationResult;
import org.graalvm.compiler.lir.phases.PostAllocationOptimizationPhase;

import jdk.vm.ci.code.TargetDescription;
import static jdk.vm.ci.code.ValueUtil.isRegister;
import jdk.vm.ci.meta.Value;
import org.graalvm.compiler.lir.LIRInstruction.OperandFlag;
import org.graalvm.compiler.lir.LIRInstruction.OperandMode;

/**
 * Checks that no registers exceed the MaxVectorSize flag from the VM config.
 */
public final class VerifyMaxRegisterSizePhase extends PostAllocationOptimizationPhase {

    private final int maxVectorSize;

    public VerifyMaxRegisterSizePhase(int maxVectorSize) {
        this.maxVectorSize = maxVectorSize;
    }

    @Override
    protected void run(TargetDescription target, LIRGenerationResult lirGenRes, PostAllocationOptimizationContext context) {
        LIR lir = lirGenRes.getLIR();
        for (AbstractBlockBase<?> block : lir.getControlFlowGraph().getBlocks()) {
            verifyBlock(lir, block);
        }
    }

    protected void verifyBlock(LIR lir, AbstractBlockBase<?> block) {
        for (LIRInstruction inst : lir.getLIRforBlock(block)) {
            verifyInstruction(inst);
        }
    }

    protected void verifyInstruction(LIRInstruction inst) {
        inst.visitEachInput(this::verifyOperands);
        inst.visitEachOutput(this::verifyOperands);
        inst.visitEachAlive(this::verifyOperands);
        inst.visitEachTemp(this::verifyOperands);
    }

    @SuppressWarnings("unused")
    protected void verifyOperands(LIRInstruction instruction, Value value, OperandMode mode, EnumSet<OperandFlag> flags) {
        if (isRegister(value)) {
            assert value.getPlatformKind().getSizeInBytes() <= maxVectorSize : "value " + value + " exceeds MaxVectorSize " + maxVectorSize;
        }
    }
}
