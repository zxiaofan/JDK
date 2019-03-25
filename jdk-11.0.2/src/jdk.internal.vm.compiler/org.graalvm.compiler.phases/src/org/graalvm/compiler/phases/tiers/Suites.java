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


package org.graalvm.compiler.phases.tiers;

import org.graalvm.compiler.lir.alloc.RegisterAllocationPhase;
import org.graalvm.compiler.lir.phases.AllocationPhase.AllocationContext;
import org.graalvm.compiler.lir.phases.LIRPhase;
import org.graalvm.compiler.lir.phases.LIRPhaseSuite;
import org.graalvm.compiler.lir.phases.LIRSuites;
import org.graalvm.compiler.options.OptionValues;
import org.graalvm.compiler.phases.PhaseSuite;

public final class Suites {

    private final PhaseSuite<HighTierContext> highTier;
    private final PhaseSuite<MidTierContext> midTier;
    private final PhaseSuite<LowTierContext> lowTier;
    private boolean immutable;

    public PhaseSuite<HighTierContext> getHighTier() {
        return highTier;
    }

    public PhaseSuite<MidTierContext> getMidTier() {
        return midTier;
    }

    public PhaseSuite<LowTierContext> getLowTier() {
        return lowTier;
    }

    public Suites(PhaseSuite<HighTierContext> highTier, PhaseSuite<MidTierContext> midTier, PhaseSuite<LowTierContext> lowTier) {
        this.highTier = highTier;
        this.midTier = midTier;
        this.lowTier = lowTier;
    }

    public static Suites createSuites(CompilerConfiguration config, OptionValues options) {
        return new Suites(config.createHighTier(options), config.createMidTier(options), config.createLowTier(options));
    }

    public static LIRSuites createLIRSuites(CompilerConfiguration config, OptionValues options) {
        LIRPhaseSuite<AllocationContext> allocationStage = config.createAllocationStage(options);
        assert verifyAllocationStage(allocationStage);
        return new LIRSuites(config.createPreAllocationOptimizationStage(options), allocationStage, config.createPostAllocationOptimizationStage(options));
    }

    private static boolean verifyAllocationStage(LIRPhaseSuite<AllocationContext> allocationStage) {
        boolean allocationPhase = false;
        for (LIRPhase<?> phase : allocationStage.getPhases()) {
            if (phase instanceof RegisterAllocationPhase) {
                if (allocationPhase) {
                    assert false : "More than one register allocation phase";
                    return false;
                }
                allocationPhase = true;
            }

        }
        assert allocationPhase : "No register allocation phase";
        return allocationPhase;
    }

    public boolean isImmutable() {
        return immutable;
    }

    public synchronized void setImmutable() {
        if (!immutable) {
            highTier.setImmutable();
            midTier.setImmutable();
            lowTier.setImmutable();
            immutable = true;
        }
    }

    public Suites copy() {
        return new Suites(highTier.copy(), midTier.copy(), lowTier.copy());
    }
}
