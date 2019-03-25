/*
 * Copyright (c) 2011, 2015, Oracle and/or its affiliates. All rights reserved.
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

import org.graalvm.compiler.core.common.NumUtil;
import org.graalvm.compiler.asm.sparc.SPARCMacroAssembler;
import org.graalvm.compiler.lir.LIRInstruction;
import org.graalvm.compiler.lir.LIRInstructionClass;
import org.graalvm.compiler.lir.asm.CompilationResultBuilder;

import jdk.vm.ci.meta.JavaConstant;

/**
 * Convenience class to provide SPARCMacroAssembler for the {@link #emitCode} method.
 */
public abstract class SPARCLIRInstruction extends LIRInstruction implements SPARCLIRInstructionMixin {
    public static final LIRInstructionClass<SPARCLIRInstruction> TYPE = LIRInstructionClass.create(SPARCLIRInstruction.class);
    private final SPARCLIRInstructionMixinStore store;

    protected SPARCLIRInstruction(LIRInstructionClass<? extends LIRInstruction> c) {
        this(c, null);
    }

    protected SPARCLIRInstruction(LIRInstructionClass<? extends LIRInstruction> c, SizeEstimate size) {
        super(c);
        store = new SPARCLIRInstructionMixinStore(size);
    }

    @Override
    public void emitCode(CompilationResultBuilder crb) {
        emitCode(crb, (SPARCMacroAssembler) crb.asm);
    }

    protected abstract void emitCode(CompilationResultBuilder crb, SPARCMacroAssembler masm);

    @Override
    public SPARCLIRInstructionMixinStore getSPARCLIRInstructionStore() {
        return store;
    }

    protected static int asImmediate(JavaConstant value) {
        if (value.isNull()) {
            return 0;
        } else {
            long val = value.asLong();
            assert NumUtil.isInt(val);
            return (int) val;
        }
    }
}
