/*
 * Copyright (c) 2014, 2015, Oracle and/or its affiliates. All rights reserved.
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

import org.graalvm.compiler.core.common.calc.UnsignedMath;
import org.graalvm.compiler.core.test.GraalCompilerTest;

/**
 * Tests the substitutions for the {@link UnsignedMath} class.
 */
public class UnsignedMathTest extends GraalCompilerTest {

    public static boolean aboveThanInt(int a, int b) {
        return UnsignedMath.aboveThan(a, b);
    }

    public static boolean aboveOrEqualInt(int a, int b) {
        return UnsignedMath.aboveOrEqual(a, b);
    }

    public static boolean belowThanInt(int a, int b) {
        return UnsignedMath.belowThan(a, b);
    }

    public static boolean belowOrEqualInt(int a, int b) {
        return UnsignedMath.belowOrEqual(a, b);
    }

    public static int divideInt(int a, int b) {
        return Integer.divideUnsigned(a, b);
    }

    public static int remainderInt(int a, int b) {
        return Integer.remainderUnsigned(a, b);
    }

    public static boolean aboveThanLong(long a, long b) {
        return UnsignedMath.aboveThan(a, b);
    }

    public static boolean aboveOrEqualLong(long a, long b) {
        return UnsignedMath.aboveOrEqual(a, b);
    }

    public static boolean belowThanLong(long a, long b) {
        return UnsignedMath.belowThan(a, b);
    }

    public static boolean belowOrEqualLong(long a, long b) {
        return UnsignedMath.belowOrEqual(a, b);
    }

    public static long divideLong(long a, long b) {
        return Long.divideUnsigned(a, b);
    }

    public static long remainderLong(long a, long b) {
        return Long.remainderUnsigned(a, b);
    }

    private void testInt(int a, int b) {
        test("aboveThanInt", a, b);
        test("aboveOrEqualInt", a, b);
        test("belowThanInt", a, b);
        test("belowOrEqualInt", a, b);
        test("divideInt", a, b);
        test("remainderInt", a, b);
    }

    private void testLong(long a, long b) {
        test("aboveThanLong", a, b);
        test("aboveOrEqualLong", a, b);
        test("belowThanLong", a, b);
        test("belowOrEqualLong", a, b);
        test("divideLong", a, b);
        test("remainderLong", a, b);
    }

    @Test
    public void testInt() {
        testInt(5, 7);
        testInt(-3, -7);
        testInt(-3, 7);
        testInt(42, -5);
    }

    @Test
    public void testLong() {
        testLong(5, 7);
        testLong(-3, -7);
        testLong(-3, 7);
        testLong(42, -5);
    }
}
