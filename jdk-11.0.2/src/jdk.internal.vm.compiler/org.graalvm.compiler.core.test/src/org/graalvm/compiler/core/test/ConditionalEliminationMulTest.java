/*
 * Copyright (c) 2016, Oracle and/or its affiliates. All rights reserved.
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

import org.graalvm.compiler.nodes.StructuredGraph;
import org.graalvm.compiler.nodes.StructuredGraph.AllowAssumptions;
import org.graalvm.compiler.phases.common.CanonicalizerPhase;
import org.graalvm.compiler.phases.common.ConditionalEliminationPhase;
import org.graalvm.compiler.phases.tiers.HighTierContext;
import org.junit.Test;

public class ConditionalEliminationMulTest extends GraalCompilerTest {

    public static void snippet01(int a) {
        if (a == 3) {
            if (a * 11 != 33) {
                shouldBeOptimizedAway();
            }
        }
    }

    public static void snippet02(int a) {
        if (a == 0) {
            if (a * 11 != 0) {
                shouldBeOptimizedAway();
            }
        }
    }

    public static void snippet03(int a) {
        if (a * 0 == 6) {
            shouldBeOptimizedAway();
        }
    }

    @Test
    public void testConditionalEliminated01() {
        assertOptimized("snippet01");
    }

    @Test
    public void testConditionalEliminated02() {
        assertOptimized("snippet02");
    }

    @Test
    public void testConditionalEliminated03() {
        assertOptimized("snippet03");
    }

    private void assertOptimized(String snippet) {
        assertOptimizedAway(prepareGraph(snippet));
    }

    private StructuredGraph prepareGraph(String snippet) {
        StructuredGraph graph = parseEager(snippet, AllowAssumptions.NO);
        HighTierContext context = getDefaultHighTierContext();
        new ConditionalEliminationPhase(false).apply(graph, context);
        CanonicalizerPhase c = new CanonicalizerPhase();
        c.apply(graph, context);
        new ConditionalEliminationPhase(false).apply(graph, context);
        c.apply(graph, context);
        return graph;
    }
}
