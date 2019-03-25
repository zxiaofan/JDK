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
public class ABCE_03 extends JTTTest {

    private static final int[] ARRAY1 = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
    private static final int[] ARRAY2 = new int[]{1};

    public static int test(int arg) {
        int[] array = arg == 0 ? ARRAY2 : ARRAY1;
        int r = 0;
        for (int i = 0; i < arg; i++) {
            r += array[i];
        }
        return r;
    }

    @Test
    public void run0() throws Throwable {
        runTest("test", 0);
    }

    @Test
    public void run1() throws Throwable {
        runTest("test", 10);
    }

    @Test
    public void run2() throws Throwable {
        runTest("test", 20);
    }

}
