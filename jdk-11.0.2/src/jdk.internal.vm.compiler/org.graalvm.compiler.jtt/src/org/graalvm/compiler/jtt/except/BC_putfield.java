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

public class BC_putfield extends JTTTest {

    private static class TestClass {
        private int field;
    }

    private static TestClass object = new TestClass();

    public static int test(int arg) {
        final TestClass obj = arg == 3 ? null : object;
        obj.field = arg;
        return obj.field;
    }

    @Test
    public void run0() throws Throwable {
        runTest("test", 0);
    }

    @Test
    public void run1() throws Throwable {
        runTest("test", 3);
    }

    @Test
    public void run2() throws Throwable {
        runTest("test", -4);
    }

}
