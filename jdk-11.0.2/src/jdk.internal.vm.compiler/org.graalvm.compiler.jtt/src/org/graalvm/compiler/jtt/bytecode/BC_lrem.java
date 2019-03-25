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
public class BC_lrem extends JTTTest {

    public static long test(long a, long b) {
        return a % b;
    }

    @Test
    public void run0() throws Throwable {
        runTest("test", 1L, 2L);
    }

    @Test
    public void run1() throws Throwable {
        runTest("test", 2L, -1L);
    }

    @Test
    public void run2() throws Throwable {
        runTest("test", 256L, 4L);
    }

    @Test
    public void run3() throws Throwable {
        runTest("test", 135L, 7L);
    }

}
