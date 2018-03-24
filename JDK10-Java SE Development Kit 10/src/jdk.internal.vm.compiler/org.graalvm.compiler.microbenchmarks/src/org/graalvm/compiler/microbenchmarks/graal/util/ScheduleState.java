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

import org.graalvm.compiler.phases.schedule.SchedulePhase;
import org.graalvm.compiler.phases.schedule.SchedulePhase.SchedulingStrategy;

public class ScheduleState extends GraphState {

    public SchedulePhase schedule;

    private final SchedulingStrategy selectedStrategy;

    public ScheduleState(SchedulingStrategy selectedStrategy) {
        this.selectedStrategy = selectedStrategy;
    }

    public ScheduleState() {
        this(SchedulingStrategy.EARLIEST);
    }

    @Override
    public void beforeInvocation() {
        schedule = new SchedulePhase(selectedStrategy);
        super.beforeInvocation();
    }
}
