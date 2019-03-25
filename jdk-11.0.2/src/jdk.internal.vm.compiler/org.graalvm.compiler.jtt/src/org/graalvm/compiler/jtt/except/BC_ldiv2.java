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
/*
 */



package org.graalvm.compiler.jtt.except;

import org.junit.Test;

import org.graalvm.compiler.jtt.JTTTest;

public class BC_ldiv2 extends JTTTest {

    public static long test(long a, long b) {
        try {
            return a / b;
        } catch (Exception e) {
            return -11;
        }
    }

    @Test
    public void run0() throws Throwable {
        runTest("test", 1L, 2L);
    }

    @Test
    public void run1() throws Throwable {
        runTest("test", 11L, 0L);
    }

    @Test
    public void run2() throws Throwable {
        runTest("test", 11L, 1000000000000L);
    }

    @Test
    public void run3() throws Throwable {
        runTest("test", 1000000000000L, 11L);
    }

    @Test
    public void run4() throws Throwable {
        runTest("test", 1000000000000L, 0L);
    }

}
