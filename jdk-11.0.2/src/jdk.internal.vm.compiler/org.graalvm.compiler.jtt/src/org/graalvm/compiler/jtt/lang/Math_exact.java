/*
 * Copyright (c) 2015, 2015, Oracle and/or its affiliates. All rights reserved.
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
public class Math_exact extends JTTTest {

    public static int testIntAddExact(int a, int b) {
        return Math.addExact(a, b);
    }

    @Test
    public void runTestIntAddExact() throws Throwable {
        runTest("testIntAddExact", 1, 2);
        runTest("testIntAddExact", 1, Integer.MAX_VALUE);
        runTest("testIntAddExact", -1, Integer.MIN_VALUE);
    }

    public static long testLongAddExact(long a, long b) {
        return Math.addExact(a, b);
    }

    @Test
    public void runTestLongAddExact() throws Throwable {
        runTest("testLongAddExact", 1L, 2L);
        runTest("testLongAddExact", 1L, Long.MAX_VALUE);
        runTest("testLongAddExact", -1L, Long.MIN_VALUE);
    }

    public static int testIntSubExact(int a, int b) {
        return Math.subtractExact(a, b);
    }

    @Test
    public void runTestIntSubExact() throws Throwable {
        runTest("testIntSubExact", 1, 2);
        runTest("testIntSubExact", -2, Integer.MAX_VALUE);
        runTest("testIntSubExact", 2, Integer.MIN_VALUE);
    }

    public static long testLongSubExact(long a, long b) {
        return Math.subtractExact(a, b);
    }

    @Test
    public void runTestLongSubExact() throws Throwable {
        runTest("testLongSubExact", 1L, 2L);
        runTest("testLongSubExact", -2L, Long.MAX_VALUE);
        runTest("testLongSubExact", 2L, Long.MIN_VALUE);
    }

    public static int testIntMulExact(int a, int b) {
        return Math.multiplyExact(a, b);
    }

    @Test
    public void runTestIntMulExact() throws Throwable {
        runTest("testIntMulExact", 1, 2);
        runTest("testIntMulExact", -2, Integer.MAX_VALUE);
        runTest("testIntMulExact", 2, Integer.MIN_VALUE);
    }

    public static long testLongMulExact(long a, long b) {
        return Math.multiplyExact(a, b);
    }

    @Test
    public void runTestLongMulExact() throws Throwable {
        runTest("testLongMulExact", 1L, 2L);
        runTest("testLongMulExact", 2L, Long.MAX_VALUE);
        runTest("testLongMulExact", -2L, Long.MIN_VALUE);
    }
}
