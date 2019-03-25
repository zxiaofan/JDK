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


package org.graalvm.compiler.jtt.bytecode;

import org.junit.Test;

import org.graalvm.compiler.jtt.JTTTest;

/*
 */
public class BC_aastore extends JTTTest {

    static Object[] param = {new Object(), null, "h"};
    static Object[] array1 = {null, null, null};
    static String[] array2 = {null, null, null};

    public static int test(boolean a, int indx) {
        Object[] array = a ? array1 : array2;
        Object val;
        val = param[indx];
        array[indx] = val;
        return indx;
    }

    @Test
    public void run0() throws Throwable {
        runTest("test", true, 0);
    }

    @Test
    public void run1() throws Throwable {
        runTest("test", true, 1);
    }

    @Test
    public void run2() throws Throwable {
        runTest("test", true, 2);
    }

    @Test
    public void run3() throws Throwable {
        runTest("test", false, 1);
    }

    @Test
    public void run4() throws Throwable {
        runTest("test", false, 2);
    }

}
