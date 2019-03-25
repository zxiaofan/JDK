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


package org.graalvm.compiler.microbenchmarks.graal.util;

import org.graalvm.compiler.nodes.StructuredGraph;
import org.graalvm.compiler.phases.OptimisticOptimizations;
import org.graalvm.compiler.phases.PhaseSuite;
import org.graalvm.compiler.phases.schedule.SchedulePhase;
import org.graalvm.compiler.phases.schedule.SchedulePhase.SchedulingStrategy;
import org.graalvm.compiler.phases.tiers.HighTierContext;

public class ScheduleState extends GraphState {

    public SchedulePhase schedule;

    private final SchedulingStrategy selectedStrategy;

    public ScheduleState(SchedulingStrategy selectedStrategy) {
        this.selectedStrategy = selectedStrategy;
    }

    public ScheduleState() {
        this(SchedulingStrategy.EARLIEST_WITH_GUARD_ORDER);
    }

    @Override
    public void beforeInvocation() {
        schedule = new SchedulePhase(selectedStrategy);
        super.beforeInvocation();
    }

    @Override
    protected StructuredGraph preprocessOriginal(StructuredGraph structuredGraph) {
        StructuredGraph g = super.preprocessOriginal(structuredGraph);
        GraalState graal = new GraalState();
        PhaseSuite<HighTierContext> highTier = graal.backend.getSuites().getDefaultSuites(graal.options).getHighTier();
        highTier.apply(g, new HighTierContext(graal.providers, graal.backend.getSuites().getDefaultGraphBuilderSuite(), OptimisticOptimizations.ALL));
        return g;
    }
}
