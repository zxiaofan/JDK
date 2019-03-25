/*
 * Copyright (c) 2012, 2013, Oracle and/or its affiliates. All rights reserved.
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

import static org.graalvm.compiler.hotspot.HotSpotHostBackend.UNCOMMON_TRAP_HANDLER;

import org.graalvm.compiler.asm.sparc.SPARCMacroAssembler;
import org.graalvm.compiler.asm.sparc.SPARCMacroAssembler.ScratchRegister;
import org.graalvm.compiler.lir.LIRInstructionClass;
import org.graalvm.compiler.lir.Opcode;
import org.graalvm.compiler.lir.asm.CompilationResultBuilder;
import org.graalvm.compiler.lir.sparc.SPARCCall;

import jdk.vm.ci.code.Register;

/**
 * Removes the current frame and tail calls the uncommon trap routine.
 */
@Opcode("DEOPT_CALLER")
final class SPARCHotSpotDeoptimizeCallerOp extends SPARCHotSpotEpilogueOp {
    public static final LIRInstructionClass<SPARCHotSpotDeoptimizeCallerOp> TYPE = LIRInstructionClass.create(SPARCHotSpotDeoptimizeCallerOp.class);
    public static final SizeEstimate SIZE = SizeEstimate.create(32);

    protected SPARCHotSpotDeoptimizeCallerOp() {
        super(TYPE, SIZE);
    }

    @Override
    public void emitCode(CompilationResultBuilder crb, SPARCMacroAssembler masm) {
        leaveFrame(crb);

        // SPARCHotSpotBackend backend = (SPARCHotSpotBackend)
        // HotSpotGraalRuntime.runtime().getBackend();
        // final boolean isStub = true;
        // HotSpotFrameContext frameContext = backend.new HotSpotFrameContext(isStub);
        // frameContext.enter(crb);

        try (ScratchRegister sc = masm.getScratchRegister()) {
            Register scratch = sc.getRegister();
            SPARCCall.indirectJmp(crb, masm, scratch, crb.foreignCalls.lookupForeignCall(UNCOMMON_TRAP_HANDLER));
        }

        // frameContext.leave(crb);
    }
}
