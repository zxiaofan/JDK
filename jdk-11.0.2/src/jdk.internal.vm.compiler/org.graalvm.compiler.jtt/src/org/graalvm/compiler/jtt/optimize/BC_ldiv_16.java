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


package org.graalvm.compiler.jtt.optimize;

import org.junit.Test;

import org.graalvm.compiler.jtt.JTTTest;

/*
 */
public class BC_ldiv_16 extends JTTTest {

    public static long test(long arg) {
        return arg / 16;
    }

    @Test
    public void run0() throws Throwable {
        runTest("test", 0L);
    }

    @Test
    public void run1() throws Throwable {
        runTest("test", 16L);
    }

    @Test
    public void run2() throws Throwable {
        runTest("test", 17L);
    }

    @Test
    public void run3() throws Throwable {
        runTest("test", -1L);
    }

    @Test
    public void run4() throws Throwable {
        runTest("test", -16L);
    }

    @Test
    public void run5() throws Throwable {
        runTest("test", -17L);
    }

    @Test
    public void run6() throws Throwable {
        runTest("test", -1024L);
    }

}
