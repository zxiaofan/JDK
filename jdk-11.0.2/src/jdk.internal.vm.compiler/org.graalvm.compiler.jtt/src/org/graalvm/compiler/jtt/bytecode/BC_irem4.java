/*
 * Copyright (c) 2017, Oracle and/or its affiliates. All rights reserved.
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

public class BC_irem4 extends JTTTest {

    public static int test(int a) {
        return a % 8;
    }

    @Test
    public void run0() throws Throwable {
        runTest("test", -1);
    }

    @Test
    public void run1() throws Throwable {
        runTest("test", -2);
    }

    @Test
    public void run2() throws Throwable {
        runTest("test", -8);
    }

    @Test
    public void run3() throws Throwable {
        runTest("test", 16);
    }

    @Test
    public void run4() throws Throwable {
        runTest("test", -16);
    }

    @Test
    public void run5() throws Throwable {
        runTest("test", -23);
    }

    @Test
    public void run6() throws Throwable {
        runTest("test", 23);
    }
}
