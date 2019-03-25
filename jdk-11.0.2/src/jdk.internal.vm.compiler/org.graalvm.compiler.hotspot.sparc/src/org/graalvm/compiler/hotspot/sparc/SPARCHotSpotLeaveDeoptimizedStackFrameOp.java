/*
 * Copyright (c) 2014, 2015, Oracle and/or its affiliates. All rights reserved.
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

import static jdk.vm.ci.sparc.SPARC.i0;
import static jdk.vm.ci.sparc.SPARC.i1;
import static jdk.vm.ci.sparc.SPARC.i2;
import static jdk.vm.ci.sparc.SPARC.i3;
import static jdk.vm.ci.sparc.SPARC.i4;
import static jdk.vm.ci.sparc.SPARC.o0;
import static jdk.vm.ci.sparc.SPARC.o1;
import static jdk.vm.ci.sparc.SPARC.o2;
import static jdk.vm.ci.sparc.SPARC.o3;
import static jdk.vm.ci.sparc.SPARC.o4;

import org.graalvm.compiler.asm.sparc.SPARCMacroAssembler;
import org.graalvm.compiler.lir.LIRInstructionClass;
import org.graalvm.compiler.lir.Opcode;
import org.graalvm.compiler.lir.asm.CompilationResultBuilder;
import org.graalvm.compiler.lir.sparc.SPARCLIRInstruction;

/**
 * Pops the current frame off the stack including the return address.
 */
@Opcode("LEAVE_DEOPTIMIZED_STACK_FRAME")
final class SPARCHotSpotLeaveDeoptimizedStackFrameOp extends SPARCLIRInstruction {

    public static final LIRInstructionClass<SPARCHotSpotLeaveDeoptimizedStackFrameOp> TYPE = LIRInstructionClass.create(SPARCHotSpotLeaveDeoptimizedStackFrameOp.class);

    protected SPARCHotSpotLeaveDeoptimizedStackFrameOp() {
        super(TYPE);
    }

    @Override
    public void emitCode(CompilationResultBuilder crb, SPARCMacroAssembler masm) {
        // Save O registers over restore.
        masm.mov(o0, i0);
        masm.mov(o1, i1);
        masm.mov(o2, i2);
        masm.mov(o3, i3);
        masm.mov(o4, i4);

        masm.restoreWindow();
    }

    @Override
    public boolean leavesRegisterWindow() {
        return true;
    }
}
