/*
 * Copyright (c) 2013, 2014, Oracle and/or its affiliates. All rights reserved.
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


package org.graalvm.compiler.nodes.test;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import org.graalvm.compiler.core.test.GraalCompilerTest;
import org.graalvm.compiler.graph.iterators.NodePredicate;
import org.graalvm.compiler.nodes.LoopBeginNode;
import org.graalvm.compiler.nodes.PhiNode;
import org.graalvm.compiler.nodes.StructuredGraph;
import org.graalvm.compiler.nodes.StructuredGraph.AllowAssumptions;
import org.graalvm.compiler.phases.common.CanonicalizerPhase;
import org.graalvm.compiler.phases.tiers.PhaseContext;

public class LoopPhiCanonicalizerTest extends GraalCompilerTest {

    private static int[] array = new int[1000];

    @BeforeClass
    public static void before() {
        for (int i = 0; i < array.length; i++) {
            array[i] = i;
        }
    }

    public static long loopSnippet() {
        int a = 0;
        int b = 0;
        int c = 0;
        int d = 0;

        long sum = 0;
        while (d < 1000) {
            sum += array[a++] + array[b++] + array[c++] + array[d++];
        }
        return sum;
    }

    @Test
    public void test() {
        StructuredGraph graph = parseEager("loopSnippet", AllowAssumptions.YES);
        NodePredicate loopPhis = node -> node instanceof PhiNode && ((PhiNode) node).merge() instanceof LoopBeginNode;

        PhaseContext context = new PhaseContext(getProviders());
        Assert.assertEquals(5, graph.getNodes().filter(loopPhis).count());
        new CanonicalizerPhase().apply(graph, context);
        Assert.assertEquals(2, graph.getNodes().filter(loopPhis).count());

        test("loopSnippet");
    }
}
