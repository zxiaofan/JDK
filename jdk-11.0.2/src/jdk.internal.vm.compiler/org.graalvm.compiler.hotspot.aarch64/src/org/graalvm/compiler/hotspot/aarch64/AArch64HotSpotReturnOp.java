/*
 * Copyright (c) 2013, 2018, Oracle and/or its affiliates. All rights reserved.
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


package org.graalvm.compiler.hotspot.aarch64;

import static jdk.vm.ci.aarch64.AArch64.lr;
import static jdk.vm.ci.code.ValueUtil.asRegister;
import static org.graalvm.compiler.lir.LIRInstruction.OperandFlag.ILLEGAL;
import static org.graalvm.compiler.lir.LIRInstruction.OperandFlag.REG;

import org.graalvm.compiler.asm.aarch64.AArch64MacroAssembler;
import org.graalvm.compiler.hotspot.GraalHotSpotVMConfig;
import org.graalvm.compiler.lir.LIRInstructionClass;
import org.graalvm.compiler.lir.Opcode;
import org.graalvm.compiler.lir.asm.CompilationResultBuilder;

import jdk.vm.ci.code.Register;
import jdk.vm.ci.meta.Value;

/**
 * Returns from a function.
 */
@Opcode("RETURN")
public final class AArch64HotSpotReturnOp extends AArch64HotSpotEpilogueOp {

    public static final LIRInstructionClass<AArch64HotSpotReturnOp> TYPE = LIRInstructionClass.create(AArch64HotSpotReturnOp.class);

    @Use({REG, ILLEGAL}) private Value result;
    private final boolean isStub;
    private final boolean requiresReservedStackAccessCheck;

    public AArch64HotSpotReturnOp(Value result, boolean isStub, GraalHotSpotVMConfig config, Register thread, boolean requiresReservedStackAccessCheck) {
        super(TYPE, config, thread);
        this.requiresReservedStackAccessCheck = requiresReservedStackAccessCheck;
        assert validReturnValue(result);
        this.result = result;
        this.isStub = isStub;
    }

    private static boolean validReturnValue(Value result) {
        if (result.equals(Value.ILLEGAL)) {
            return true;
        }
        return asRegister(result).encoding == 0;
    }

    @Override
    public void emitCode(CompilationResultBuilder crb, AArch64MacroAssembler masm) {
        final boolean emitSafepoint = !isStub;
        leaveFrame(crb, masm, emitSafepoint, requiresReservedStackAccessCheck);
        masm.ret(lr);
    }
}
