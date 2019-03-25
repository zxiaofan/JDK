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

import org.junit.Test;

import org.graalvm.compiler.core.test.ea.EATestBase.TestClassInt;

public class ShortCircuitNodeTest extends GraalCompilerTest {

    @Test
    public void test1() {
        // only executeActual, to avoid creating profiling information
        executeActual(getResolvedJavaMethod("test1Snippet"), 1, 2);
    }

    public static final TestClassInt field = null;
    public static TestClassInt field2 = null;

    @SuppressWarnings("unused")
    public static void test1Snippet(int a, int b) {
        /*
         * if a ShortCircuitOrNode is created for the check inside test2, then faulty handling of
         * guards can create a cycle in the graph.
         */
        int v;
        if (a == 1) {
            if (b != 1) {
                int i = field.x;
            }
            field2 = null;
            v = 0;
        } else {
            v = 1;
        }

        if (test2(v, b)) {
            int i = field.x;
        }
    }

    public static boolean test2(int a, int b) {
        return a != 0 || b != 1;
    }
}
