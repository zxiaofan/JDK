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



package org.graalvm.compiler.lir.aarch64;

import org.graalvm.compiler.asm.aarch64.AArch64MacroAssembler;
import org.graalvm.compiler.lir.LIRInstruction;
import org.graalvm.compiler.lir.LIRInstructionClass;
import org.graalvm.compiler.lir.StandardOp.BlockEndOp;
import org.graalvm.compiler.lir.asm.CompilationResultBuilder;

public abstract class AArch64BlockEndOp extends LIRInstruction implements BlockEndOp {

    public static final LIRInstructionClass<AArch64BlockEndOp> TYPE = LIRInstructionClass.create(AArch64BlockEndOp.class);

    protected AArch64BlockEndOp(LIRInstructionClass<? extends AArch64BlockEndOp> c) {
        super(c);
    }

    @Override
    public final void emitCode(CompilationResultBuilder crb) {
        emitCode(crb, (AArch64MacroAssembler) crb.asm);
    }

    protected abstract void emitCode(CompilationResultBuilder crb, AArch64MacroAssembler masm);
}
