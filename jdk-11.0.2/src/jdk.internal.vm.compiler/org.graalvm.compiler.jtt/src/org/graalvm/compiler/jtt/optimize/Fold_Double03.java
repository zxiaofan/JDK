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
 */
public class Fold_Double03 extends JTTTest {

    private static final double MINUS_ZERO = 1 / Double.NEGATIVE_INFINITY;

    public static double test(int t, double a) {
        double v;
        if (t == 0) {
            v = a * 0.0;
        } else {
            v = a * MINUS_ZERO;
        }
        return 1 / v;
    }

    @Test
    public void run0() throws Throwable {
        runTest("test", 0, 5.0);
    }

    @Test
    public void run1() throws Throwable {
        runTest("test", 1, 5.0);
    }

    @Test
    public void run2() throws Throwable {
        runTest("test", 0, -5.0);
    }

    @Test
    public void run3() throws Throwable {
        runTest("test", 1, -5.0);
    }

}
