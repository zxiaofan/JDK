/*
 * Copyright (c) 2011, 2015, Oracle and/or its affiliates. All rights reserved.
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
import org.graalvm.compiler.debug.DebugDumpScope;
import org.graalvm.compiler.graph.Node;
import org.graalvm.compiler.nodes.ReturnNode;
import org.graalvm.compiler.nodes.StructuredGraph;
import org.graalvm.compiler.nodes.StructuredGraph.AllowAssumptions;
import org.graalvm.compiler.nodes.extended.MonitorExit;
import org.graalvm.compiler.nodes.memory.FloatingReadNode;
import org.graalvm.compiler.nodes.spi.LoweringTool;
import org.graalvm.compiler.phases.common.CanonicalizerPhase;
import org.graalvm.compiler.phases.common.FloatingReadPhase;
import org.graalvm.compiler.phases.common.LoweringPhase;
import org.graalvm.compiler.phases.tiers.PhaseContext;
import org.junit.Assert;
import org.junit.Test;

public class FloatingReadTest extends GraphScheduleTest {

    public static class Container {

        public int a;
    }

    public static void changeField(Container c) {
        c.a = 0xcafebabe;
    }

    public static synchronized int test1Snippet() {
        Container c = new Container();
        return c.a;
    }

    @Test
    public void test1() {
        test("test1Snippet");
    }

    @SuppressWarnings("try")
    private void test(final String snippet) {
        DebugContext debug = getDebugContext();
        try (DebugContext.Scope s = debug.scope("FloatingReadTest", new DebugDumpScope(snippet))) {

            StructuredGraph graph = parseEager(snippet, AllowAssumptions.YES);
            PhaseContext context = new PhaseContext(getProviders());
            new LoweringPhase(new CanonicalizerPhase(), LoweringTool.StandardLoweringStage.HIGH_TIER).apply(graph, context);
            new FloatingReadPhase().apply(graph);

            ReturnNode returnNode = null;
            MonitorExit monitorexit = null;

            for (Node n : graph.getNodes()) {
                if (n instanceof ReturnNode) {
                    assert returnNode == null;
                    returnNode = (ReturnNode) n;
                } else if (n instanceof MonitorExit) {
                    monitorexit = (MonitorExit) n;
                }
            }

            debug.dump(DebugContext.BASIC_LEVEL, graph, "After lowering");

            Assert.assertNotNull(returnNode);
            Assert.assertNotNull(monitorexit);
            Assert.assertTrue(returnNode.result() instanceof FloatingReadNode);

            FloatingReadNode read = (FloatingReadNode) returnNode.result();

            assertOrderedAfterSchedule(graph, read, (Node) monitorexit);
        } catch (Throwable e) {
            throw debug.handle(e);
        }
    }
}
