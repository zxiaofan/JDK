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
public class BC_ldiv3 extends JTTTest {

    public static long PLUS7 = 7;
    public static long PLUS3 = 3;
    public static long MIN7 = -7;
    public static long MIN3 = -3;

    public static long test(long a, long b) {
        return a / b;
    }

    @Test
    public void run0() throws Throwable {
        runTest("test", PLUS7, 2L);
        runTest("test", PLUS3, 2L);
        runTest("test", MIN7, 2L);
        runTest("test", MIN3, 2L);
    }

    @Test
    public void run1() throws Throwable {
        runTest("test", PLUS7, -4L);
        runTest("test", PLUS3, -4L);
        runTest("test", MIN7, -4L);
        runTest("test", MIN3, -4L);
    }
}
