/*
 * Copyright (c) 2015, 2015, Oracle and/or its affiliates. All rights reserved.
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
import org.graalvm.compiler.lir.LIRInstruction;
import org.graalvm.compiler.lir.LIRInstructionClass;
import org.graalvm.compiler.lir.StandardOp.BlockEndOp;
import org.graalvm.compiler.lir.asm.CompilationResultBuilder;

public abstract class SPARCBlockEndOp extends LIRInstruction implements BlockEndOp, SPARCLIRInstructionMixin {
    public static final LIRInstructionClass<SPARCBlockEndOp> TYPE = LIRInstructionClass.create(SPARCBlockEndOp.class);
    private final SPARCLIRInstructionMixinStore store;

    protected SPARCBlockEndOp(LIRInstructionClass<? extends SPARCBlockEndOp> c) {
        this(c, null);
    }

    protected SPARCBlockEndOp(LIRInstructionClass<? extends SPARCBlockEndOp> c, SizeEstimate sizeEstimate) {
        super(c);
        store = new SPARCLIRInstructionMixinStore(sizeEstimate);
    }

    @Override
    public SPARCLIRInstructionMixinStore getSPARCLIRInstructionStore() {
        return store;
    }

    @Override
    public void emitCode(CompilationResultBuilder crb) {
        emitCode(crb, (SPARCMacroAssembler) crb.asm);
    }

    protected abstract void emitCode(CompilationResultBuilder crb, SPARCMacroAssembler masm);
}
