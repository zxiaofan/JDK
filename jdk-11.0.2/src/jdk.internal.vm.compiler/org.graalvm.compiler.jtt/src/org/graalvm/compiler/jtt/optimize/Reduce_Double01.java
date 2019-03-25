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
 * Tests optimization of double operations.
 */
public class Reduce_Double01 extends JTTTest {

    public static double test(double arg) {
        if (arg == 0) {
            return add(10);
        }
        if (arg == 1) {
            return sub(11);
        }
        if (arg == 2) {
            return mul(12);
        }
        if (arg == 3) {
            return div(13);
        }
        return 0;
    }

    public static double add(double x) {
        return x + 0;
    }

    public static double sub(double x) {
        return x - 0;
    }

    public static double mul(double x) {
        return x * 1;
    }

    public static double div(double x) {
        return x / 1;
    }

    @Test
    public void run0() throws Throwable {
        runTest("test", 0d);
    }

    @Test
    public void run1() throws Throwable {
        runTest("test", 1d);
    }

    @Test
    public void run2() throws Throwable {
        runTest("test", 2d);
    }

    @Test
    public void run3() throws Throwable {
        runTest("test", 3d);
    }

}
