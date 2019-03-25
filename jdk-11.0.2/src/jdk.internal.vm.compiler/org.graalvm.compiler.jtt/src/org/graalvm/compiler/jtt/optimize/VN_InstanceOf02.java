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
 * Tests value numbering of instanceof operations.
 */
public class VN_InstanceOf02 extends JTTTest {

    private static boolean cond = true;

    static final Object object = new DummyTestClass();

    public static boolean test(int arg) {
        if (arg == 0) {
            return foo1();
        }
        if (arg == 1) {
            return foo2();
        }
        if (arg == 2) {
            return foo3();
        }
        // do nothing
        return false;
    }

    private static boolean foo1() {
        boolean a = object instanceof DummyTestClass;
        if (cond) {
            boolean b = object instanceof DummyTestClass;
            return a | b;
        }
        return false;
    }

    private static boolean foo2() {
        Object obj = new DummyTestClass();
        boolean a = obj instanceof DummyTestClass;
        if (cond) {
            boolean b = obj instanceof DummyTestClass;
            return a | b;
        }
        return false;
    }

    private static boolean foo3() {
        boolean a = null instanceof DummyTestClass;
        if (cond) {
            boolean b = null instanceof DummyTestClass;
            return a | b;
        }
        return false;
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
