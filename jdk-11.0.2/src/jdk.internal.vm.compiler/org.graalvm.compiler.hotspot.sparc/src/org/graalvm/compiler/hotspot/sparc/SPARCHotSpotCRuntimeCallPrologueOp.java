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


package org.graalvm.compiler.hotspot.sparc;

import static org.graalvm.compiler.lir.LIRInstruction.OperandFlag.REG;
import static org.graalvm.compiler.lir.LIRInstruction.OperandFlag.STACK;
import static jdk.vm.ci.code.ValueUtil.asRegister;
import static jdk.vm.ci.sparc.SPARC.STACK_BIAS;
import static jdk.vm.ci.sparc.SPARCKind.XWORD;

import org.graalvm.compiler.asm.sparc.SPARCAddress;
import org.graalvm.compiler.asm.sparc.SPARCMacroAssembler;
import org.graalvm.compiler.core.common.LIRKind;
import org.graalvm.compiler.lir.LIRInstructionClass;
import org.graalvm.compiler.lir.Opcode;
import org.graalvm.compiler.lir.asm.CompilationResultBuilder;
import org.graalvm.compiler.lir.sparc.SPARCLIRInstruction;
import org.graalvm.compiler.lir.sparc.SPARCMove;
import org.graalvm.compiler.lir.sparc.SPARCTailDelayedLIRInstruction;

import jdk.vm.ci.code.Register;
import jdk.vm.ci.meta.AllocatableValue;
import jdk.vm.ci.meta.Value;

@Opcode("CRUNTIME_CALL_PROLOGUE")
final class SPARCHotSpotCRuntimeCallPrologueOp extends SPARCLIRInstruction implements SPARCTailDelayedLIRInstruction {
    public static final LIRInstructionClass<SPARCHotSpotCRuntimeCallPrologueOp> TYPE = LIRInstructionClass.create(SPARCHotSpotCRuntimeCallPrologueOp.class);
    public static final SizeEstimate SIZE = SizeEstimate.create(10);

    private final int threadLastJavaSpOffset;
    private final Register thread;
    private final Register stackPointer;
    @Def({REG, STACK}) protected Value threadTemp;
    @Temp({REG}) protected AllocatableValue spScratch;

    SPARCHotSpotCRuntimeCallPrologueOp(int threadLastJavaSpOffset, Register thread, Register stackPointer, Value threadTemp, AllocatableValue spScratch) {
        super(TYPE, SIZE);
        this.threadLastJavaSpOffset = threadLastJavaSpOffset;
        this.thread = thread;
        this.stackPointer = stackPointer;
        this.threadTemp = threadTemp;
        this.spScratch = spScratch;
    }

    @Override
    public void emitCode(CompilationResultBuilder crb, SPARCMacroAssembler masm) {
        // Save last Java frame.
        Register scratchRegister = asRegister(spScratch);
        masm.add(stackPointer, STACK_BIAS, scratchRegister);
        masm.stx(scratchRegister, new SPARCAddress(thread, threadLastJavaSpOffset));

        // Save the thread register when calling out to the runtime.
        SPARCMove.move(crb, masm, threadTemp, thread.asValue(LIRKind.value(XWORD)), getDelayedControlTransfer());
    }
}
