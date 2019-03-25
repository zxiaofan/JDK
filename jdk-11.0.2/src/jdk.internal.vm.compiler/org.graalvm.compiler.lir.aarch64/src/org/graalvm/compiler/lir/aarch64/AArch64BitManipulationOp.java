/*
 * Copyright (c) 2013, 2016, Oracle and/or its affiliates. All rights reserved.
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

import static org.graalvm.compiler.lir.LIRInstruction.OperandFlag.REG;
import static jdk.vm.ci.code.ValueUtil.asRegister;

import org.graalvm.compiler.asm.aarch64.AArch64MacroAssembler;
import org.graalvm.compiler.debug.GraalError;
import org.graalvm.compiler.lir.LIRInstructionClass;
import org.graalvm.compiler.lir.Opcode;
import org.graalvm.compiler.lir.asm.CompilationResultBuilder;

import jdk.vm.ci.code.Register;
import jdk.vm.ci.meta.AllocatableValue;

/**
 * Bit manipulation ops for ARMv8 ISA.
 */
public class AArch64BitManipulationOp extends AArch64LIRInstruction {
    public enum BitManipulationOpCode {
        CTZ,
        BSR,
        BSWP,
        CLZ,
    }

    private static final LIRInstructionClass<AArch64BitManipulationOp> TYPE = LIRInstructionClass.create(AArch64BitManipulationOp.class);

    @Opcode private final BitManipulationOpCode opcode;
    @Def protected AllocatableValue result;
    @Use({REG}) protected AllocatableValue input;

    public AArch64BitManipulationOp(BitManipulationOpCode opcode, AllocatableValue result, AllocatableValue input) {
        super(TYPE);
        this.opcode = opcode;
        this.result = result;
        this.input = input;
    }

    @Override
    public void emitCode(CompilationResultBuilder crb, AArch64MacroAssembler masm) {
        Register dst = asRegister(result);
        Register src = asRegister(input);
        final int size = input.getPlatformKind().getSizeInBytes() * Byte.SIZE;
        switch (opcode) {
            case CLZ:
                masm.clz(size, dst, src);
                break;
            case BSR:
                // BSR == <type width> - 1 - CLZ(input)
                masm.clz(size, dst, src);
                masm.neg(size, dst, dst);
                masm.add(size, dst, dst, size - 1);
                break;
            case CTZ:
                // CTZ == CLZ(rbit(input))
                masm.rbit(size, dst, src);
                masm.clz(size, dst, dst);
                break;
            case BSWP:
                masm.rev(size, dst, src);
                break;
            default:
                throw GraalError.shouldNotReachHere();
        }
    }

}
