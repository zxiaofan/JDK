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

import org.junit.Assert;
import org.junit.Test;

import org.graalvm.compiler.graph.Node;
import org.graalvm.compiler.graph.iterators.NodeIterable;
import org.graalvm.compiler.nodes.ConstantNode;
import org.graalvm.compiler.nodes.FrameState;
import org.graalvm.compiler.nodes.Invoke;
import org.graalvm.compiler.nodes.ParameterNode;
import org.graalvm.compiler.nodes.StructuredGraph;
import org.graalvm.compiler.nodes.StructuredGraph.AllowAssumptions;
import org.graalvm.compiler.nodes.java.MonitorExitNode;
import org.graalvm.compiler.phases.common.CanonicalizerPhase;
import org.graalvm.compiler.phases.common.DeadCodeEliminationPhase;
import org.graalvm.compiler.phases.common.inlining.InliningPhase;
import org.graalvm.compiler.phases.tiers.HighTierContext;

/**
 * In the following tests, the usages of local variable "a" are replaced with the integer constant
 * 0. Then canonicalization is applied and it is verified that the resulting graph is equal to the
 * graph of the method that just has a "return 1" statement in it.
 */
public class MonitorGraphTest extends GraalCompilerTest {

    private static final String REFERENCE_SNIPPET = "referenceSnippet";

    @SuppressWarnings("all")
    public static synchronized int referenceSnippet(int a) {
        return 1;
    }

    public static int const1() {
        return 1;
    }

    @Test
    public void test1() {
        test("test1Snippet");
    }

    @SuppressWarnings("all")
    public static synchronized int test1Snippet(int a) {
        return const1();
    }

    @Test
    public void test2() {
        StructuredGraph graph = parseAndProcess("test2Snippet");
        NodeIterable<MonitorExitNode> monitors = graph.getNodes(MonitorExitNode.TYPE);
        Assert.assertEquals(1, monitors.count());
        Assert.assertEquals(monitors.first().stateAfter().bci, 3);
    }

    @SuppressWarnings("all")
    public static int test2Snippet(int a) {
        return const2();
    }

    public static synchronized int const2() {
        return 1;
    }

    private StructuredGraph parseAndProcess(String snippet) {
        StructuredGraph graph = parseEager(snippet, AllowAssumptions.NO);
        ParameterNode param = graph.getNodes(ParameterNode.TYPE).first();
        if (param != null) {
            ConstantNode constant = ConstantNode.forInt(0, graph);
            for (Node n : param.usages().snapshot()) {
                if (!(n instanceof FrameState)) {
                    n.replaceFirstInput(param, constant);
                }
            }
        }
        Map<Invoke, Double> hints = new HashMap<>();
        for (Invoke invoke : graph.getInvokes()) {
            hints.put(invoke, 1000d);
        }
        HighTierContext context = getDefaultHighTierContext();
        new InliningPhase(hints, new CanonicalizerPhase()).apply(graph, context);
        new CanonicalizerPhase().apply(graph, context);
        new DeadCodeEliminationPhase().apply(graph);
        return graph;
    }

    private void test(String snippet) {
        StructuredGraph graph = parseAndProcess(snippet);
        StructuredGraph referenceGraph = parseEager(REFERENCE_SNIPPET, AllowAssumptions.NO);
        assertEquals(referenceGraph, graph);
    }
}
