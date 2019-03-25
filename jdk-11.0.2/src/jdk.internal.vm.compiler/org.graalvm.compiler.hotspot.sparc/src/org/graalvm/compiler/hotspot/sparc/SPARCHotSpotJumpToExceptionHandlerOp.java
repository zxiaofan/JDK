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


package org.graalvm.compiler.hotspot.sparc;

import static org.graalvm.compiler.lir.LIRInstruction.OperandFlag.REG;
import static jdk.vm.ci.code.ValueUtil.asRegister;

import org.graalvm.compiler.asm.sparc.SPARCMacroAssembler;
import org.graalvm.compiler.lir.LIRInstructionClass;
import org.graalvm.compiler.lir.Opcode;
import org.graalvm.compiler.lir.asm.CompilationResultBuilder;
import org.graalvm.compiler.lir.sparc.SPARCLIRInstruction;

import jdk.vm.ci.code.Register;
import jdk.vm.ci.meta.AllocatableValue;
import jdk.vm.ci.sparc.SPARCKind;

/**
 * Jumps to the exception handler specified by {@link #address} and leaves the current window. It
 * does not modify the i7 register, as the exception handler stub expects the throwing pc in it.
 * <p>
 * See also:
 * <li>Runtime1::generate_handle_exception c1_Runtime1_sparc.cpp
 * <li>SharedRuntime::generate_deopt_blob at exception_in_tls_offset (sharedRuntime_sparc.cpp)
 */
@Opcode("JUMP_TO_EXCEPTION_HANDLER")
final class SPARCHotSpotJumpToExceptionHandlerOp extends SPARCLIRInstruction {
    public static final LIRInstructionClass<SPARCHotSpotJumpToExceptionHandlerOp> TYPE = LIRInstructionClass.create(SPARCHotSpotJumpToExceptionHandlerOp.class);
    public static final SizeEstimate SIZE = SizeEstimate.create(2);

    @Use(REG) AllocatableValue address;

    SPARCHotSpotJumpToExceptionHandlerOp(AllocatableValue address) {
        super(TYPE, SIZE);
        this.address = address;
    }

    @Override
    public void emitCode(CompilationResultBuilder crb, SPARCMacroAssembler masm) {
        Register addrRegister = asRegister(address, SPARCKind.XWORD);
        masm.jmp(addrRegister);
        masm.restoreWindow();
    }
}
