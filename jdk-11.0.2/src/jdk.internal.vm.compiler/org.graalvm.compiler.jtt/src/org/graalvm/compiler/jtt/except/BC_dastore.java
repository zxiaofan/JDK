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

public class BC_dastore extends JTTTest {

    static double[] arr = {0, 0, 0, 0};

    public static double test(int arg, double val) {
        final double[] array = arg == -2 ? null : arr;
        array[arg] = val;
        return array[arg];
    }

    @Test
    public void run0() throws Throwable {
        runTest("test", -2, 0.01d);
    }

    @Test
    public void run1() throws Throwable {
        runTest("test", -1, -1.4d);
    }

    @Test
    public void run2() throws Throwable {
        runTest("test", 0, 0.01d);
    }

    @Test
    public void run3() throws Throwable {
        runTest("test", 4, 0.01d);
    }

}
