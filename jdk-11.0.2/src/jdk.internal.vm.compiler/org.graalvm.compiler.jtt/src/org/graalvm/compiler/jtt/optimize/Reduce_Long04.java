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


package org.graalvm.compiler.jtt.optimize;

import org.junit.Test;

import org.graalvm.compiler.jtt.JTTTest;

/*
 * Tests constant folding of integer operations.
 */
public class Reduce_Long04 extends JTTTest {

    public static long test(long arg) {
        if (arg == 0) {
            return mul0(arg + 10);
        }
        if (arg == 1) {
            return mul1(arg + 9);
        }
        return 0;
    }

    public static long mul0(long x) {
        return x * 4;
    }

    public static long mul1(long x) {
        return x * 8589934592L;
    }

    @Test
    public void run0() throws Throwable {
        runTest("test", 0L);
    }

    @Test
    public void run1() throws Throwable {
        runTest("test", 1L);
    }

}
