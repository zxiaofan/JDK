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



package org.graalvm.compiler.lir.amd64;

import static org.graalvm.compiler.lir.LIRInstruction.OperandFlag.COMPOSITE;

import org.graalvm.compiler.asm.amd64.AMD64MacroAssembler;
import org.graalvm.compiler.debug.GraalError;
import org.graalvm.compiler.lir.LIRInstructionClass;
import org.graalvm.compiler.lir.asm.CompilationResultBuilder;

public final class AMD64PrefetchOp extends AMD64LIRInstruction {
    public static final LIRInstructionClass<AMD64PrefetchOp> TYPE = LIRInstructionClass.create(AMD64PrefetchOp.class);

    private final int instr;  // AllocatePrefetchInstr
    @Alive({COMPOSITE}) protected AMD64AddressValue address;

    public AMD64PrefetchOp(AMD64AddressValue address, int instr) {
        super(TYPE);
        this.address = address;
        this.instr = instr;
    }

    @Override
    public void emitCode(CompilationResultBuilder crb, AMD64MacroAssembler masm) {
        switch (instr) {
            case 0:
                masm.prefetchnta(address.toAddress());
                break;
            case 1:
                masm.prefetcht0(address.toAddress());
                break;
            case 2:
                masm.prefetcht2(address.toAddress());
                break;
            case 3:
                masm.prefetchw(address.toAddress());
                break;
            default:
                throw GraalError.shouldNotReachHere("unspported prefetch op " + instr);

        }
    }
}
