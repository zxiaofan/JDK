/*
 * Copyright (c) 2007, 2012, Oracle and/or its affiliates. All rights reserved.
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


package org.graalvm.compiler.jtt.bytecode;

import org.junit.Test;

import org.graalvm.compiler.jtt.JTTTest;

/*
 */
public class BC_i2b extends JTTTest {

    public static byte test(int a) {
        return (byte) a;
    }

    @Test
    public void run0() throws Throwable {
        runTest("test", -1);
    }

    @Test
    public void run1() throws Throwable {
        runTest("test", 2);
    }

    @Test
    public void run2() throws Throwable {
        runTest("test", 255);
    }

    @Test
    public void run3() throws Throwable {
        runTest("test", 128);
    }

    public static int testInt(int a) {
        return (byte) a;
    }

    @Test
    public void runI0() throws Throwable {
        runTest("testInt", -1);
    }

    @Test
    public void runI1() throws Throwable {
        runTest("testInt", 2);
    }

    @Test
    public void runI2() throws Throwable {
        runTest("testInt", 255);
    }

    @Test
    public void runI3() throws Throwable {
        runTest("testInt", 128);
    }

    public static long testLong(int a) {
        return (byte) a;
    }

    @Test
    public void runL0() throws Throwable {
        runTest("testLong", -1);
    }

    @Test
    public void runL1() throws Throwable {
        runTest("testLong", 2);
    }

    @Test
    public void runL2() throws Throwable {
        runTest("testLong", 255);
    }

    @Test
    public void runL3() throws Throwable {
        runTest("testLong", 128);
    }
}
