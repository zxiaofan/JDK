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


package org.graalvm.compiler.lir.aarch64;

import static org.graalvm.compiler.lir.LIRInstruction.OperandFlag.ILLEGAL;
import static org.graalvm.compiler.lir.LIRInstruction.OperandFlag.REG;
import static org.graalvm.compiler.lir.LIRInstruction.OperandFlag.STACK;

import org.graalvm.compiler.asm.aarch64.AArch64MacroAssembler;
import org.graalvm.compiler.lir.LIRInstructionClass;
import org.graalvm.compiler.lir.asm.CompilationResultBuilder;

import jdk.vm.ci.code.Register;
import jdk.vm.ci.code.ValueUtil;
import jdk.vm.ci.meta.Value;

public final class AArch64CCall extends AArch64LIRInstruction {
    public static final LIRInstructionClass<AArch64CCall> TYPE = LIRInstructionClass.create(AArch64CCall.class);

    @Def({REG, ILLEGAL}) protected Value result;
    @Use({REG, STACK}) protected Value[] parameters;
    @Use({REG}) protected Value functionPtr;

    public AArch64CCall(Value result, Value functionPtr, Value[] parameters) {
        super(TYPE);
        this.result = result;
        this.functionPtr = functionPtr;
        this.parameters = parameters;
    }

    @Override
    public void emitCode(CompilationResultBuilder crb, AArch64MacroAssembler masm) {
        directCall(masm);
    }

    private void directCall(AArch64MacroAssembler masm) {
        Register reg = ValueUtil.asRegister(functionPtr);
        masm.blr(reg);
        masm.ensureUniquePC();
    }

    @Override
    public boolean destroysCallerSavedRegisters() {
        return true;
    }

}
