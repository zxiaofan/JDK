/*
 * Copyright (c) 2013, 2014, Oracle and/or its affiliates. All rights reserved.
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


package org.graalvm.compiler.lir.sparc;

import org.graalvm.compiler.asm.sparc.SPARCMacroAssembler;
import org.graalvm.compiler.lir.LIRInstruction;

/**
 * Implementors of this interface are able to place its last instruction into the delay slot of a
 * {@link SPARCDelayedControlTransfer} instruction.
 *
 * The implementor has to do following steps to emit code into the delay slot for the
 * DelayedControlTransfer instruction:
 * <ol>
 * <li>Emit everything up to the second last instruction.</li>
 * <li>Call
 * {@link SPARCDelayedControlTransfer#emitControlTransfer(org.graalvm.compiler.lir.asm.CompilationResultBuilder, SPARCMacroAssembler)}
 * to let the DelayedControlTransfer instruction emit its own code (But must not stuff the delay
 * slot with Nop)</li>
 * <li>emit the last instruction for this {@link LIRInstruction}</li>
 * </ol>
 *
 * Note: If this instruction decides not to use the delay slot, it can skip the call of
 * {@link SPARCDelayedControlTransfer#emitControlTransfer(org.graalvm.compiler.lir.asm.CompilationResultBuilder, SPARCMacroAssembler)}
 * . The DelayedControlTransfer instruction will emit the code just with Nop in the delay slot.
 */
public interface SPARCTailDelayedLIRInstruction extends SPARCLIRInstructionMixin {
    default void setDelayedControlTransfer(SPARCDelayedControlTransfer holder) {
        getSPARCLIRInstructionStore().delayedControlTransfer = holder;
    }

    default SPARCDelayedControlTransfer getDelayedControlTransfer() {
        return getSPARCLIRInstructionStore().delayedControlTransfer;
    }
}
