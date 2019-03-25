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
import org.graalvm.compiler.nodes.ValuePhiNode;
import org.junit.Assert;
import org.junit.Test;

/**
 * In the following tests, the correct removal of redundant phis during graph building is tested.
 */
public class PhiCreationTests extends GraalCompilerTest {

    /**
     * Dummy method to avoid javac dead code elimination.
     */
    private static void test() {
    }

    @Test
    public void test1() {
        StructuredGraph graph = parseEager("test1Snippet", AllowAssumptions.YES);
        Assert.assertFalse(graph.getNodes().filter(ValuePhiNode.class).iterator().hasNext());
    }

    public static int test1Snippet(int a) {
        if (a > 1) {
            test();
        }
        return a;
    }

    @Test
    public void test2() {
        StructuredGraph graph = parseEager("test2Snippet", AllowAssumptions.YES);
        Assert.assertFalse(graph.getNodes().filter(ValuePhiNode.class).iterator().hasNext());
    }

    public static int test2Snippet(int a) {
        while (a > 1) {
            test();
        }
        return a;
    }

    @Test
    public void test3() {
        StructuredGraph graph = parseEager("test3Snippet", AllowAssumptions.YES);
        DebugContext debug = graph.getDebug();
        debug.dump(DebugContext.BASIC_LEVEL, graph, "Graph");
        Assert.assertFalse(graph.getNodes().filter(ValuePhiNode.class).iterator().hasNext());
    }

    public static int test3Snippet(int a) {
        while (a > 1) {
            while (a > 1) {
                test();
            }
        }
        return a;
    }

    @Test
    public void test4() {
        StructuredGraph graph = parseEager("test4Snippet", AllowAssumptions.YES);
        DebugContext debug = graph.getDebug();
        debug.dump(DebugContext.BASIC_LEVEL, graph, "Graph");
        Assert.assertFalse(graph.getNodes().filter(ValuePhiNode.class).iterator().hasNext());
    }

    public static int test4Snippet(int a) {
        int b = 5;
        while (a > 1) {
            while (a > 1) {
                while (a > 1) {
                    try {
                        test();
                    } catch (Throwable t) {

                    }
                }
            }
            while (a > 1) {
                while (a > 1) {
                    try {
                        test();
                    } catch (Throwable t) {

                    }
                }
            }
        }
        return a + b;
    }
}
