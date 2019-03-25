/*
 * Copyright (c) 2013, Oracle and/or its affiliates. All rights reserved.
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
public class BC_lshr02 extends JTTTest {

    public static long test0(long arg) {
        long a = arg >> 32;
        return a >> 32;
    }

    @Test
    public void run0a() throws Throwable {
        runTest("test0", 1L);
    }

    @Test
    public void run0b() throws Throwable {
        runTest("test0", 0L);
    }

    @Test
    public void run0c() throws Throwable {
        runTest("test0", -1L);
    }

    @Test
    public void run0d() throws Throwable {
        runTest("test0", Long.MAX_VALUE);
    }

    @Test
    public void run0e() throws Throwable {
        runTest("test0", Long.MIN_VALUE);
    }

    /* testcase for a postive stamp */
    public static int test1(long[] arg) {
        int a = arg.length >> 16;
        return a >> 16;
    }

    @Test
    public void run1a() throws Throwable {
        long[] arg = new long[0x100];
        runTest("test1", arg);
    }

    /* testcase for a strictly negative stamp */
    public static int test2(long[] arg) {
        int a = (-arg.length - 1) >> 16;
        return a >> 16;
    }

    @Test
    public void run2a() throws Throwable {
        long[] arg = new long[0x100];
        runTest("test2", arg);
    }
}
