/*
 * Copyright (c) 2012, 2015, Oracle and/or its affiliates. All rights reserved.
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


package org.graalvm.compiler.lir.sparc;

import org.graalvm.compiler.asm.sparc.SPARCMacroAssembler;
import org.graalvm.compiler.lir.LIRInstructionClass;
import org.graalvm.compiler.lir.Opcode;
import org.graalvm.compiler.lir.asm.CompilationResultBuilder;

/**
 * Emits a pause.
 */
@Opcode("PAUSE")
public final class SPARCPauseOp extends SPARCLIRInstruction {
    public static final LIRInstructionClass<SPARCPauseOp> TYPE = LIRInstructionClass.create(SPARCPauseOp.class);
    public static final SizeEstimate SIZE = SizeEstimate.create(1);

    public SPARCPauseOp() {
        super(TYPE, SIZE);
    }

    @Override
    public void emitCode(CompilationResultBuilder crb, SPARCMacroAssembler masm) {
        masm.pause();
    }
}
