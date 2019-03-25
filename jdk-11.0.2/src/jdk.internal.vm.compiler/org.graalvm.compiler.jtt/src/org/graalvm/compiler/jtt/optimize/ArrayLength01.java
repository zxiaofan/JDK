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
 * Tests constant folding of array length operations.
 */
public class ArrayLength01 extends JTTTest {

    public static final int SIZE = 8;
    public static final byte[] arr = new byte[5];

    public static int test(int arg) {
        if (arg == 0) {
            return arr.length;
        }
        if (arg == 1) {
            return new byte[6].length;
        }
        if (arg == 2) {
            return new Object[7].length;
        }
        if (arg == 3) {
            return new Class<?>[SIZE][].length;
        }
        if (arg == 4) {
            return new int[arg].length;
        }
        return 0;
    }

    @Test
    public void run0() throws Throwable {
        runTest("test", 0);
    }

    @Test
    public void run1() throws Throwable {
        runTest("test", 1);
    }

    @Test
    public void run2() throws Throwable {
        runTest("test", 2);
    }

    @Test
    public void run3() throws Throwable {
        runTest("test", 3);
    }

    @Test
    public void run4() throws Throwable {
        runTest("test", 4);
    }

}
