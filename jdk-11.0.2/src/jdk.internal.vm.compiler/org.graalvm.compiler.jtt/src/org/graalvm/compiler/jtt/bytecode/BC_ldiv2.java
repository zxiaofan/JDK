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


package org.graalvm.compiler.jtt.bytecode;

import org.junit.Test;

import org.graalvm.compiler.jtt.JTTTest;

/*
 */
public class BC_ldiv2 extends JTTTest {

    public static long MIN = Long.MIN_VALUE;
    public static long MAX = Long.MAX_VALUE;

    public static long test(long a, long b) {
        return a / b;
    }

    @Test
    public void run0() throws Throwable {
        runTest("test", MIN, -1L);
    }

    @Test
    public void run1() throws Throwable {
        runTest("test", MIN, 1L);
    }

    @Test
    public void run2() throws Throwable {
        runTest("test", MIN, MAX);
    }
}
