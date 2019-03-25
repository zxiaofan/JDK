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
public class BC_checkcast01 extends JTTTest {

    private static class TestClass {
    }

    static Object object2 = new Object();
    static Object object3 = "";
    static Object object4 = new TestClass();

    public static int test(int arg) {
        Object obj;
        if (arg == 2) {
            obj = object2;
        } else if (arg == 3) {
            obj = object3;
        } else if (arg == 4) {
            obj = object4;
        } else {
            obj = null;
        }
        final TestClass bc = (TestClass) obj;
        if (bc != null) {
            return arg;
        }
        return -1;
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
        runTest("test", 4);
    }

}
