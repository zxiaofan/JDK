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


package org.graalvm.compiler.jtt.reflect;

import org.junit.Test;

import org.graalvm.compiler.jtt.JTTTest;

/*
 */
public class Class_getDeclaredField01 extends JTTTest {

    static String field;
    static int f2;

    public static String test(String input) throws NoSuchFieldException {
        return Class_getDeclaredField01.class.getDeclaredField(input).getName();
    }

    public static void main(String[] args) {
        field = args[0];
    }

    @Test
    public void run0() throws Throwable {
        runTest("test", "test");
    }

    @Test
    public void run1() throws Throwable {
        runTest("test", "field");
    }

    @Test
    public void run2() throws Throwable {
        runTest("test", "f2");
    }

}
