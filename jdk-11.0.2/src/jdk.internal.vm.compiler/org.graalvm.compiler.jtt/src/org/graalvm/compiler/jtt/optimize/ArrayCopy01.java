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
 * Tests calls to the array copy method.
 */
public class ArrayCopy01 extends JTTTest {

    public static Object[] src = new Object[]{null, null};
    public static Object[] dest = new Object[]{null, null};
    static {
        // Ensure System is resolved
        System.arraycopy(src, 0, src, 0, src.length);
    }

    public static int test(int srcPos, int destPos, int length) {
        System.arraycopy(src, srcPos, dest, destPos, length);
        return 0;
    }

    @Test
    public void run0() throws Throwable {
        runTest("test", 0, 0, 0);
    }

    @Test
    public void run1() throws Throwable {
        runTest("test", 0, 0, -1);
    }

    @Test
    public void run2() throws Throwable {
        runTest("test", -1, 0, 0);
    }

    @Test
    public void run3() throws Throwable {
        runTest("test", 0, -1, 0);
    }

    @Test
    public void run4() throws Throwable {
        runTest("test", 0, 0, 2);
    }

    @Test
    public void run5() throws Throwable {
        runTest("test", 0, 1, 2);
    }

    @Test
    public void run6() throws Throwable {
        runTest("test", 1, 0, 2);
    }

    @Test
    public void run7() throws Throwable {
        runTest("test", 1, 1, -1);
    }

}
