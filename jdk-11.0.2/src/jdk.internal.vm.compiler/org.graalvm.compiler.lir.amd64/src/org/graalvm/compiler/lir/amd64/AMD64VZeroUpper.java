/*
 * Copyright (c) 2016, Oracle and/or its affiliates. All rights reserved.
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

import static jdk.vm.ci.code.ValueUtil.asRegister;
import static jdk.vm.ci.code.ValueUtil.isRegister;

import java.util.BitSet;

import org.graalvm.compiler.asm.amd64.AMD64MacroAssembler;
import org.graalvm.compiler.lir.LIRInstructionClass;
import org.graalvm.compiler.lir.asm.CompilationResultBuilder;

import jdk.vm.ci.amd64.AMD64;
import jdk.vm.ci.code.Register;
import jdk.vm.ci.code.RegisterValue;
import jdk.vm.ci.meta.Value;

public class AMD64VZeroUpper extends AMD64LIRInstruction {

    public static final LIRInstructionClass<AMD64VZeroUpper> TYPE = LIRInstructionClass.create(AMD64VZeroUpper.class);

    @Temp protected final RegisterValue[] xmmRegisters;

    public AMD64VZeroUpper(Value[] exclude) {
        super(TYPE);
        xmmRegisters = initRegisterValues(exclude);
    }

    private static RegisterValue[] initRegisterValues(Value[] exclude) {
        BitSet skippedRegs = new BitSet();
        int numSkipped = 0;
        if (exclude != null) {
            for (Value value : exclude) {
                if (isRegister(value) && asRegister(value).getRegisterCategory().equals(AMD64.XMM)) {
                    skippedRegs.set(asRegister(value).number);
                    numSkipped++;
                }
            }
        }
        RegisterValue[] regs = new RegisterValue[AMD64.xmmRegistersAVX512.length - numSkipped];
        for (int i = 0, j = 0; i < AMD64.xmmRegistersAVX512.length; i++) {
            Register reg = AMD64.xmmRegistersAVX512[i];
            if (!skippedRegs.get(reg.number)) {
                regs[j++] = reg.asValue();
            }
        }
        return regs;
    }

    @Override
    public void emitCode(CompilationResultBuilder crb, AMD64MacroAssembler asm) {
        asm.vzeroupper();
    }
}
