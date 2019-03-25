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
public class Fold_Long01 extends JTTTest {

    public static long test(long arg) {
        if (arg == 0) {
            return add();
        }
        if (arg == 1) {
            return sub();
        }
        if (arg == 2) {
            return mul();
        }
        if (arg == 3) {
            return div();
        }
        if (arg == 4) {
            return mod();
        }
        if (arg == 5) {
            return and();
        }
        if (arg == 6) {
            return or();
        }
        if (arg == 7) {
            return xor();
        }
        return 0;
    }

    public static long add() {
        long x = 3;
        return x + 7;
    }

    public static long sub() {
        long x = 15;
        return x - 4;
    }

    public static long mul() {
        long x = 6;
        return x * 2;
    }

    public static long div() {
        long x = 26;
        return x / 2;
    }

    public static long mod() {
        long x = 29;
        return x % 15;
    }

    public static long and() {
        long x = 31;
        return x & 15;
    }

    public static long or() {
        long x = 16;
        return x | 16;
    }

    public static long xor() {
        long x = 0;
        return x ^ 17;
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

    @Test
    public void run3() throws Throwable {
        runTest("test", 3L);
    }

    @Test
    public void run4() throws Throwable {
        runTest("test", 4L);
    }

    @Test
    public void run5() throws Throwable {
        runTest("test", 5L);
    }

    @Test
    public void run6() throws Throwable {
        runTest("test", 6L);
    }

    @Test
    public void run7() throws Throwable {
        runTest("test", 7L);
    }

}
