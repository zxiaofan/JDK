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

/*
 */
public class BC_ldiv_overflow extends JTTTest {

    public static long test(long a, long b) {
        return a / (b | 1);
    }

    @Test
    public void run0() throws Throwable {
        runTest("test", Long.MIN_VALUE, -1L);
    }

    @Test
    public void run1() throws Throwable {
        runTest("test", Long.MIN_VALUE, 1L);
    }

}
