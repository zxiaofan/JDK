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

public class Array_setChar01 extends JTTTest {

    private static final char[] array = {0, 0, 0};

    public static char test(int i, char value) {
        Array.setChar(array, i, value);
        return array[i];
    }

    @Test
    public void run0() throws Throwable {
        runTest("test", 0, ((char) 11));
    }

    @Test
    public void run1() throws Throwable {
        runTest("test", 1, ((char) 21));
    }

    @Test
    public void run2() throws Throwable {
        runTest("test", 0, ((char) 42));
    }

    @Test
    public void run3() throws Throwable {
        runTest("test", 3, ((char) 0));
    }

}
