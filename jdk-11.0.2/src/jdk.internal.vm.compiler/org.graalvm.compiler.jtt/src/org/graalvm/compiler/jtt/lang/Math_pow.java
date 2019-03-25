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

import org.graalvm.compiler.jtt.JTTTest;
import org.graalvm.compiler.options.OptionValues;
import org.junit.Test;

import jdk.vm.ci.meta.ResolvedJavaMethod;

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

    private static final long STEP = Long.MAX_VALUE / 1_000_000;

    @Test
    public void run11() {
        OptionValues options = getInitialOptions();
        ResolvedJavaMethod method = getResolvedJavaMethod("test");
        Object receiver = null;
        long testIteration = 0;
        for (long l = Long.MIN_VALUE;; l += STEP) {
            double x = Double.longBitsToDouble(l);
            double y = x;
            testOne(options, method, receiver, testIteration, l, x, y);
            y = l < 0 ? Double.longBitsToDouble(Long.MAX_VALUE + l) : Double.longBitsToDouble(Long.MAX_VALUE - l);
            testOne(options, method, receiver, testIteration, l, x, y);
            if (Long.MAX_VALUE - STEP < l) {
                break;
            }
            testIteration++;
        }
    }

    @Test
    public void run12() {
        long l = 4355599093822972882L;
        double x = Double.longBitsToDouble(l);
        OptionValues options = getInitialOptions();
        ResolvedJavaMethod method = getResolvedJavaMethod("test");
        Object receiver = null;
        testOne(options, method, receiver, 1, l, x, x);
    }

    private void testOne(OptionValues options, ResolvedJavaMethod method, Object receiver, long testIteration, long l, double x, double y) throws AssertionError {
        Result expect = executeExpected(method, receiver, x, y);
        try {
            testAgainstExpected(options, method, expect, EMPTY, receiver, x, y);
        } catch (AssertionError e) {
            throw new AssertionError(String.format("%d: While testing %g [long: %d, hex: %x]", testIteration, x, l, l), e);
        }
    }
}
