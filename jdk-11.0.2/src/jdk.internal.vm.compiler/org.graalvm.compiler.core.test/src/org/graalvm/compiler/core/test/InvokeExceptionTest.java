/*
 * Copyright (c) 2011, Oracle and/or its affiliates. All rights reserved.
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


package org.graalvm.compiler.core.test;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

import org.graalvm.compiler.nodes.Invoke;
import org.graalvm.compiler.nodes.StructuredGraph;
import org.graalvm.compiler.nodes.StructuredGraph.AllowAssumptions;
import org.graalvm.compiler.phases.common.CanonicalizerPhase;
import org.graalvm.compiler.phases.common.DeadCodeEliminationPhase;
import org.graalvm.compiler.phases.common.inlining.InliningPhase;
import org.graalvm.compiler.phases.tiers.HighTierContext;

public class InvokeExceptionTest extends GraalCompilerTest {

    public static synchronized void throwException(int i) {
        if (i == 1) {
            throw new RuntimeException();
        }
    }

    @Test
    public void test1() {
        // fill the profiling data...
        for (int i = 0; i < 10000; i++) {
            try {
                throwException(i & 1);
                test1Snippet(0);
            } catch (Throwable t) {
                // nothing to do...
            }
        }
        test("test1Snippet");
    }

    @SuppressWarnings("all")
    public static void test1Snippet(int a) {
        throwException(a);
    }

    private void test(String snippet) {
        StructuredGraph graph = parseProfiled(snippet, AllowAssumptions.NO);
        Map<Invoke, Double> hints = new HashMap<>();
        for (Invoke invoke : graph.getInvokes()) {
            hints.put(invoke, 1000d);
        }
        HighTierContext context = getDefaultHighTierContext();
        new InliningPhase(hints, new CanonicalizerPhase()).apply(graph, context);
        new CanonicalizerPhase().apply(graph, context);
        new DeadCodeEliminationPhase().apply(graph);
    }
}
