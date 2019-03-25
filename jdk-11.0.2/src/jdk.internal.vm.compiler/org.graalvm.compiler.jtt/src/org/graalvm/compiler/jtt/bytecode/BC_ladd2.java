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
/*
 * Copyright (c) 2007, 2012, Oracle and/or its affiliates. All rights reserved.
 */


package org.graalvm.compiler.jtt.bytecode;

import org.junit.Test;

import org.graalvm.compiler.jtt.JTTTest;

/*
 */
public class BC_ladd2 extends JTTTest {

    public static long test(int a, int b) {
        return a + (long) b;
    }

    @Test
    public void run0() throws Throwable {
        runTest("test", 1, 2);
    }

    @Test
    public void run1() throws Throwable {
        runTest("test", 0, -1);
    }

    @Test
    public void run2() throws Throwable {
        runTest("test", 33, 67);
    }

    @Test
    public void run3() throws Throwable {
        runTest("test", 1, -1);
    }

    @Test
    public void run4() throws Throwable {
        runTest("test", -2147483648, 1);
    }

    @Test
    public void run5() throws Throwable {
        runTest("test", 2147483647, 1);
    }

    @Test
    public void run6() throws Throwable {
        runTest("test", -2147483647, -2);
    }

}
