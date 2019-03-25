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
public class BC_ladd extends JTTTest {

    public static long test(long a, long b) {
        return a + b;
    }

    @Test
    public void run0() throws Throwable {
        runTest("test", 1L, 2L);
    }

    @Test
    public void run1() throws Throwable {
        runTest("test", 0L, -1L);
    }

    @Test
    public void run2() throws Throwable {
        runTest("test", 33L, 67L);
    }

    @Test
    public void run3() throws Throwable {
        runTest("test", 1L, -1L);
    }

    @Test
    public void run4() throws Throwable {
        runTest("test", -2147483648L, 1L);
    }

    @Test
    public void run5() throws Throwable {
        runTest("test", 2147483647L, 1L);
    }

    @Test
    public void run6() throws Throwable {
        runTest("test", -2147483647L, -2L);
    }

}
