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
public class Fold_Convert02 extends JTTTest {

    public static long test(long arg) {
        if (arg == 0) {
            return i2l();
        }
        if (arg == 1) {
            return f2l();
        }
        if (arg == 2) {
            return d2l();
        }
        return 0;
    }

    public static long i2l() {
        int x = 0x80000000;
        return x;
    }

    public static long f2l() {
        float x = -33.1f;
        return (long) x;
    }

    public static long d2l() {
        double x = -78.1d;
        return (long) x;
    }

    @Test
    public void run0() throws Throwable {
        runTest("test", 0L);
    }

    @Test
    public void run1() throws Throwable {
        runTest("test", 1L);
    }

    @Test
    public void run2() throws Throwable {
        runTest("test", 2L);
    }

}
