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
 * Tests value numbering of long operations.
 */
public class VN_Long03 extends JTTTest {

    private static boolean cond = true;

    public static long test(int arg) {
        if (arg == 0) {
            return add(arg);
        }
        if (arg == 1) {
            return sub(arg);
        }
        if (arg == 2) {
            return mul(arg);
        }
        if (arg == 3) {
            return div(arg);
        }
        if (arg == 4) {
            return mod(arg);
        }
        if (arg == 5) {
            return and(arg);
        }
        if (arg == 6) {
            return or(arg);
        }
        if (arg == 7) {
            return xor(arg);
        }
        return 0;
    }

    public static long add(long x) {
        long t = x + 3;
        if (cond) {
            long u = x + 3;
            return t + u;
        }
        return 3;
    }

    public static long sub(long x) {
        long t = x - 3;
        if (cond) {
            long u = x - 3;
            return t - u;
        }
        return 3;
    }

    public static long mul(long x) {
        long t = x * 3;
        if (cond) {
            long u = x * 3;
            return t * u;
        }
        return 3;
    }

    public static long div(long x) {
        long t = 9 / x;
        if (cond) {
            long u = 9 / x;
            return t / u;
        }
        return 9;
    }

    public static long mod(long x) {
        long t = 7 % x;
        if (cond) {
            long u = 7 % x;
            return t % u;
        }
        return 7;
    }

    public static long and(long x) {
        long t = 7 & x;
        if (cond) {
            long u = 7 & x;
            return t & u;
        }
        return 7;
    }

    public static long or(long x) {
        long t = 7 | x;
        if (cond) {
            long u = 7 | x;
            return t | u;
        }
        return 7;
    }

    public static long xor(long x) {
        long t = 7 ^ x;
        if (cond) {
            long u = 7 ^ x;
            return t ^ u;
        }
        return 7;
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

    @Test
    public void run6() throws Throwable {
        runTest("test", 6);
    }

    @Test
    public void run7() throws Throwable {
        runTest("test", 7);
    }

}
