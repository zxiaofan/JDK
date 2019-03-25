/*
 * Copyright (c) 2015, 2015, Oracle and/or its affiliates. All rights reserved.
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


package org.graalvm.compiler.lir.alloc.lsra;

import jdk.internal.vm.compiler.collections.Pair;
import org.graalvm.compiler.debug.Indent;
import org.graalvm.compiler.lir.gen.LIRGenerationResult;
import org.graalvm.compiler.lir.phases.AllocationPhase.AllocationContext;

import jdk.vm.ci.code.TargetDescription;

public final class LinearScanRegisterAllocationPhase extends LinearScanAllocationPhase {

    private final LinearScan allocator;

    LinearScanRegisterAllocationPhase(LinearScan allocator) {
        this.allocator = allocator;
    }

    @Override
    protected void run(TargetDescription target, LIRGenerationResult result, AllocationContext context) {
        allocator.printIntervals("Before register allocation");
        allocateRegisters();
        allocator.printIntervals("After register allocation");
    }

    @SuppressWarnings("try")
    void allocateRegisters() {
        try (Indent indent = allocator.getDebug().logAndIndent("allocate registers")) {
            Interval precoloredIntervals;
            Interval notPrecoloredIntervals;

            Pair<Interval, Interval> result = allocator.createUnhandledLists(LinearScan.IS_PRECOLORED_INTERVAL, LinearScan.IS_VARIABLE_INTERVAL);
            precoloredIntervals = result.getLeft();
            notPrecoloredIntervals = result.getRight();

            // allocate cpu registers
            LinearScanWalker lsw;
            if (OptimizingLinearScanWalker.Options.LSRAOptimization.getValue(allocator.getOptions())) {
                lsw = new OptimizingLinearScanWalker(allocator, precoloredIntervals, notPrecoloredIntervals);
            } else {
                lsw = new LinearScanWalker(allocator, precoloredIntervals, notPrecoloredIntervals);
            }
            lsw.walk();
            lsw.finishAllocation();
        }
    }

}
