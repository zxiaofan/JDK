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


package org.graalvm.compiler.jtt.jdk;

import org.junit.Test;

import org.graalvm.compiler.jtt.JTTTest;

public class DivideUnsigned extends JTTTest {

    public static int divUInt(int a, int b) {
        return Integer.divideUnsigned(a, b);
    }

    public static int remUInt(int a, int b) {
        return Integer.remainderUnsigned(a, b);
    }

    public static long divULong(long a, long b) {
        return Long.divideUnsigned(a, b);
    }

    public static long remULong(long a, long b) {
        return Long.remainderUnsigned(a, b);
    }

    public void testInt(int a, int b) {
        runTest("divUInt", a, b);
        runTest("remUInt", a, b);
    }

    public void testLong(long a, long b) {
        runTest("divULong", a, b);
        runTest("remULong", a, b);
    }

    @Test
    public void testIntPP() {
        testInt(5, 2);
    }

    @Test
    public void testIntNP() {
        testInt(-5, 2);
    }

    @Test
    public void testIntPN() {
        testInt(5, -2);
    }

    @Test
    public void testIntNN() {
        testInt(-5, -2);
    }

    @Test
    public void testLongPP() {
        testLong(5, 2);
    }

    @Test
    public void testLongNP() {
        testLong(-5, 2);
    }

    @Test
    public void testLongPN() {
        testLong(5, -2);
    }

    @Test
    public void testLongNN() {
        testLong(-5, -2);
    }
}
