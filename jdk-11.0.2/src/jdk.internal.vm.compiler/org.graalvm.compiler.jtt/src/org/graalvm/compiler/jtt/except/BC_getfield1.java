/*
 * Copyright (c) 2007, 2012, Oracle and/or its affiliates. All rights reserved.
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
/*
 */


package org.graalvm.compiler.jtt.except;

import org.junit.Test;

import org.graalvm.compiler.jtt.JTTTest;

public class BC_getfield1 extends JTTTest {

    private static class TestClass {
        private int field = 13;
    }

    public static void test(TestClass arg) {
        @SuppressWarnings("unused")
        int i = arg.field;
    }

    @Test
    public void run0() throws Throwable {
        runTest("test", (Object) null);
    }

    @Test
    public void run1() throws Throwable {
        // tests that the null check isn't removed along with the read
        runTest(getInitialOptions(), EMPTY, true, true, "test", (Object) null);
    }

    @Test
    public void run2() throws Throwable {
        runTest("test", new TestClass());
    }

}
