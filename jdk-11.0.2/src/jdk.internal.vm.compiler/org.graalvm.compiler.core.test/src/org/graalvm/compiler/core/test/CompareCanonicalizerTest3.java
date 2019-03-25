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

import org.graalvm.compiler.nodes.StructuredGraph;
import org.graalvm.compiler.nodes.StructuredGraph.AllowAssumptions;
import org.graalvm.compiler.nodes.ValueNode;
import org.graalvm.compiler.nodes.graphbuilderconf.GraphBuilderContext;
import org.graalvm.compiler.nodes.graphbuilderconf.InlineInvokePlugin;
import org.graalvm.compiler.phases.OptimisticOptimizations;
import org.graalvm.compiler.phases.common.CanonicalizerPhase;
import org.graalvm.compiler.phases.common.FrameStateAssignmentPhase;
import org.graalvm.compiler.phases.common.GuardLoweringPhase;
import org.graalvm.compiler.phases.tiers.MidTierContext;
import org.graalvm.compiler.phases.tiers.PhaseContext;
import org.junit.Ignore;
import org.junit.Test;

import jdk.vm.ci.meta.ResolvedJavaMethod;

public class CompareCanonicalizerTest3 extends GraalCompilerTest {

    @SuppressWarnings("unused") private static int sink0;
    @SuppressWarnings("unused") private static int sink1;

    @Ignore("Subword input cannot be trusted.")
    @Test
    public void test00() {
        assertCanonicallyEqual("integerTestCanonicalization00", "referenceSnippet00");
    }

    public static void integerTestCanonicalization00(char a) {
        if (a - 1 < a) {
            sink1 = 0;
        } else {
            sink0 = -1;
        }
    }

    @SuppressWarnings("unused")
    public static void referenceSnippet00(char a) {
        sink1 = 0;
    }

    @Ignore("Needs better stamp support for unsigned ranges")
    @Test
    public void test01() {
        assertCanonicallyEqual("integerTestCanonicalization01", "referenceSnippet01");
    }

    public static void integerTestCanonicalization01(char a) {
        if (Integer.compareUnsigned(a - 1, a) < 0) {
            sink1 = 0;
        } else {
            sink0 = -1;
        }
    }

    public static void referenceSnippet01(char a) {
        if (a != 0) {
            sink1 = 0;
        } else {
            sink0 = -1;
        }
    }

    @Ignore("Needs better stamp support for unsigned ranges")
    @Test
    public void test1() {
        assertCanonicallyEqual("integerTestCanonicalization1", "referenceSnippet1");
    }

    public static void integerTestCanonicalization1(char a) {
        if (Integer.compareUnsigned(a - 2, a) < 0) {
            sink1 = 0;
        } else {
            sink0 = -1;
        }
    }

    public static void referenceSnippet1(char a) {
        if (Integer.compareUnsigned(a, 2) >= 0) {
            sink1 = 0;
        } else {
            sink0 = -1;
        }
    }

    @Test
    public void test2() {
        assertCanonicallyEqual("integerTestCanonicalization2", "referenceSnippet2");
    }

    public static void integerTestCanonicalization2(int a) {
        if (a - 1 < a) {
            sink1 = 0;
        } else {
            sink0 = -1;
        }
    }

    public static void referenceSnippet2(int a) {
        if (a != Integer.MIN_VALUE) {
            sink1 = 0;
        } else {
            sink0 = -1;
        }
    }

    @Test
    public void test3() {
        assertCanonicallyEqual("integerTestCanonicalization3", "referenceSnippet3");
    }

    public static void integerTestCanonicalization3(int a) {
        if (a - 2 < a) {
            sink1 = 0;
        } else {
            sink0 = -1;
        }
    }

    public static void referenceSnippet3(int a) {
        if (a >= Integer.MIN_VALUE + 2) {
            sink1 = 0;
        } else {
            sink0 = -1;
        }
    }

    @Test
    public void test4() {
        assertCanonicallyEqual("integerTestCanonicalization4", "referenceSnippet4");
    }

    public static void integerTestCanonicalization4(int a) {
        if (a + 1 < a) {
            sink1 = 0;
        } else {
            sink0 = -1;
        }
    }

    public static void referenceSnippet4(int a) {
        if (a == Integer.MAX_VALUE) {
            sink1 = 0;
        } else {
            sink0 = -1;
        }
    }

    @Test
    public void test5() {
        assertCanonicallyEqual("integerTestCanonicalization5", "referenceSnippet5");
    }

    public static void integerTestCanonicalization5(int a) {
        if (a + 2 < a) {
            sink1 = 0;
        } else {
            sink0 = -1;
        }
    }

    public static void referenceSnippet5(int a) {
        if (a > Integer.MAX_VALUE - 2) {
            sink1 = 0;
        } else {
            sink0 = -1;
        }
    }

    @Test
    public void test6() {
        assertCanonicallyEqual("integerTestCanonicalization6", "referenceSnippet6");
    }

    public static void integerTestCanonicalization6(int a) {
        if (a < a + 1) {
            sink1 = 0;
        } else {
            sink0 = -1;
        }
    }

    public static void referenceSnippet6(int a) {
        if (a != Integer.MAX_VALUE) {
            sink1 = 0;
        } else {
            sink0 = -1;
        }
    }

    @Test
    public void test7() {
        assertCanonicallyEqual("integerTestCanonicalization7", "referenceSnippet7");
    }

    public static void integerTestCanonicalization7(int a) {
        if (a < a + 2) {
            sink1 = 0;
        } else {
            sink0 = -1;
        }
    }

    public static void referenceSnippet7(int a) {
        if (a <= Integer.MAX_VALUE - 2) {
            sink1 = 0;
        } else {
            sink0 = -1;
        }
    }

    protected void assertCanonicallyEqual(String snippet, String reference) {
        StructuredGraph graph = parseEager(snippet, AllowAssumptions.YES);
        PhaseContext context = new PhaseContext(getProviders());
        CanonicalizerPhase canonicalizer = new CanonicalizerPhase();
        canonicalizer.apply(graph, context);
        new GuardLoweringPhase().apply(graph, new MidTierContext(getProviders(), getTargetProvider(), OptimisticOptimizations.ALL, graph.getProfilingInfo()));
        new FrameStateAssignmentPhase().apply(graph);
        canonicalizer.apply(graph, context);
        StructuredGraph referenceGraph = parseEager(reference, AllowAssumptions.YES);
        canonicalizer.apply(referenceGraph, context);
        canonicalizer.apply(referenceGraph, context);
        assertEquals(referenceGraph, graph, true, true);
    }

    @Override
    protected InlineInvokePlugin.InlineInfo bytecodeParserShouldInlineInvoke(GraphBuilderContext b, ResolvedJavaMethod method, ValueNode[] args) {
        return InlineInvokePlugin.InlineInfo.createStandardInlineInfo(method);
    }
}
