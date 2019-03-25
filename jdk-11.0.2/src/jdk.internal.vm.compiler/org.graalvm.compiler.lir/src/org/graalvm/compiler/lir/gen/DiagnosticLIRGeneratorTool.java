/*
 * Copyright (c) 2015, 2016, Oracle and/or its affiliates. All rights reserved.
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


package org.graalvm.compiler.lir.gen;

import org.graalvm.compiler.lir.LIRInstruction;
import org.graalvm.compiler.lir.StandardOp.SaveRegistersOp;
import jdk.vm.ci.code.Register;
import jdk.vm.ci.code.RegisterConfig;
import jdk.vm.ci.code.StackSlot;
import jdk.vm.ci.meta.JavaConstant;
import jdk.vm.ci.meta.Value;

public interface DiagnosticLIRGeneratorTool {
    LIRInstruction createBenchmarkCounter(String name, String group, Value increment);

    LIRInstruction createMultiBenchmarkCounter(String[] names, String[] groups, Value[] increments);

    /**
     * Creates a {@link SaveRegistersOp} that fills a given set of registers with known garbage
     * value.
     *
     * The set of registers actually touched might be {@link SaveRegistersOp#remove reduced} later.
     *
     * @param zappedRegisters registers to be zapped
     * @param zapValues values used for zapping
     *
     * @see DiagnosticLIRGeneratorTool#createZapRegisters()
     */
    SaveRegistersOp createZapRegisters(Register[] zappedRegisters, JavaConstant[] zapValues);

    /**
     * Creates a {@link SaveRegistersOp} that fills all
     * {@link RegisterConfig#getAllocatableRegisters() allocatable registers} with a
     * {@link LIRGenerator#zapValueForKind known garbage value}.
     *
     * The set of registers actually touched might be {@link SaveRegistersOp#remove reduced} later.
     *
     * @see DiagnosticLIRGeneratorTool#createZapRegisters(Register[], JavaConstant[])
     */
    SaveRegistersOp createZapRegisters();

    /**
     * Marker interface for {@link LIRInstruction instructions} that should be succeeded with a
     * {@link DiagnosticLIRGeneratorTool#createZapRegisters() ZapRegisterOp} if assertions are
     * enabled.
     */
    interface ZapRegistersAfterInstruction {
    }

    /**
     * Marker interface for {@link LIRInstruction instructions} that should be preceded with a
     * {@link DiagnosticLIRGeneratorTool#zapArgumentSpace ZapArgumentSpaceOp} if assertions are
     * enabled.
     */
    interface ZapStackArgumentSpaceBeforeInstruction {
    }

    LIRInstruction createZapArgumentSpace(StackSlot[] zappedStack, JavaConstant[] zapValues);

    LIRInstruction zapArgumentSpace();
}
