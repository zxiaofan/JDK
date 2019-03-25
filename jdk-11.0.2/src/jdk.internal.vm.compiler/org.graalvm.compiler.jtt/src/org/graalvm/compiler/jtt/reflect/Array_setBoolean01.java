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

public class Array_setBoolean01 extends JTTTest {

    private static final boolean[] array = {false, false, false};

    public static boolean test(int i, boolean value) {
        Array.setBoolean(array, i, value);
        return array[i];
    }

    @Test
    public void run0() throws Throwable {
        runTest("test", 0, true);
    }

    @Test
    public void run1() throws Throwable {
        runTest("test", 1, false);
    }

    @Test
    public void run2() throws Throwable {
        runTest("test", 2, true);
    }

    @Test
    public void run3() throws Throwable {
        runTest("test", 3, false);
    }

}
