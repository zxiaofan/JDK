/*
 * Copyright (c) 2015, 2017, Oracle and/or its affiliates. All rights reserved.
 * Copyright (c) 2018, Red Hat Inc. All rights reserved.
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

import static org.graalvm.compiler.core.common.GraalOptions.GeneratePIC;
import static jdk.vm.ci.code.ValueUtil.asRegister;

import jdk.vm.ci.aarch64.AArch64Kind;
import jdk.vm.ci.code.Register;
import jdk.vm.ci.meta.AllocatableValue;

import org.graalvm.compiler.asm.aarch64.AArch64Address;
import org.graalvm.compiler.asm.aarch64.AArch64MacroAssembler;
import org.graalvm.compiler.debug.GraalError;
import org.graalvm.compiler.lir.LIRInstructionClass;
import org.graalvm.compiler.lir.aarch64.AArch64LIRInstruction;
import org.graalvm.compiler.lir.asm.CompilationResultBuilder;

public final class AArch64HotSpotLoadConfigValueOp extends AArch64LIRInstruction {

    public static final LIRInstructionClass<AArch64HotSpotLoadConfigValueOp> TYPE = LIRInstructionClass.create(AArch64HotSpotLoadConfigValueOp.class);

    @Def({OperandFlag.REG}) protected AllocatableValue result;
    private final int markId;

    public AArch64HotSpotLoadConfigValueOp(int markId, AllocatableValue result) {
        super(TYPE);
        this.result = result;
        this.markId = markId;
    }

    @Override
    public void emitCode(CompilationResultBuilder crb, AArch64MacroAssembler masm) {
        if (GeneratePIC.getValue(crb.getOptions())) {
            AArch64Kind kind = (AArch64Kind) result.getPlatformKind();
            Register reg = asRegister(result);
            masm.adrp(reg);
            masm.add(64, reg, reg, 1);
            switch (kind) {
                case BYTE:
                    masm.ldrs(8, 32, reg, AArch64Address.createBaseRegisterOnlyAddress(reg));
                    break;
                case WORD:
                    masm.ldrs(16, 32, reg, AArch64Address.createBaseRegisterOnlyAddress(reg));
                    break;
                case DWORD:
                    masm.ldr(32, reg, AArch64Address.createBaseRegisterOnlyAddress(reg));
                    break;
                case QWORD:
                    masm.ldr(64, reg, AArch64Address.createBaseRegisterOnlyAddress(reg));
                    break;
                default:
                    throw GraalError.unimplemented();
            }
            masm.nop();
        } else {
            throw GraalError.unimplemented();
        }
        crb.recordMark(markId);
    }

}
