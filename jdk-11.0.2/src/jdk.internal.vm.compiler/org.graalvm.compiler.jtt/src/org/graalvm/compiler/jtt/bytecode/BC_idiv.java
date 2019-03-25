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


package org.graalvm.compiler.jtt.bytecode;

import org.junit.Test;

import org.graalvm.compiler.jtt.JTTTest;

/*
 */
public class BC_idiv extends JTTTest {

    public static int test(int a, int b) {
        return a / b;
    }

    @Test
    public void run0() throws Throwable {
        runTest("test", 1, 2);
    }

    @Test
    public void run1() throws Throwable {
        runTest("test", 2, -1);
    }

    @Test
    public void run2() throws Throwable {
        runTest("test", 256, 4);
    }

    @Test
    public void run3() throws Throwable {
        runTest("test", 135, 7);
    }

    public static int testStrictlyPositive(int b) {
        return 64 / ((b & 7) + 1);
    }

    @Test
    public void run4() throws Throwable {
        runTest("testStrictlyPositive", 6);
    }

}
