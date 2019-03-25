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
 */
public class SignExtendShort extends JTTTest {

    public static int val;

    public static boolean test(short[] b) {
        val = b[2];
        int x = 0;
        return val >= x;
    }

    @Test
    public void run0() throws Throwable {
        runTest("test", new short[]{0, 0, 0});
    }

    @Test
    public void run1() throws Throwable {
        runTest("test", new short[]{0, 0, 1});
    }

    @Test
    public void run2() throws Throwable {
        runTest("test", new short[]{0, 0, -1});
    }

    @Test
    public void run3() throws Throwable {
        runTest("test", new short[]{0, 0, Short.MAX_VALUE});
    }

    @Test
    public void run4() throws Throwable {
        runTest("test", new short[]{0, 0, Short.MIN_VALUE});
    }
}
