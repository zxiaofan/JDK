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

public class BC_l2i extends JTTTest {

    public static int test(long a) {
        return (int) a;
    }

    @Test
    public void run0() throws Throwable {
        runTest("test", 1L);
    }

    @Test
    public void run1() throws Throwable {
        runTest("test", 2L);
    }

    @Test
    public void run2() throws Throwable {
        runTest("test", 3L);
    }

    @Test
    public void run3() throws Throwable {
        runTest("test", -1L);
    }

    @Test
    public void run4() throws Throwable {
        runTest("test", -2147483647L);
    }

    @Test
    public void run5() throws Throwable {
        runTest("test", -2147483648L);
    }

    @Test
    public void run6() throws Throwable {
        runTest("test", 2147483647L);
    }

}
