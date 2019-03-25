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
import org.graalvm.compiler.phases.common.FrameStateAssignmentPhase;
import org.graalvm.compiler.phases.common.GuardLoweringPhase;

public class FrameStateAssignmentState extends GraphState {

    public FrameStateAssignmentPhase phase;

    @Override
    protected StructuredGraph preprocessOriginal(StructuredGraph structuredGraph) {
        new GuardLoweringPhase().apply(structuredGraph, null);
        return structuredGraph;
    }

    @Override
    public void beforeInvocation() {
        phase = new FrameStateAssignmentPhase();
        super.beforeInvocation();
    }
}
