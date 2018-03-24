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

import org.graalvm.compiler.nodes.GuardNode;
import org.graalvm.compiler.nodes.StructuredGraph;
import org.graalvm.compiler.nodes.StructuredGraph.AllowAssumptions;
import org.graalvm.compiler.nodes.spi.LoweringTool;
import org.graalvm.compiler.phases.common.CanonicalizerPhase;
import org.graalvm.compiler.phases.common.FloatingReadPhase;
import org.graalvm.compiler.phases.common.LoweringPhase;
import org.graalvm.compiler.phases.common.ConditionalEliminationPhase;
import org.graalvm.compiler.phases.tiers.PhaseContext;
import org.junit.Test;

/**
 * Collection of tests for {@link org.graalvm.compiler.phases.common.ConditionalEliminationPhase}
 * including those that triggered bugs in this phase.
 */
public class ConditionalEliminationTest2 extends ConditionalEliminationTestBase {

    public static Object field;

    static class Entry {

        final String name;

        Entry(String name) {
            this.name = name;
        }
    }

    static class EntryWithNext extends Entry {

        EntryWithNext(String name, Entry next) {
            super(name);
            this.next = next;
        }

        final Entry next;
    }

    public static Entry search(Entry start, String name, Entry alternative) {
        Entry current = start;
        do {
            while (current instanceof EntryWithNext) {
                if (name != null && current.name == name) {
                    current = null;
                } else {
                    Entry next = ((EntryWithNext) current).next;
                    current = next;
                }
            }

            if (current != null) {
                if (current.name.equals(name)) {
                    return current;
                }
            }
            if (current == alternative) {
                return null;
            }
            current = alternative;

        } while (true);
    }

    public static int testRedundantComparesSnippet(int[] array) {
        if (array == null) {
            return 0;
        }
        return array[0] + array[1] + array[2] + array[3];
    }

    @Test
    public void testRedundantCompares() {
        StructuredGraph graph = parseEager("testRedundantComparesSnippet", AllowAssumptions.YES);
        CanonicalizerPhase canonicalizer = new CanonicalizerPhase();
        PhaseContext context = new PhaseContext(getProviders());

        new LoweringPhase(canonicalizer, LoweringTool.StandardLoweringStage.HIGH_TIER).apply(graph, context);
        canonicalizer.apply(graph, context);
        new FloatingReadPhase().apply(graph);
        new ConditionalEliminationPhase(true).apply(graph, context);
        canonicalizer.apply(graph, context);

        assertDeepEquals(1, graph.getNodes().filter(GuardNode.class).count());
    }

    public static String testInstanceOfCheckCastSnippet(Object e) {
        if (e instanceof Entry) {
            return ((Entry) e).name;
        }
        return null;
    }

    @Test
    public void testInstanceOfCheckCastLowered() {
        StructuredGraph graph = parseEager("testInstanceOfCheckCastSnippet", AllowAssumptions.YES);

        CanonicalizerPhase canonicalizer = new CanonicalizerPhase();
        PhaseContext context = new PhaseContext(getProviders());

        new LoweringPhase(canonicalizer, LoweringTool.StandardLoweringStage.HIGH_TIER).apply(graph, context);
        canonicalizer.apply(graph, context);
        new ConditionalEliminationPhase(true).apply(graph, context);
        canonicalizer.apply(graph, context);

        assertDeepEquals(0, graph.getNodes().filter(GuardNode.class).count());
    }

}
