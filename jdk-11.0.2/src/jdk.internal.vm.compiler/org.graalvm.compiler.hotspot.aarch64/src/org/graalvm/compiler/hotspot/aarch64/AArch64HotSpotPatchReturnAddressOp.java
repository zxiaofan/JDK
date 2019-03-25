/*
 * Copyright (c) 2016, Oracle and/or its affiliates. All rights reserved.
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


package org.graalvm.compiler.hotspot.aarch64;

import static org.graalvm.compiler.lir.LIRInstruction.OperandFlag.REG;
import static jdk.vm.ci.aarch64.AArch64.sp;
import static jdk.vm.ci.code.ValueUtil.asRegister;

import org.graalvm.compiler.asm.aarch64.AArch64Address;
import org.graalvm.compiler.asm.aarch64.AArch64MacroAssembler;
import org.graalvm.compiler.lir.LIRInstructionClass;
import org.graalvm.compiler.lir.Opcode;
import org.graalvm.compiler.lir.aarch64.AArch64LIRInstruction;
import org.graalvm.compiler.lir.asm.CompilationResultBuilder;

import jdk.vm.ci.meta.AllocatableValue;

/**
 * Patch the return address of the current frame.
 */
@Opcode("PATCH_RETURN")
final class AArch64HotSpotPatchReturnAddressOp extends AArch64LIRInstruction {

    public static final LIRInstructionClass<AArch64HotSpotPatchReturnAddressOp> TYPE = LIRInstructionClass.create(AArch64HotSpotPatchReturnAddressOp.class);

    @Use(REG) AllocatableValue address;

    AArch64HotSpotPatchReturnAddressOp(AllocatableValue address) {
        super(TYPE);
        this.address = address;
    }

    @Override
    public void emitCode(CompilationResultBuilder crb, AArch64MacroAssembler masm) {
        final int frameSize = crb.frameMap.frameSize();
        // LR is saved in the {fp, lr} pair above the frame
        AArch64Address lrAddress = AArch64Address.createUnscaledImmediateAddress(sp,
                        frameSize + crb.target.wordSize);
        masm.str(64, asRegister(address), lrAddress);
    }
}
