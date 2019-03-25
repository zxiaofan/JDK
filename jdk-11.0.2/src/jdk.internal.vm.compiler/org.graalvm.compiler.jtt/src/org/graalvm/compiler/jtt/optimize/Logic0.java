/*
 * Copyright (c) 2011, 2012, Oracle and/or its affiliates. All rights reserved.
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
public class Logic0 extends JTTTest {

    public static int test(int a, int b) {
        if (((a != 0 ? 1 : 0) & (a != b ? 1 : 0)) != 0) {
            return 42;
        }
        return 11;
    }

    @Test
    public void run0() throws Throwable {
        runTest("test", 0, 0);
    }

    @Test
    public void run1() throws Throwable {
        runTest("test", 0, 33);
    }

    @Test
    public void run2() throws Throwable {
        runTest("test", 33, 66);
    }

    @Test
    public void run3() throws Throwable {
        runTest("test", 33, 67);
    }

    @Test
    public void run4() throws Throwable {
        runTest("test", 33, 33);
    }

    @Test
    public void run5() throws Throwable {
        runTest("test", 0, 32);
    }

    @Test
    public void run6() throws Throwable {
        runTest("test", 32, 66);
    }

    @Test
    public void run7() throws Throwable {
        runTest("test", 32, 67);
    }

    @Test
    public void run8() throws Throwable {
        runTest("test", 32, 32);
    }
}
