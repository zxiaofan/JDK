/*
 * Copyright (c) 2011, 2012, Oracle and/or its affiliates. All rights reserved.
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


package org.graalvm.compiler.jtt.optimize;

import jdk.vm.ci.meta.ResolvedJavaMethod;

import org.junit.Test;

import org.graalvm.compiler.jtt.JTTTest;

public class ConditionalElimination01 extends JTTTest {

    private static int x;
    private static Object o = new Object();

    private static class A {

        A(int y) {
            this.y = y;
        }

        int y;
    }

    @Override
    protected void before(ResolvedJavaMethod method) {
        super.before(method);
        x = 0;
    }

    public int test(A a) {
        if (o == null) {
            return -1;
        }
        if (a == null) {
            return -2;
        }
        if (o == null) {
            return -3;
        }
        x = 3;
        return a.y + x;
    }

    @Test
    public void run0() throws Throwable {
        runTest("test", new A(5));
    }

    @Test
    public void run1() throws Throwable {
        runTest("test", new Object[]{null});
    }

}
