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
import static org.graalvm.compiler.lir.LIRInstruction.OperandFlag.STACK;
import static jdk.vm.ci.sparc.SPARC.g0;
import static jdk.vm.ci.sparc.SPARCKind.XWORD;

import org.graalvm.compiler.asm.sparc.SPARCAddress;
import org.graalvm.compiler.asm.sparc.SPARCMacroAssembler;
import org.graalvm.compiler.core.common.LIRKind;
import org.graalvm.compiler.lir.LIRInstructionClass;
import org.graalvm.compiler.lir.Opcode;
import org.graalvm.compiler.lir.asm.CompilationResultBuilder;
import org.graalvm.compiler.lir.sparc.SPARCDelayedControlTransfer;
import org.graalvm.compiler.lir.sparc.SPARCLIRInstruction;
import org.graalvm.compiler.lir.sparc.SPARCMove;

import jdk.vm.ci.code.Register;
import jdk.vm.ci.meta.Value;

@Opcode("CRUNTIME_CALL_EPILOGUE")
final class SPARCHotSpotCRuntimeCallEpilogueOp extends SPARCLIRInstruction {
    public static final LIRInstructionClass<SPARCHotSpotCRuntimeCallEpilogueOp> TYPE = LIRInstructionClass.create(SPARCHotSpotCRuntimeCallEpilogueOp.class);
    public static final SizeEstimate SIZE = SizeEstimate.create(11);

    private final int threadLastJavaSpOffset;
    private final int threadLastJavaPcOffset;
    private final int threadJavaFrameAnchorFlagsOffset;
    private final Register thread;
    @Use({REG, STACK}) protected Value threadTemp;

    SPARCHotSpotCRuntimeCallEpilogueOp(int threadLastJavaSpOffset, int threadLastJavaPcOffset, int threadJavaFrameAnchorFlagsOffset, Register thread, Value threadTemp) {
        super(TYPE, SIZE);
        this.threadLastJavaSpOffset = threadLastJavaSpOffset;
        this.threadLastJavaPcOffset = threadLastJavaPcOffset;
        this.threadJavaFrameAnchorFlagsOffset = threadJavaFrameAnchorFlagsOffset;
        this.thread = thread;
        this.threadTemp = threadTemp;
    }

    @Override
    public void emitCode(CompilationResultBuilder crb, SPARCMacroAssembler masm) {

        // Restore the thread register when coming back from the runtime.
        SPARCMove.move(crb, masm, thread.asValue(LIRKind.value(XWORD)), threadTemp, SPARCDelayedControlTransfer.DUMMY);

        // Reset last Java frame, last Java PC and flags.
        masm.stx(g0, new SPARCAddress(thread, threadLastJavaSpOffset));
        masm.stx(g0, new SPARCAddress(thread, threadLastJavaPcOffset));
        masm.stw(g0, new SPARCAddress(thread, threadJavaFrameAnchorFlagsOffset));
    }
}
