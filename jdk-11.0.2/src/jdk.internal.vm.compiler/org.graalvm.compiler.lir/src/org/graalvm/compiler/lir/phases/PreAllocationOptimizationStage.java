/*
 * Copyright (c) 2015, 2018, Oracle and/or its affiliates. All rights reserved.
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


package org.graalvm.compiler.lir.phases;

import org.graalvm.compiler.lir.alloc.SaveCalleeSaveRegisters;
import org.graalvm.compiler.lir.constopt.ConstantLoadOptimization;
import org.graalvm.compiler.lir.phases.PreAllocationOptimizationPhase.PreAllocationOptimizationContext;
import org.graalvm.compiler.options.OptionValues;

public class PreAllocationOptimizationStage extends LIRPhaseSuite<PreAllocationOptimizationContext> {
    public PreAllocationOptimizationStage(OptionValues options) {
        if (ConstantLoadOptimization.Options.LIROptConstantLoadOptimization.getValue(options)) {
            appendPhase(new ConstantLoadOptimization());
        }
        appendPhase(new SaveCalleeSaveRegisters());
    }
}
