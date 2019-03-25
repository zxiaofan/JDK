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
public class Class_getMethod02 extends JTTTest {

    static String field;

    public static String test(int arg) throws NoSuchMethodException {
        if (arg == 0) {
            return Class_getMethod02.class.getMethod("test").getName();
        } else if (arg == 1) {
            return Class_getMethod02.class.getMethod("test", int.class).getName();
        } else if (arg == 2) {
            return Class_getMethod02.class.getMethod("main").getName();
        } else if (arg == 3) {
            return Class_getMethod02.class.getMethod("main", String[].class).getName();
        } else if (arg == 4) {
            return Class_getMethod02.class.getMethod("<init>").getName();
        } else if (arg == 5) {
            return Class_getMethod02.class.getMethod("<clinit>").getName();
        }
        return null;
    }

    public static void main(String[] args) {
        field = args[0];
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

    @Test
    public void run4() throws Throwable {
        runTest("test", 4);
    }

    @Test
    public void run5() throws Throwable {
        runTest("test", 5);
    }

    @Test
    public void run6() throws Throwable {
        runTest("test", 6);
    }

}
