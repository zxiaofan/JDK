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


package org.graalvm.compiler.replacements.test;

import org.junit.Test;

import org.graalvm.compiler.core.test.GraalCompilerTest;

/**
 * Tests the unsigned operations on {@link Integer} and {@link Long}.
 */
public class UnsignedIntegerTest extends GraalCompilerTest {

    public static int compareInteger(int a, int b) {
        return Integer.compareUnsigned(a, b);
    }

    public static int divideInteger(int a, int b) {
        return Integer.divideUnsigned(a, b);
    }

    public static int remainderInteger(int a, int b) {
        return Integer.remainderUnsigned(a, b);
    }

    public static long compareLong(long a, long b) {
        return Long.compareUnsigned(a, b);
    }

    public static long divideLong(long a, long b) {
        return Long.divideUnsigned(a, b);
    }

    public static long remainderLong(long a, long b) {
        return Long.remainderUnsigned(a, b);
    }

    private void testInteger(int a, int b) {
        test("compareInteger", a, b);
        test("divideInteger", a, b);
        test("remainderInteger", a, b);
    }

    private void testLong(long a, long b) {
        test("compareLong", a, b);
        test("divideLong", a, b);
        test("remainderLong", a, b);
    }

    @Test
    public void testInteger() {
        testInteger(5, 7);
        testInteger(-3, -7);
        testInteger(-3, 7);
        testInteger(42, -5);
    }

    @Test
    public void testLong() {
        testLong(5, 7);
        testLong(-3, -7);
        testLong(-3, 7);
        testLong(42, -5);
    }
}
