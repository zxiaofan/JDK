/*
 * Copyright (c) 2016, 2016, Oracle and/or its affiliates. All rights reserved.
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

import static org.graalvm.compiler.graph.test.matchers.NodeIterableIsEmpty.isEmpty;
import static org.junit.Assert.assertThat;

import org.graalvm.compiler.graph.iterators.NodeIterable;
import org.graalvm.compiler.nodes.StructuredGraph;
import org.graalvm.compiler.nodes.java.NewArrayNode;
import org.graalvm.compiler.phases.common.CanonicalizerPhase;
import org.graalvm.compiler.phases.tiers.PhaseContext;
import org.junit.Test;

public class UnusedArray extends GraalCompilerTest {
    @SuppressWarnings("unused")
    public void smallArray() {
        byte[] array = new byte[3];
    }

    @SuppressWarnings("unused")
    public void largeArray() {
        byte[] array = new byte[10 * 1024 * 1024];
    }

    @SuppressWarnings("unused")
    public void unknownArray(int l) {
        byte[] array = new byte[l];
    }

    @Test
    public void testSmall() {
        test("smallArray");
    }

    @Test
    public void testLarge() {
        test("largeArray");
    }

    @Test
    public void testUnknown() {
        test("unknownArray");
    }

    public void test(String method) {
        StructuredGraph graph = parseEager(method, StructuredGraph.AllowAssumptions.YES);
        new CanonicalizerPhase().apply(graph, new PhaseContext(getProviders()));
        NodeIterable<NewArrayNode> newArrayNodes = graph.getNodes().filter(NewArrayNode.class);
        assertThat(newArrayNodes, isEmpty());
    }
}
