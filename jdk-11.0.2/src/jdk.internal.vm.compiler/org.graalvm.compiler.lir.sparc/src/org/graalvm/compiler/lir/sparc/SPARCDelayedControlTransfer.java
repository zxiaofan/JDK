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
import org.graalvm.compiler.lir.asm.CompilationResultBuilder;

/**
 * This interface is used for {@link LIRInstruction}s which provide a delay slot for one instruction
 * from another {@link LIRInstruction}.
 *
 * @see SPARCTailDelayedLIRInstruction
 */
public interface SPARCDelayedControlTransfer {

    SPARCDelayedControlTransfer DUMMY = new SPARCDelayedControlTransfer() {
        @Override
        public void emitControlTransfer(CompilationResultBuilder crb, SPARCMacroAssembler masm) {
            // do nothing
        }

        @Override
        public String toString() {
            return "null";
        }

        @Override
        public void resetState() {
        }
    };

    /**
     * This method must be called, to generate the control transfer, but without any Nop in the
     * delay slot.
     *
     * @param crb
     * @param masm
     */
    void emitControlTransfer(CompilationResultBuilder crb, SPARCMacroAssembler masm);

    void resetState();
}
