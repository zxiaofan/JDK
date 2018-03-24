/*
 * Copyright (c) 2013, 2017, Oracle and/or its affiliates. All rights reserved.
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

import org.graalvm.compiler.asm.aarch64.AArch64MacroAssembler;
import org.graalvm.compiler.asm.aarch64.AArch64MacroAssembler.ScratchRegister;
import org.graalvm.compiler.hotspot.GraalHotSpotVMConfig;
import org.graalvm.compiler.lir.LIRInstructionClass;
import org.graalvm.compiler.lir.aarch64.AArch64BlockEndOp;
import org.graalvm.compiler.lir.asm.CompilationResultBuilder;

import jdk.vm.ci.code.Register;

/**
 * Superclass for operations that leave a method's frame.
 */
abstract class AArch64HotSpotEpilogueOp extends AArch64BlockEndOp {

    private final GraalHotSpotVMConfig config;
    private final Register thread;

    protected AArch64HotSpotEpilogueOp(LIRInstructionClass<? extends AArch64HotSpotEpilogueOp> c, GraalHotSpotVMConfig config, Register thread) {
        super(c);
        this.config = config;
        this.thread = thread;
    }

    protected AArch64HotSpotEpilogueOp(LIRInstructionClass<? extends AArch64HotSpotEpilogueOp> c, GraalHotSpotVMConfig config) {
        super(c);
        this.config = config;
        this.thread = null; // no safepoint
    }

    protected void leaveFrame(CompilationResultBuilder crb, AArch64MacroAssembler masm, boolean emitSafepoint) {
        assert crb.frameContext != null : "We never elide frames in aarch64";
        crb.frameContext.leave(crb);
        if (emitSafepoint) {
            try (ScratchRegister sc = masm.getScratchRegister()) {
                Register scratch = sc.getRegister();
                AArch64HotSpotSafepointOp.emitCode(crb, masm, config, true, thread, scratch, null);
            }
        }
    }
}
