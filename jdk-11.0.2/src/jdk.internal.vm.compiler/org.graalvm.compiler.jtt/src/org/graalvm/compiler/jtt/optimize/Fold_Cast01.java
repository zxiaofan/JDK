/*
 * Copyright (c) 2009, 2012, Oracle and/or its affiliates. All rights reserved.
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

import org.junit.Test;

import org.graalvm.compiler.jtt.JTTTest;

/*
 * Tests constant folding of integer operations.
 */
public class Fold_Cast01 extends JTTTest {

    private static class TestClass {
        int field = 9;
    }

    static final Object object = new TestClass();

    public static int test(int arg) {
        if (arg == 0) {
            return ((TestClass) object).field;
        }
        if (arg == 1) {
            Object obj = new TestClass();
            return ((TestClass) obj).field;
        }
        if (arg == 2) {
            return ((TestClass) null).field;
        }
        return 0;
    }

    @Test
    public void run0() throws Throwable {
        runTest("test", 0);
    }

    @Test
    public void run1() throws Throwable {
        runTest("test", 1);
    }

    @Test
    public void run2() throws Throwable {
        runTest("test", 2);
    }

}
