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


package org.graalvm.compiler.hotspot.aarch64;

import static jdk.vm.ci.aarch64.AArch64.sp;
import static jdk.vm.ci.code.ValueUtil.asRegister;
import static jdk.vm.ci.hotspot.aarch64.AArch64HotSpotRegisterConfig.fp;
import static org.graalvm.compiler.lir.LIRInstruction.OperandFlag.REG;

import org.graalvm.compiler.asm.Label;
import org.graalvm.compiler.asm.aarch64.AArch64Address;
import org.graalvm.compiler.asm.aarch64.AArch64MacroAssembler;
import org.graalvm.compiler.asm.aarch64.AArch64MacroAssembler.ScratchRegister;
import org.graalvm.compiler.hotspot.GraalHotSpotVMConfig;
import org.graalvm.compiler.lir.LIRInstructionClass;
import org.graalvm.compiler.lir.Opcode;
import org.graalvm.compiler.lir.asm.CompilationResultBuilder;
import org.graalvm.compiler.serviceprovider.GraalServices;

import jdk.vm.ci.code.Register;
import jdk.vm.ci.meta.AllocatableValue;

/**
 * Sets up the arguments for an exception handler in the callers frame, removes the current frame
 * and jumps to the handler.
 */
@Opcode("JUMP_TO_EXCEPTION_HANDLER_IN_CALLER")
public class AArch64HotSpotJumpToExceptionHandlerInCallerOp extends AArch64HotSpotEpilogueOp {

    public static final LIRInstructionClass<AArch64HotSpotJumpToExceptionHandlerInCallerOp> TYPE = LIRInstructionClass.create(AArch64HotSpotJumpToExceptionHandlerInCallerOp.class);

    @Use(REG) private AllocatableValue handlerInCallerPc;
    @Use(REG) private AllocatableValue exception;
    @Use(REG) private AllocatableValue exceptionPc;
    private final Register thread;
    private final int isMethodHandleReturnOffset;

    public AArch64HotSpotJumpToExceptionHandlerInCallerOp(AllocatableValue handlerInCallerPc, AllocatableValue exception, AllocatableValue exceptionPc, int isMethodHandleReturnOffset,
                    Register thread, GraalHotSpotVMConfig config) {
        super(TYPE, config);
        this.handlerInCallerPc = handlerInCallerPc;
        this.exception = exception;
        this.exceptionPc = exceptionPc;
        this.isMethodHandleReturnOffset = isMethodHandleReturnOffset;
        this.thread = thread;
    }

    @Override
    public void emitCode(CompilationResultBuilder crb, AArch64MacroAssembler masm) {
        leaveFrame(crb, masm, /* emitSafepoint */false, false);

        if (GraalServices.JAVA_SPECIFICATION_VERSION < 8) {
            // Restore sp from fp if the exception PC is a method handle call site.
            try (ScratchRegister sc = masm.getScratchRegister()) {
                Register scratch = sc.getRegister();
                final boolean allowOverwrite = false;
                AArch64Address address = masm.makeAddress(thread, isMethodHandleReturnOffset, scratch, 4, allowOverwrite);
                masm.ldr(32, scratch, address);
                Label noRestore = new Label();
                masm.cbz(32, scratch, noRestore);
                masm.mov(64, sp, fp);
                masm.bind(noRestore);
            }
        }

        masm.jmp(asRegister(handlerInCallerPc));
    }
}
