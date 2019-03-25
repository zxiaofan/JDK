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

public class BC_arraylength extends JTTTest {

    static int[] arr = {1, 2, 3};
    static char[] arr2 = {'a', 'b', 'c', 'd'};
    static Object[] arr3 = new Object[5];

    @SuppressWarnings("all")
    public static int test(int arg) {
        if (arg == 0) {
            int[] array = null;
            return array.length;
        }
        if (arg == 1) {
            return arr.length;
        }
        if (arg == 2) {
            return arr2.length;
        }
        if (arg == 3) {
            return arr3.length;
        }
        return 42;
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

    @Test
    public void run4() throws Throwable {
        runTest("test", 4);
    }

}
