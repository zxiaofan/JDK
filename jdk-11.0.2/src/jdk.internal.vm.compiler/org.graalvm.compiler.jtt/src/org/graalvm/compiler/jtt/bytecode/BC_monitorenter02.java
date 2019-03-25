/*
 * Copyright (c) 2010, 2012, Oracle and/or its affiliates. All rights reserved.
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
public class BC_monitorenter02 extends JTTTest {

    static DummyTestClass object = new DummyTestClass();

    public static int test(int arg, int arg2) {
        int result = arg;
        synchronized (object) {
            result = arg / arg2;
        }
        synchronized (object) {
            result = arg / arg2;
        }
        return result;
    }

    @Test
    public void run0() throws Throwable {
        runTest("test", 0, 1);
    }

    @Test
    public void run1() throws Throwable {
        runTest("test", 1, 1);
    }

    @Test
    public void run2() throws Throwable {
        runTest("test", -2, 1);
    }

}
