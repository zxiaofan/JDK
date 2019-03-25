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
public class BC_idiv_4 extends JTTTest {

    public static int test(int arg) {
        return arg / 4;
    }

    @Test
    public void run0() throws Throwable {
        runTest("test", 0);
    }

    @Test
    public void run1() throws Throwable {
        runTest("test", 4);
    }

    @Test
    public void run2() throws Throwable {
        runTest("test", 5);
    }

    @Test
    public void run3() throws Throwable {
        runTest("test", -1);
    }

    @Test
    public void run4() throws Throwable {
        runTest("test", -4);
    }

    @Test
    public void run5() throws Throwable {
        runTest("test", -5);
    }

    @Test
    public void run6() throws Throwable {
        runTest("test", -256);
    }

}
