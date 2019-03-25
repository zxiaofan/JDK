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

import static org.graalvm.compiler.hotspot.HotSpotHostBackend.UNCOMMON_TRAP_HANDLER;

import org.graalvm.compiler.asm.sparc.SPARCMacroAssembler;
import org.graalvm.compiler.core.common.LIRKind;
import org.graalvm.compiler.lir.LIRFrameState;
import org.graalvm.compiler.lir.LIRInstructionClass;
import org.graalvm.compiler.lir.Opcode;
import org.graalvm.compiler.lir.asm.CompilationResultBuilder;
import org.graalvm.compiler.lir.sparc.SPARCBlockEndOp;
import org.graalvm.compiler.lir.sparc.SPARCCall;

import jdk.vm.ci.meta.AllocatableValue;
import jdk.vm.ci.meta.PlatformKind;
import jdk.vm.ci.sparc.SPARC;

@Opcode("DEOPT")
final class SPARCDeoptimizeOp extends SPARCBlockEndOp {
    public static final LIRInstructionClass<SPARCDeoptimizeOp> TYPE = LIRInstructionClass.create(SPARCDeoptimizeOp.class);
    public static final SizeEstimate SIZE = SizeEstimate.create(1);
    @Temp AllocatableValue pcRegister;
    @State private LIRFrameState info;

    SPARCDeoptimizeOp(LIRFrameState info, PlatformKind wordKind) {
        super(TYPE, SIZE);
        this.info = info;
        pcRegister = SPARC.o7.asValue(LIRKind.value(wordKind));
    }

    @Override
    public void emitCode(CompilationResultBuilder crb, SPARCMacroAssembler masm) {
        // TODO the patched call address looks odd (and is invalid) compared to other runtime calls:
        // 0xffffffff749bb5fc: call 0xffffffff415a720c ; {runtime_call}
        // [Exception Handler]
        // 0xffffffff749bb604: call 0xffffffff749bb220 ; {runtime_call}
        // 0xffffffff749bb608: nop
        // [Deopt Handler Code]
        // 0xffffffff749bb60c: call 0xffffffff748da540 ; {runtime_call}
        // 0xffffffff749bb610: nop
        SPARCCall.directCall(crb, masm, crb.foreignCalls.lookupForeignCall(UNCOMMON_TRAP_HANDLER), null, info);
    }
}
