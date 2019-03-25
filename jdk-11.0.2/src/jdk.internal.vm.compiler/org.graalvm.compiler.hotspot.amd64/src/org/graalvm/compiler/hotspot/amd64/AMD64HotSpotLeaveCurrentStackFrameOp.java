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


package org.graalvm.compiler.hotspot.amd64;

import static jdk.vm.ci.amd64.AMD64.rdx;

import org.graalvm.compiler.asm.amd64.AMD64Address;
import org.graalvm.compiler.asm.amd64.AMD64MacroAssembler;
import org.graalvm.compiler.lir.LIRInstructionClass;
import org.graalvm.compiler.lir.Opcode;
import org.graalvm.compiler.lir.StandardOp.SaveRegistersOp;
import org.graalvm.compiler.lir.asm.CompilationResultBuilder;
import org.graalvm.compiler.lir.framemap.FrameMap;

import jdk.vm.ci.code.Register;
import jdk.vm.ci.code.RegisterConfig;
import jdk.vm.ci.code.RegisterSaveLayout;
import jdk.vm.ci.meta.JavaKind;

/**
 * Pops the current frame off the stack including the return address and restores the return
 * registers stored on the stack.
 */
@Opcode("LEAVE_CURRENT_STACK_FRAME")
final class AMD64HotSpotLeaveCurrentStackFrameOp extends AMD64HotSpotEpilogueOp {

    public static final LIRInstructionClass<AMD64HotSpotLeaveCurrentStackFrameOp> TYPE = LIRInstructionClass.create(AMD64HotSpotLeaveCurrentStackFrameOp.class);

    private final SaveRegistersOp saveRegisterOp;

    AMD64HotSpotLeaveCurrentStackFrameOp(SaveRegistersOp saveRegisterOp) {
        super(TYPE);
        this.saveRegisterOp = saveRegisterOp;
    }

    @Override
    public void emitCode(CompilationResultBuilder crb, AMD64MacroAssembler masm) {
        FrameMap frameMap = crb.frameMap;
        RegisterConfig registerConfig = frameMap.getRegisterConfig();
        RegisterSaveLayout registerSaveLayout = saveRegisterOp.getMap(frameMap);
        Register stackPointer = registerConfig.getFrameRegister();

        // Restore integer result register.
        final int stackSlotSize = frameMap.getTarget().wordSize;
        Register integerResultRegister = registerConfig.getReturnRegister(JavaKind.Long);
        masm.movptr(integerResultRegister, new AMD64Address(stackPointer, registerSaveLayout.registerToSlot(integerResultRegister) * stackSlotSize));
        masm.movptr(rdx, new AMD64Address(stackPointer, registerSaveLayout.registerToSlot(rdx) * stackSlotSize));

        // Restore float result register.
        Register floatResultRegister = registerConfig.getReturnRegister(JavaKind.Double);
        masm.movdbl(floatResultRegister, new AMD64Address(stackPointer, registerSaveLayout.registerToSlot(floatResultRegister) * stackSlotSize));

        /*
         * All of the register save area will be popped of the stack. Only the return address
         * remains.
         */
        leaveFrameAndRestoreRbp(crb, masm);

        // Remove return address.
        masm.addq(stackPointer, crb.target.arch.getReturnAddressSize());
    }
}
