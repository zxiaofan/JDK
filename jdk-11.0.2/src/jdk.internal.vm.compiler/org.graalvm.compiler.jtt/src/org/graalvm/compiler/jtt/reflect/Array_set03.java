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

public class Array_set03 extends JTTTest {

    private static final byte[] array = {-1, -1, -1};

    public static byte test(int i, byte value) {
        Array.set(array, i, value);
        return array[i];
    }

    @Test
    public void run0() throws Throwable {
        runTest("test", 0, ((byte) 11));
    }

    @Test
    public void run1() throws Throwable {
        runTest("test", 1, ((byte) 21));
    }

    @Test
    public void run2() throws Throwable {
        runTest("test", 0, ((byte) 42));
    }

    @Test
    public void run3() throws Throwable {
        runTest("test", 3, ((byte) 0));
    }

}
