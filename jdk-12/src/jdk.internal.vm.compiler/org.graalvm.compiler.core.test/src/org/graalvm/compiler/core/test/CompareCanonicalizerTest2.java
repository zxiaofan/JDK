/*
 * Copyright (c) 2012, 2018, Oracle and/or its affiliates. All rights reserved.
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
import org.graalvm.compiler.phases.tiers.PhaseContext;
import org.junit.Test;

public class CompareCanonicalizerTest2 extends GraalCompilerTest {

    @SuppressWarnings("unused") private static boolean sink;

    private StructuredGraph getCanonicalizedGraph(String name) {
        StructuredGraph graph = getRegularGraph(name);
        new CanonicalizerPhase().apply(graph, new PhaseContext(getProviders()));
        return graph;
    }

    private StructuredGraph getRegularGraph(String name) {
        StructuredGraph graph = parseEager(name, AllowAssumptions.YES);
        return graph;
    }

    @Test
    public void test0() {
        assertEquals(getCanonicalizedGraph("integerTestCanonicalization0"), getRegularGraph("integerTestCanonicalization0"));
    }

    public static void integerTestCanonicalization0(int a) {
        sink = 1 < a + 1;
    }

    @Test
    public void test1() {
        assertEquals(getCanonicalizedGraph("integerTestCanonicalization1"), getRegularGraph("integerTestCanonicalization1"));
    }

    public static void integerTestCanonicalization1(int a) {
        sink = a - 1 < -1;
    }

    @Test
    public void test2() {
        assertEquals(getCanonicalizedGraph("integerTestCanonicalization2a"), getCanonicalizedGraph("integerTestCanonicalization2Reference"));
        assertEquals(getCanonicalizedGraph("integerTestCanonicalization2b"), getCanonicalizedGraph("integerTestCanonicalization2Reference"));
    }

    public static boolean integerTestCanonicalization2a(Object[] arr) {
        return arr.length - 1 < 0;
    }

    public static boolean integerTestCanonicalization2b(Object[] arr) {
        return arr.length < 1;
    }

    public static boolean integerTestCanonicalization2Reference(Object[] arr) {
        return arr.length == 0;
    }

    @Test
    public void test3() {
        assertEquals(getCanonicalizedGraph("integerTestCanonicalization3"), getCanonicalizedGraph("integerTestCanonicalization3Reference"));
    }

    public static boolean integerTestCanonicalization3(Object[] arr) {
        return ((long) (arr.length - 1)) - 1 < 0;
    }

    public static boolean integerTestCanonicalization3Reference(Object[] arr) {
        return arr.length < 2;
    }

}
