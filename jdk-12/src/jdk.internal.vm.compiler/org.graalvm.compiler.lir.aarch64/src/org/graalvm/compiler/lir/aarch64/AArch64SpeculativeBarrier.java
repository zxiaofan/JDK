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



package org.graalvm.compiler.lir.aarch64;

import org.graalvm.compiler.asm.aarch64.AArch64MacroAssembler;
import org.graalvm.compiler.lir.LIRInstructionClass;
import org.graalvm.compiler.lir.asm.CompilationResultBuilder;

public class AArch64SpeculativeBarrier extends AArch64LIRInstruction {
    private static final LIRInstructionClass<AArch64SpeculativeBarrier> TYPE = LIRInstructionClass.create(AArch64SpeculativeBarrier.class);

    public AArch64SpeculativeBarrier() {
        super(TYPE);
    }

    @Override
    protected void emitCode(CompilationResultBuilder crb, AArch64MacroAssembler masm) {
        masm.csdb();
    }
}
