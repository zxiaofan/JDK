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


package org.graalvm.compiler.hotspot.sparc;

import static org.graalvm.compiler.lir.LIRInstruction.OperandFlag.REG;
import static jdk.vm.ci.code.ValueUtil.asRegister;
import static jdk.vm.ci.sparc.SPARC.i7;
import static jdk.vm.ci.sparc.SPARCKind.XWORD;

import org.graalvm.compiler.asm.sparc.SPARCAssembler;
import org.graalvm.compiler.asm.sparc.SPARCMacroAssembler;
import org.graalvm.compiler.lir.LIRInstructionClass;
import org.graalvm.compiler.lir.Opcode;
import org.graalvm.compiler.lir.asm.CompilationResultBuilder;
import org.graalvm.compiler.lir.sparc.SPARCLIRInstruction;

import jdk.vm.ci.code.Register;
import jdk.vm.ci.meta.AllocatableValue;

/**
 * Patch the return address of the current frame.
 */
@Opcode("PATCH_RETURN")
final class SPARCHotSpotPatchReturnAddressOp extends SPARCLIRInstruction {
    public static final LIRInstructionClass<SPARCHotSpotPatchReturnAddressOp> TYPE = LIRInstructionClass.create(SPARCHotSpotPatchReturnAddressOp.class);
    public static final SizeEstimate SIZE = SizeEstimate.create(1);

    @Use(REG) AllocatableValue address;

    SPARCHotSpotPatchReturnAddressOp(AllocatableValue address) {
        super(TYPE, SIZE);
        this.address = address;
    }

    @Override
    public void emitCode(CompilationResultBuilder crb, SPARCMacroAssembler masm) {
        Register addrRegister = asRegister(address, XWORD);
        masm.sub(addrRegister, SPARCAssembler.PC_RETURN_OFFSET, i7);
    }
}
