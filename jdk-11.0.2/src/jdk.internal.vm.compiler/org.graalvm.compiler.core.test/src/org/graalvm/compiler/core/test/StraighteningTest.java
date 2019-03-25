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

import org.graalvm.compiler.debug.DebugContext;
import org.graalvm.compiler.nodes.StructuredGraph;
import org.graalvm.compiler.nodes.StructuredGraph.AllowAssumptions;
import org.graalvm.compiler.phases.common.CanonicalizerPhase;
import org.graalvm.compiler.phases.tiers.PhaseContext;
import org.junit.Test;

public class StraighteningTest extends GraalCompilerTest {

    private static final String REFERENCE_SNIPPET = "ref";

    public static boolean ref(int a, int b) {
        return a == b;
    }

    public static boolean test1Snippet(int a, int b) {
        int c = a;
        if (c == b) {
            c = 0x55;
        }
        if (c != 0x55) {
            return false;
        }
        return true;
    }

    public static boolean test3Snippet(int a, int b) {
        int val = (int) System.currentTimeMillis();
        int c = val + 1;
        if (a == b) {
            c = val;
        }
        if (c != val) {
            return false;
        }
        return true;
    }

    public static boolean test2Snippet(int a, int b) {
        int c;
        if (a == b) {
            c = 1;
        } else {
            c = 0;
        }
        return c == 1;
    }

    @Test(expected = AssertionError.class)
    public void test1() {
        test("test1Snippet");
    }

    public void test2() {
        test("test2Snippet");
    }

    @Test(expected = AssertionError.class)
    public void test3() {
        test("test3Snippet");
    }

    private void test(final String snippet) {
        // No debug scope to reduce console noise for @Test(expected = ...) tests
        StructuredGraph graph = parseEager(snippet, AllowAssumptions.YES);
        DebugContext debug = graph.getDebug();
        debug.dump(DebugContext.BASIC_LEVEL, graph, "Graph");
        new CanonicalizerPhase().apply(graph, new PhaseContext(getProviders()));
        StructuredGraph referenceGraph = parseEager(REFERENCE_SNIPPET, AllowAssumptions.YES);
        assertEquals(referenceGraph, graph);
    }
}
