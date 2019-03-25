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

import org.graalvm.compiler.debug.Assertions;
import org.graalvm.compiler.lir.alloc.AllocationStageVerifier;
import org.graalvm.compiler.lir.alloc.lsra.LinearScanPhase;
import org.graalvm.compiler.lir.dfa.LocationMarkerPhase;
import org.graalvm.compiler.lir.dfa.MarkBasePointersPhase;
import org.graalvm.compiler.lir.phases.AllocationPhase.AllocationContext;
import org.graalvm.compiler.lir.stackslotalloc.LSStackSlotAllocator;
import org.graalvm.compiler.lir.stackslotalloc.SimpleStackSlotAllocator;
import org.graalvm.compiler.options.OptionValues;

public class AllocationStage extends LIRPhaseSuite<AllocationContext> {

    public AllocationStage(OptionValues options) {
        appendPhase(new MarkBasePointersPhase());
        appendPhase(new LinearScanPhase());

        // build frame map
        if (LSStackSlotAllocator.Options.LIROptLSStackSlotAllocator.getValue(options)) {
            appendPhase(new LSStackSlotAllocator());
        } else {
            appendPhase(new SimpleStackSlotAllocator());
        }
        // currently we mark locations only if we do register allocation
        appendPhase(new LocationMarkerPhase());

        if (Assertions.detailedAssertionsEnabled(options)) {
            appendPhase(new AllocationStageVerifier());
        }
    }
}
