/*
 * Copyright (c) 2007, 2016, Oracle and/or its affiliates. All rights reserved.
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
public class BC_dneg extends JTTTest {

    public static double test(double a, double b, int which) {
        double result1 = -a;
        double result2 = -b;
        double result = 0.0;
        if (which == 0) {
            result = result1;
        } else {
            result = result2;
        }
        return result;
    }

    @Test
    public void run0() throws Throwable {
        runTest("test", 0.0d, 1.0d, 0);
    }

    @Test
    public void run1() throws Throwable {
        runTest("test", -1.01d, -2.01d, 0);
    }

    @Test
    public void run2() throws Throwable {
        runTest("test", 7263.8734d, 8263.8734d, 0);
    }

    @Test
    public void run3() throws Throwable {
        runTest("test", 0.0d, 1.0d, 1);
    }

    @Test
    public void run4() throws Throwable {
        runTest("test", -1.01d, -2.01d, 1);
    }

    @Test
    public void run5() throws Throwable {
        runTest("test", 7263.8734d, 8263.8734d, 1);
    }

    public static double test2(double a, double b) {
        return -(a - b);
    }

    @Test
    public void run6() throws Throwable {
        runTest("test2", -1.0d, -1.0d);
    }
}
