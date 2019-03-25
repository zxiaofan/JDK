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
/*
 */


package org.graalvm.compiler.jtt.except;

import org.junit.Test;

import org.graalvm.compiler.jtt.JTTTest;

public class BC_aastore0 extends JTTTest {

    static Object[] param = {new Object(), null, "h"};
    static Object[] arr = {null, null, null};
    static String[] arr2 = {null, null, null};

    public static int test(boolean a, int indx) {
        Object[] array = a ? arr : arr2;
        Object val;
        if (indx == -2) {
            array = null;
            val = null;
        } else {
            val = param[indx];
        }
        array[indx] = val;
        return indx;
    }

    @Test
    public void run0() throws Throwable {
        runTest("test", true, -2);
    }

    @Test
    public void run1() throws Throwable {
        runTest("test", true, -1);
    }

    @Test
    public void run2() throws Throwable {
        runTest("test", true, 0);
    }

    @Test
    public void run3() throws Throwable {
        runTest("test", true, 1);
    }

    @Test
    public void run4() throws Throwable {
        runTest("test", true, 2);
    }

    @Test
    public void run5() throws Throwable {
        runTest("test", true, 3);
    }

    @Test
    public void run6() throws Throwable {
        runTest("test", false, 0);
    }

    @Test
    public void run7() throws Throwable {
        runTest("test", false, 1);
    }

    @Test
    public void run8() throws Throwable {
        runTest("test", false, 2);
    }

    @Test
    public void run9() throws Throwable {
        runTest("test", false, 3);
    }

}
