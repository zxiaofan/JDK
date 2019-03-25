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


package org.graalvm.compiler.lir.sparc;

import static org.graalvm.compiler.lir.LIRInstruction.OperandFlag.REG;
import static org.graalvm.compiler.lir.LIRInstruction.OperandFlag.STACK;

import org.graalvm.compiler.asm.sparc.SPARCMacroAssembler;
import org.graalvm.compiler.lir.LIRInstructionClass;
import org.graalvm.compiler.lir.Opcode;
import org.graalvm.compiler.lir.asm.CompilationResultBuilder;

import jdk.vm.ci.meta.Value;

/**
 * Emits a breakpoint.
 */
@Opcode("BREAKPOINT")
public final class SPARCBreakpointOp extends SPARCLIRInstruction {
    public static final LIRInstructionClass<SPARCBreakpointOp> TYPE = LIRInstructionClass.create(SPARCBreakpointOp.class);
    public static final SizeEstimate SIZE = SizeEstimate.create(1);

    // historical - from hotspot src/cpu/sparc/vm
    // <sys/trap.h> promises that the system will not use traps 16-31
    // We want to use ST_BREAKPOINT here, but the debugger is confused by it.
    public static final int ST_RESERVED_FOR_USER_0 = 0x10;

    /**
     * A set of values loaded into the Java ABI parameter locations (for inspection by a debugger).
     */
    @Use({REG, STACK}) protected Value[] parameters;

    public SPARCBreakpointOp(Value[] parameters) {
        super(TYPE, SIZE);
        this.parameters = parameters;
    }

    @Override
    public void emitCode(CompilationResultBuilder crb, SPARCMacroAssembler masm) {
        masm.ta(ST_RESERVED_FOR_USER_0);
    }
}
