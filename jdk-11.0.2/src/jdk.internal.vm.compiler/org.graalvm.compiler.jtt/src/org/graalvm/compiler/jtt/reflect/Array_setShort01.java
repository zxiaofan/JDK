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

public class Array_setShort01 extends JTTTest {

    private static final short[] array = {-1, -1, -1};

    public static short test(int i, short value) {
        Array.setShort(array, i, value);
        return array[i];
    }

    @Test
    public void run0() throws Throwable {
        runTest("test", 0, ((short) 11));
    }

    @Test
    public void run1() throws Throwable {
        runTest("test", 1, ((short) 21));
    }

    @Test
    public void run2() throws Throwable {
        runTest("test", 0, ((short) 42));
    }

    @Test
    public void run3() throws Throwable {
        runTest("test", 3, ((short) 0));
    }

}
