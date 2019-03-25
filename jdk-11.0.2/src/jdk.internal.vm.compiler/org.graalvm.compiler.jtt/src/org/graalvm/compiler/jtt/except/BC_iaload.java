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

public class BC_iaload extends JTTTest {

    static int[] arr = {0, -1, 4, 1000000000};

    public static int test(int arg) {
        final int[] array = arg == -2 ? null : arr;
        return array[arg];
    }

    @Test
    public void run0() throws Throwable {
        runTest("test", -2);
    }

    @Test
    public void run1() throws Throwable {
        runTest("test", -1);
    }

    @Test
    public void run2() throws Throwable {
        runTest("test", 0);
    }

    @Test
    public void run3() throws Throwable {
        runTest("test", 4);
    }

    @Test
    public void run4() throws Throwable {
        runTest("test", Integer.MIN_VALUE);
    }
}
