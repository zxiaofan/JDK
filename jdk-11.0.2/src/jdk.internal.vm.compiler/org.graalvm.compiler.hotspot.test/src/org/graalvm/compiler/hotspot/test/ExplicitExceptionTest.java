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


package org.graalvm.compiler.hotspot.test;

import org.graalvm.compiler.core.test.GraalCompilerTest;
import org.graalvm.compiler.nodes.StructuredGraph;
import org.graalvm.compiler.nodes.extended.ForeignCallNode;
import org.graalvm.compiler.options.OptionValues;
import org.junit.Assume;
import org.junit.Test;

import jdk.vm.ci.code.InstalledCode;
import jdk.vm.ci.meta.ProfilingInfo;
import jdk.vm.ci.meta.ResolvedJavaMethod;
import jdk.vm.ci.meta.TriState;

public class ExplicitExceptionTest extends GraalCompilerTest {

    private int expectedForeignCallCount;

    /**
     * Determines if profiling info for {@code method} indicates an exception was thrown somewhere
     * in the method. In the case of the {@code -Xcomp} VM option, interpreter execution can be
     * skipped altogether and other execution engines (e.g., C1) may not record seen exceptions in a
     * method profile.
     */
    private static boolean exceptionWasSeen(ResolvedJavaMethod method) {
        ProfilingInfo profilingInfo = method.getProfilingInfo();
        if (profilingInfo != null) {
            for (int i = 0; i < profilingInfo.getCodeSize(); i++) {
                if (profilingInfo.getExceptionSeen(i) == TriState.TRUE) {
                    return true;
                }
            }
        }
        return false;
    }

    @Override
    protected InstalledCode getCode(ResolvedJavaMethod method, StructuredGraph graph, boolean forceCompile, boolean installAsDefault, OptionValues options) {
        InstalledCode installedCode = super.getCode(method, graph, forceCompile, installAsDefault, options);
        Assume.assumeTrue(exceptionWasSeen(method));
        assertDeepEquals(expectedForeignCallCount, lastCompiledGraph.getNodes().filter(ForeignCallNode.class).count());
        return installedCode;
    }

    public static int testAIOOBESnippet(int[] array) {
        return array[10];
    }

    @Test
    public void testAIOOBE() {
        int[] array = new int[4];
        for (int i = 0; i < 10000; i++) {
            try {
                testAIOOBESnippet(array);
            } catch (ArrayIndexOutOfBoundsException e) {
                // nothing to do
            }
        }
        expectedForeignCallCount = 2;
        test("testAIOOBESnippet", array);
    }

    public static int testNPEArraySnippet(int[] array) {
        return array[10];
    }

    @Test
    public void testNPEArray() {
        int[] array = null;
        for (int i = 0; i < 10000; i++) {
            try {
                testNPEArraySnippet(array);
            } catch (NullPointerException e) {
                // nothing to do
            }
        }
        expectedForeignCallCount = 2;
        test("testNPEArraySnippet", array);
    }

    private static class TestClass {
        int field;
    }

    public static int testNPESnippet(TestClass obj) {
        return obj.field;
    }

    @SuppressWarnings("unused")
    @Test
    public void testNPE() {
        new TestClass();
        TestClass obj = null;
        for (int i = 0; i < 10000; i++) {
            try {
                testNPESnippet(obj);
            } catch (NullPointerException e) {
                // nothing to do
            }
        }
        expectedForeignCallCount = 1;
        test("testNPESnippet", obj);
    }

}
