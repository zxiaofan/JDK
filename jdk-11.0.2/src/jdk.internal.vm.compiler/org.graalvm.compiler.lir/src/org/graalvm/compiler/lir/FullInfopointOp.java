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


package org.graalvm.compiler.lir;

import org.graalvm.compiler.lir.asm.CompilationResultBuilder;

import jdk.vm.ci.code.site.InfopointReason;

/**
 * Emits an infopoint (only mark the position).
 */
@Opcode("INFOPOINT")
public final class FullInfopointOp extends LIRInstruction {
    public static final LIRInstructionClass<FullInfopointOp> TYPE = LIRInstructionClass.create(FullInfopointOp.class);

    @State protected LIRFrameState state;

    private final InfopointReason reason;

    public FullInfopointOp(LIRFrameState state, InfopointReason reason) {
        super(TYPE);
        this.state = state;
        this.reason = reason;
    }

    @Override
    public void emitCode(CompilationResultBuilder crb) {
        crb.recordInfopoint(crb.asm.position(), state, reason);
        crb.asm.ensureUniquePC();
    }
}
