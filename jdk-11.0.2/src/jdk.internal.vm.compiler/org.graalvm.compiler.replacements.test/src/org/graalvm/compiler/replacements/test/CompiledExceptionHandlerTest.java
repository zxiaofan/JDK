/*
 * Copyright (c) 2011, 2016, Oracle and/or its affiliates. All rights reserved.
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


package org.graalvm.compiler.replacements.test;

import org.graalvm.compiler.core.phases.HighTier;
import org.graalvm.compiler.core.test.GraalCompilerTest;
import org.graalvm.compiler.nodes.StructuredGraph;
import org.graalvm.compiler.nodes.StructuredGraph.Builder;
import org.graalvm.compiler.nodes.ValueNode;
import org.graalvm.compiler.nodes.graphbuilderconf.GraphBuilderContext;
import org.graalvm.compiler.nodes.graphbuilderconf.InlineInvokePlugin.InlineInfo;
import org.graalvm.compiler.nodes.java.ExceptionObjectNode;
import org.graalvm.compiler.options.OptionValues;
import org.graalvm.compiler.phases.PhaseSuite;
import org.graalvm.compiler.phases.tiers.HighTierContext;
import org.graalvm.compiler.phases.tiers.Suites;
import org.junit.Assert;
import org.junit.Test;

import jdk.vm.ci.meta.ResolvedJavaMethod;

/**
 * Tests compilation of a hot exception handler.
 */
public class CompiledExceptionHandlerTest extends GraalCompilerTest {

    @Override
    @SuppressWarnings("try")
    protected Suites createSuites(OptionValues options) {
        return super.createSuites(new OptionValues(options, HighTier.Options.Inline, false));
    }

    @Override
    protected InlineInfo bytecodeParserShouldInlineInvoke(GraphBuilderContext b, ResolvedJavaMethod method, ValueNode[] args) {
        /*
         * We don't care whether other invokes are inlined or not, but we definitely don't want
         * another explicit exception handler in the graph.
         */
        return InlineInfo.DO_NOT_INLINE_NO_EXCEPTION;
    }

    @Override
    protected StructuredGraph parse(Builder builder, PhaseSuite<HighTierContext> graphBuilderSuite) {
        StructuredGraph graph = super.parse(builder, graphBuilderSuite);
        int handlers = graph.getNodes().filter(ExceptionObjectNode.class).count();
        Assert.assertEquals(1, handlers);
        return graph;
    }

    @BytecodeParserNeverInline(invokeWithException = true)
    private static void raiseExceptionSimple(String s) {
        throw new RuntimeException("Raising exception with message \"" + s + "\"");
    }

    @Test
    public void test1() {
        test("test1Snippet", "a string");
        test("test1Snippet", (String) null);
    }

    public static String test1Snippet(String message) {
        if (message != null) {
            try {
                raiseExceptionSimple(message);
            } catch (Exception e) {
                return message + e.getMessage();
            }
        }
        return null;
    }

    @BytecodeParserNeverInline(invokeWithException = true)
    private static void raiseException(String m1, String m2, String m3, String m4, String m5) {
        throw new RuntimeException(m1 + m2 + m3 + m4 + m5);
    }

    @Test
    public void test2() {
        test("test2Snippet", "m1", "m2", "m3", "m4", "m5");
        test("test2Snippet", null, "m2", "m3", "m4", "m5");
    }

    public static String test2Snippet(String m1, String m2, String m3, String m4, String m5) {
        if (m1 != null) {
            try {
                raiseException(m1, m2, m3, m4, m5);
            } catch (Exception e) {
                return m5 + m4 + m3 + m2 + m1;
            }
        }
        return m4 + m3;
    }
}
