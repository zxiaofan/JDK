/*
 * Copyright (c) 2013, 2018, Oracle and/or its affiliates. All rights reserved.
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


package org.graalvm.compiler.lir.amd64.vector;

import org.graalvm.compiler.asm.amd64.AMD64MacroAssembler;
import org.graalvm.compiler.asm.amd64.AMD64VectorAssembler;
import org.graalvm.compiler.lir.LIRInstructionClass;
import org.graalvm.compiler.lir.amd64.AMD64LIRInstruction;
import org.graalvm.compiler.lir.asm.CompilationResultBuilder;

public abstract class AMD64VectorLIRInstruction extends AMD64LIRInstruction {
    public static final LIRInstructionClass<AMD64VectorLIRInstruction> TYPE = LIRInstructionClass.create(AMD64VectorLIRInstruction.class);

    protected AMD64VectorLIRInstruction(LIRInstructionClass<? extends AMD64LIRInstruction> c) {
        super(c);
    }

    @Override
    public final void emitCode(CompilationResultBuilder crb, AMD64MacroAssembler masm) {
        emitCode(crb, (AMD64VectorAssembler) masm);
    }

    public abstract void emitCode(CompilationResultBuilder crb, AMD64VectorAssembler vasm);
}
