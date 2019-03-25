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
 */


package org.graalvm.compiler.jtt.reflect;

import java.lang.reflect.Array;

import org.junit.Test;

import org.graalvm.compiler.jtt.JTTTest;

public class Array_getLength01 extends JTTTest {

    private static final int[] array0 = {11, 21, 42};
    private static final boolean[] array1 = {true, true, false, false};
    private static final String[] array2 = {"String"};

    public static int test(int i) {
        Object array = null;
        if (i == 0) {
            array = array0;
        } else if (i == 1) {
            array = array1;
        } else if (i == 2) {
            array = array2;
        }
        return Array.getLength(array);
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

}
