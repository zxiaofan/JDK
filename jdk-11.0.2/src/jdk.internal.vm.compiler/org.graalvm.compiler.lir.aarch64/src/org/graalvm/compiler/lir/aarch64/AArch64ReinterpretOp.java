/*
 * Copyright (c) 2013, 2015, Oracle and/or its affiliates. All rights reserved.
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
import org.graalvm.compiler.lir.asm.CompilationResultBuilder;

import jdk.vm.ci.aarch64.AArch64Kind;
import jdk.vm.ci.code.Register;
import jdk.vm.ci.meta.AllocatableValue;

/**
 * Instruction that reinterprets some bit pattern as a different type. It is possible to reinterpret
 * the following: - int <-> float - long <-> double
 */
public class AArch64ReinterpretOp extends AArch64LIRInstruction {
    private static final LIRInstructionClass<AArch64ReinterpretOp> TYPE = LIRInstructionClass.create(AArch64ReinterpretOp.class);

    @Def protected AllocatableValue resultValue;
    @Use protected AllocatableValue inputValue;

    public AArch64ReinterpretOp(AllocatableValue resultValue, AllocatableValue inputValue) {
        super(TYPE);
        AArch64Kind from = (AArch64Kind) inputValue.getPlatformKind();
        AArch64Kind to = (AArch64Kind) resultValue.getPlatformKind();
        assert from.getSizeInBytes() == to.getSizeInBytes() && from.isInteger() ^ to.isInteger();
        this.resultValue = resultValue;
        this.inputValue = inputValue;
    }

    @Override
    public void emitCode(CompilationResultBuilder crb, AArch64MacroAssembler masm) {
        Register result = asRegister(resultValue);
        Register input = asRegister(inputValue);
        AArch64Kind to = (AArch64Kind) resultValue.getPlatformKind();
        final int size = to.getSizeInBytes() * Byte.SIZE;
        masm.fmov(size, result, input);
    }
}
