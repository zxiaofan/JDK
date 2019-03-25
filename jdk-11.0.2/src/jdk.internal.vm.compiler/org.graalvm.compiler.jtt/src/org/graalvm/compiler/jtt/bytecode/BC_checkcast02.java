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


package org.graalvm.compiler.jtt.bytecode;

import org.junit.Test;

import org.graalvm.compiler.jtt.JTTTest;

/*
 */
public class BC_checkcast02 extends JTTTest {

    private static class TestClass {
    }

    static Object[] o1 = {new Object()};
    static String[] o2 = {""};
    static TestClass[] o3 = {new TestClass()};

    public static int test(int arg) {
        Object obj = null;
        if (arg == 0) {
            obj = o1;
        }
        if (arg == 1) {
            obj = o2;
        }
        if (arg == 2) {
            obj = o3;
        }
        Object[] r = (Object[]) obj;
        return r == null ? -1 : -1;
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

    @Test
    public void run3() throws Throwable {
        runTest("test", 3);
    }

}
