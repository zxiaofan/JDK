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
package org.graalvm.compiler.jtt.lang;

import org.junit.Test;

import org.graalvm.compiler.jtt.JTTTest;

/*
 */
public class Math_pow extends JTTTest {

    public static double test(double x, double y) {
        return Math.pow(x, y);
    }

    @Test
    public void run0() throws Throwable {
        runTest("test", 2d, 0d);
    }

    @Test
    public void run1() throws Throwable {
        runTest("test", 2d, 0.5d);
    }

    @Test
    public void run2() throws Throwable {
        runTest("test", -2d, 0.5d);
    }

    @Test
    public void run3() throws Throwable {
        runTest("test", 2d, 1d);
    }

    @Test
    public void run4() throws Throwable {
        runTest("test", 2d, -1d);
    }

    @Test
    public void run5() throws Throwable {
        runTest("test", 2d, 2d);
    }

    @Test
    public void run6() throws Throwable {
        runTest("test", 2d, 3.1d);
    }

    @Test
    public void run7() throws Throwable {
        runTest("test", 2d, Double.NaN);
    }

    @Test
    public void run8() throws Throwable {
        runTest("test", Double.NaN, 0d);
    }

    @Test
    public void run9() throws Throwable {
        runTest("test", Double.NaN, 23d);
    }

    @Test
    public void run10() throws Throwable {
        runTest("test", 0.999998, 1500000.0);
    }
}
