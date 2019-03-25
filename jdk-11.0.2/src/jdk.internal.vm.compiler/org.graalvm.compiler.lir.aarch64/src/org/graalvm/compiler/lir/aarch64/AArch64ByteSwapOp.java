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


package org.graalvm.compiler.lir.aarch64;

import org.graalvm.compiler.asm.aarch64.AArch64MacroAssembler;
import org.graalvm.compiler.debug.GraalError;
import org.graalvm.compiler.lir.LIRInstructionClass;
import org.graalvm.compiler.lir.Opcode;
import org.graalvm.compiler.lir.asm.CompilationResultBuilder;

import jdk.vm.ci.aarch64.AArch64Kind;
import jdk.vm.ci.code.ValueUtil;
import jdk.vm.ci.meta.Value;

@Opcode("BSWAP")
public final class AArch64ByteSwapOp extends AArch64LIRInstruction {
    public static final LIRInstructionClass<AArch64ByteSwapOp> TYPE = LIRInstructionClass.create(AArch64ByteSwapOp.class);

    @Def({OperandFlag.REG, OperandFlag.HINT}) protected Value result;
    @Use protected Value input;

    public AArch64ByteSwapOp(Value result, Value input) {
        super(TYPE);
        this.result = result;
        this.input = input;
    }

    @Override
    public void emitCode(CompilationResultBuilder crb, AArch64MacroAssembler masm) {
        switch ((AArch64Kind) input.getPlatformKind()) {
            case DWORD:
                masm.rev(32, ValueUtil.asRegister(result), ValueUtil.asRegister(input));
                break;
            case QWORD:
                masm.rev(64, ValueUtil.asRegister(result), ValueUtil.asRegister(input));
                break;
            default:
                throw GraalError.shouldNotReachHere();
        }
    }
}
