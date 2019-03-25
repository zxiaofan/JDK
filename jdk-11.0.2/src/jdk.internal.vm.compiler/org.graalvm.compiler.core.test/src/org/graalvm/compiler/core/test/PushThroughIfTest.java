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
import org.graalvm.compiler.nodes.FrameState;
import org.graalvm.compiler.nodes.StructuredGraph;
import org.graalvm.compiler.nodes.StructuredGraph.AllowAssumptions;
import org.graalvm.compiler.nodes.util.GraphUtil;
import org.graalvm.compiler.phases.common.CanonicalizerPhase;
import org.graalvm.compiler.phases.tiers.PhaseContext;
import org.junit.Test;

public class PushThroughIfTest extends GraalCompilerTest {

    public int field1;
    public int field2;

    public int testSnippet(boolean b) {
        int i;
        if (b) {
            i = field1;
        } else {
            i = field1;
        }
        return i + field2;
    }

    @SuppressWarnings("unused")
    public int referenceSnippet(boolean b) {
        return field1 + field2;
    }

    @Test
    public void test1() {
        test("testSnippet", "referenceSnippet");
    }

    private void test(String snippet, String reference) {
        StructuredGraph graph = parseEager(snippet, AllowAssumptions.YES);
        DebugContext debug = graph.getDebug();
        debug.dump(DebugContext.BASIC_LEVEL, graph, "Graph");
        for (FrameState fs : graph.getNodes(FrameState.TYPE).snapshot()) {
            fs.replaceAtUsages(null);
            GraphUtil.killWithUnusedFloatingInputs(fs);
        }
        new CanonicalizerPhase().apply(graph, new PhaseContext(getProviders()));
        new CanonicalizerPhase().apply(graph, new PhaseContext(getProviders()));

        StructuredGraph referenceGraph = parseEager(reference, AllowAssumptions.YES);
        for (FrameState fs : referenceGraph.getNodes(FrameState.TYPE).snapshot()) {
            fs.replaceAtUsages(null);
            GraphUtil.killWithUnusedFloatingInputs(fs);
        }
        new CanonicalizerPhase().apply(referenceGraph, new PhaseContext(getProviders()));
        assertEquals(referenceGraph, graph);
    }
}
