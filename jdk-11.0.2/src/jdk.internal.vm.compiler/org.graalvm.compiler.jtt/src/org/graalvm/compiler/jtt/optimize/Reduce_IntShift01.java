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
 * Tests optimization of integer operations.
 */
public class Reduce_IntShift01 extends JTTTest {

    public static int test(int arg) {
        if (arg == 0) {
            return shift0(arg + 10);
        }
        if (arg == 1) {
            return shift1(arg + 10);
        }
        if (arg == 2) {
            return shift2(arg + 10);
        }
        if (arg == 3) {
            return shift3(arg + 10);
        }
        if (arg == 4) {
            return shift4(arg + 10);
        }
        if (arg == 5) {
            return shift5(arg + 10);
        }
        return 0;
    }

    public static int shift0(int x) {
        return x >> 0;
    }

    public static int shift1(int x) {
        return x >>> 0;
    }

    public static int shift2(int x) {
        return x << 0;
    }

    public static int shift3(int x) {
        return x >> 64;
    }

    public static int shift4(int x) {
        return x >>> 64;
    }

    public static int shift5(int x) {
        return x << 64;
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

    @Test
    public void run5() throws Throwable {
        runTest("test", 5);
    }

}
