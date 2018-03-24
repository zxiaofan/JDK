/*
 * Copyright (c) 2011, 2012, Oracle and/or its affiliates. All rights reserved.
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

import org.junit.Ignore;
import org.junit.Test;

import org.graalvm.compiler.jtt.JTTTest;

/*
 */
public class Math_exp extends JTTTest {

    public static double test(double arg) {
        return Math.exp(arg);
    }

    @Test
    public void run0() {
        runTest("test", java.lang.Double.NaN);
    }

    @Test
    public void run1() {
        runTest("test", java.lang.Double.NEGATIVE_INFINITY);
    }

    @Test
    public void run2() {
        runTest("test", java.lang.Double.POSITIVE_INFINITY);
    }

    @Test
    public void run3() {
        runTest("test", -1D);
    }

    @Test
    public void run4() {
        runTest("test", -0.0D);
    }

    @Test
    public void run5() {
        runTest("test", 0.0D);
    }

    @Ignore("java.lang.AssertionError: expected:<2.718281828459045> but was:<2.7182818284590455>")
    @Test
    public void run6() {
        runTest("test", 1.0D);
    }
}
