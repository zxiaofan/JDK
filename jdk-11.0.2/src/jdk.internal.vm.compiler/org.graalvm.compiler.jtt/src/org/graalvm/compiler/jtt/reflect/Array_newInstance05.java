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

public class Array_newInstance05 extends JTTTest {

    public static boolean test(int i, int j) {
        final int[] dims = {i, j};
        Class<?> javaClass;
        if (i == 2) {
            javaClass = void.class;
        } else if (i == 3) {
            javaClass = null;
        } else {
            javaClass = int.class;
        }
        return Array.newInstance(javaClass, dims) != null;
    }

    @Test
    public void run0() throws Throwable {
        runTest("test", 1, 3);
    }

    @Test
    public void run1() throws Throwable {
        runTest("test", 2, 3);
    }

    @Test
    public void run2() throws Throwable {
        runTest("test", 3, 4);
    }

    @Test
    public void run3() throws Throwable {
        runTest("test", 1, -1);
    }

}
