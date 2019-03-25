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
public class BC_imul_16 extends JTTTest {

    public static int test(int i, int arg) {
        if (i == 0) {
            final int mult = 16;
            return arg * mult;
        }
        return arg * 16;
    }

    @Test
    public void run0() throws Throwable {
        runTest("test", 0, 0);
    }

    @Test
    public void run1() throws Throwable {
        runTest("test", 0, 16);
    }

    @Test
    public void run2() throws Throwable {
        runTest("test", 0, 17);
    }

    @Test
    public void run3() throws Throwable {
        runTest("test", 0, -1);
    }

    @Test
    public void run4() throws Throwable {
        runTest("test", 0, -16);
    }

    @Test
    public void run5() throws Throwable {
        runTest("test", 0, -17);
    }

    @Test
    public void run6() throws Throwable {
        runTest("test", 0, 2147483647);
    }

    @Test
    public void run7() throws Throwable {
        runTest("test", 0, -2147483648);
    }

    @Test
    public void run8() throws Throwable {
        runTest("test", 1, 0);
    }

    @Test
    public void run9() throws Throwable {
        runTest("test", 1, 16);
    }

    @Test
    public void run10() throws Throwable {
        runTest("test", 1, 17);
    }

    @Test
    public void run11() throws Throwable {
        runTest("test", 1, -1);
    }

    @Test
    public void run12() throws Throwable {
        runTest("test", 1, -16);
    }

    @Test
    public void run13() throws Throwable {
        runTest("test", 1, -17);
    }

    @Test
    public void run14() throws Throwable {
        runTest("test", 1, 2147483647);
    }

    @Test
    public void run15() throws Throwable {
        runTest("test", 1, -2147483648);
    }

}
