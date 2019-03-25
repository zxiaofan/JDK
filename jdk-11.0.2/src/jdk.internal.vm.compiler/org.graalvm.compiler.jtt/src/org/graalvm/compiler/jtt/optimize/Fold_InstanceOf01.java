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
public class Fold_InstanceOf01 extends JTTTest {

    static final Object object = new DummyTestClass();

    public static boolean test(int arg) {
        if (arg == 0) {
            return object instanceof DummyTestClass;
        }
        if (arg == 1) {
            Object obj = new DummyTestClass();
            return obj instanceof DummyTestClass;
        }
        if (arg == 2) {
            return null instanceof DummyTestClass;
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
