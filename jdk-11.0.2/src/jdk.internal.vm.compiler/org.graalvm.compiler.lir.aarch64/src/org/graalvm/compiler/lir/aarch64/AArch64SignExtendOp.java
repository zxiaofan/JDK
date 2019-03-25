/*
 * Copyright (c) 2015, 2016, Oracle and/or its affiliates. All rights reserved.
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

import static jdk.vm.ci.code.ValueUtil.asRegister;

import org.graalvm.compiler.asm.aarch64.AArch64MacroAssembler;
import org.graalvm.compiler.lir.LIRInstructionClass;
import org.graalvm.compiler.lir.Opcode;
import org.graalvm.compiler.lir.asm.CompilationResultBuilder;

import jdk.vm.ci.code.Register;
import jdk.vm.ci.meta.AllocatableValue;

@Opcode("SIGNEXTEND")
public class AArch64SignExtendOp extends AArch64LIRInstruction {
    private static final LIRInstructionClass<AArch64SignExtendOp> TYPE = LIRInstructionClass.create(AArch64SignExtendOp.class);

    @Def protected AllocatableValue resultValue;
    @Use protected AllocatableValue inputValue;
    private final int fromBits;
    private final int toBits;

    public AArch64SignExtendOp(AllocatableValue resultValue, AllocatableValue inputValue, int fromBits, int toBits) {
        super(TYPE);
        this.resultValue = resultValue;
        this.inputValue = inputValue;
        this.fromBits = fromBits;
        this.toBits = toBits;
    }

    @Override
    public void emitCode(CompilationResultBuilder crb, AArch64MacroAssembler masm) {
        Register result = asRegister(resultValue);
        Register input = asRegister(inputValue);
        masm.sxt(toBits <= 32 ? 32 : 64, fromBits, result, input);
    }
}
