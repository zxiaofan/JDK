/*
 * Copyright (c) 2012, 2014, Oracle and/or its affiliates. All rights reserved.
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

import static org.graalvm.compiler.graph.test.matchers.NodeIterableIsEmpty.isNotEmpty;

import org.graalvm.compiler.nodes.StructuredGraph;
import org.graalvm.compiler.nodes.StructuredGraph.AllowAssumptions;
import org.graalvm.compiler.nodes.calc.IntegerLessThanNode;
import org.graalvm.compiler.phases.common.CanonicalizerPhase;
import org.graalvm.compiler.phases.tiers.PhaseContext;
import org.junit.Assert;
import org.junit.Test;

public class CompareCanonicalizerTest2 extends GraalCompilerTest {

    @SuppressWarnings("unused") private static int sink0;
    @SuppressWarnings("unused") private static int sink1;

    private StructuredGraph getCanonicalizedGraph(String name) {
        StructuredGraph graph = parseEager(name, AllowAssumptions.YES);
        new CanonicalizerPhase().apply(graph, new PhaseContext(getProviders()));
        return graph;
    }

    public void testIntegerTestCanonicalization(String name) {
        StructuredGraph graph = getCanonicalizedGraph(name);
        Assert.assertThat(graph.getNodes().filter(IntegerLessThanNode.class), isNotEmpty());
    }

    @Test
    public void test0() {
        testIntegerTestCanonicalization("integerTestCanonicalization0");
    }

    @Test
    public void test1() {
        testIntegerTestCanonicalization("integerTestCanonicalization1");
    }

    public static void integerTestCanonicalization0(int a) {
        if (1 < a + 1) {
            sink1 = 0;
        } else {
            sink0 = -1;
        }
    }

    public static void integerTestCanonicalization1(int a) {
        if (a - 1 < -1) {
            sink1 = 0;
        } else {
            sink0 = -1;
        }
    }

}
