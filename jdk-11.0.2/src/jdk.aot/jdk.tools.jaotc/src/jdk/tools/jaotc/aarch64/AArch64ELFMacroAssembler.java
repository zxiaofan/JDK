/*
 * Copyright (c) 2016, Oracle and/or its affiliates. All rights reserved.
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

package jdk.tools.jaotc.aarch64;

import jdk.tools.jaotc.StubInformation;
import jdk.tools.jaotc.ELFMacroAssembler;

import org.graalvm.compiler.asm.aarch64.AArch64Address;
import org.graalvm.compiler.asm.aarch64.AArch64MacroAssembler;


import jdk.vm.ci.code.TargetDescription;
import jdk.vm.ci.code.Register;

import static jdk.vm.ci.aarch64.AArch64.*;

public final class AArch64ELFMacroAssembler extends AArch64MacroAssembler implements ELFMacroAssembler {

    private int currentEndOfInstruction;

    public AArch64ELFMacroAssembler(TargetDescription target) {
        super(target);
    }

    @Override
    public int currentEndOfInstruction() {
        return currentEndOfInstruction;
    }

    @Override
    public byte[] getPLTJumpCode() {
        // The main dispatch instruction
        addressOf(r16);
        ldr(64, r16, AArch64Address.createBaseRegisterOnlyAddress(r16));
        jmp(r16);

        currentEndOfInstruction = position();

        align(8);

        return close(true);
    }

    @Override
    public byte[] getPLTStaticEntryCode(StubInformation stub) {
        // The main dispatch instruction
        addressOf(r16);
        ldr(64, r16, AArch64Address.createBaseRegisterOnlyAddress(r16));
        jmp(r16);
        stub.setDispatchJumpOffset(position());

        // C2I stub used to call interpreter.  First load r12
        // (i.e. rmethod) with a pointer to the Method structure ...
        addressOf(r12);
        ldr(64, r12, AArch64Address.createBaseRegisterOnlyAddress(r12));
        nop();
        stub.setMovOffset(position());

        // ... then jump to the interpreter.
        addressOf(r16);
        ldr(64, r16, AArch64Address.createBaseRegisterOnlyAddress(r16));
        jmp(r16);
        stub.setC2IJumpOffset(position());

        // Call to VM runtime to resolve the call.
        stub.setResolveJumpStart(position());
        addressOf(r16);
        ldr(64, r16, AArch64Address.createBaseRegisterOnlyAddress(r16));
        jmp(r16);
        stub.setResolveJumpOffset(position());
        currentEndOfInstruction = position();

        align(8);
        stub.setSize(position());

        return close(true);
    }

    @Override
    public byte[] getPLTVirtualEntryCode(StubInformation stub) {
        // Fixup an inline cache.
        // Load r9 with a pointer to the Klass.
        addressOf(r17);
        ldr(64, r9, AArch64Address.createBaseRegisterOnlyAddress(r17));
        nop();
        stub.setMovOffset(position());

        // Jump to the method.
        addressOf(r16);
        ldr(64, r16, AArch64Address.createBaseRegisterOnlyAddress(r16));
        jmp(r16);
        stub.setDispatchJumpOffset(position());

        // Call to VM runtime to resolve the call.
        stub.setResolveJumpStart(position());
        addressOf(r16);
        ldr(64, r16, AArch64Address.createBaseRegisterOnlyAddress(r16));
        jmp(r16);
        stub.setResolveJumpOffset(position());
        currentEndOfInstruction = position();

        align(8);
        stub.setSize(position());

        return close(true);
    }
}
