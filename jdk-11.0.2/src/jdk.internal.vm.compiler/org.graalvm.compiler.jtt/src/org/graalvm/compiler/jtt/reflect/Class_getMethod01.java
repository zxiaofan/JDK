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
public class Class_getMethod01 extends JTTTest {

    static String field;

    public static String test(String input) throws NoSuchMethodException {
        return Class_getMethod01.class.getMethod(input, String[].class).getName();
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
        runTest("test", "main");
    }

    @Test
    public void run2() throws Throwable {
        runTest("test", "xx");
    }

}
