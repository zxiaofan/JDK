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


package org.graalvm.compiler.jtt.except;

import org.junit.Test;

import org.graalvm.compiler.jtt.JTTTest;

/*
 */
public class BC_checkcast1 extends JTTTest {

    static Object object2 = new Object();
    static Object object3 = "";
    static Object object4 = new DummyTestClass();

    public static int test(int arg) {
        Object obj = null;
        if (arg == 2) {
            obj = object2;
        }
        if (arg == 3) {
            obj = object3;
        }
        if (arg == 4) {
            obj = object4;
        }
        final DummyTestClass bc = (DummyTestClass) obj;
        if (bc == null) {
            return arg;
        }
        return arg;
    }

    @Test
    public void run0() throws Throwable {
        runTest("test", 0);
    }

    @Test
    public void run1() throws Throwable {
        runTest("test", 2);
    }

    @Test
    public void run2() throws Throwable {
        runTest("test", 3);
    }

    @Test
    public void run3() throws Throwable {
        runTest("test", 4);
    }

}
