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


package org.graalvm.compiler.jtt.lang;

import org.junit.Test;

import org.graalvm.compiler.jtt.JTTTest;

public final class Class_isAssignableFrom01 extends JTTTest {

    public static boolean test(int i) {
        Class<?> source = Object.class;
        if (i == 0) {
            source = int.class;
        }
        if (i == 1) {
            source = int[].class;
        }
        if (i == 2) {
            source = float.class;
        }
        if (i == 3) {
            source = byte.class;
        }
        if (i == 4) {
            source = Runnable.class;
        }
        if (i == 5) {
            source = Class_isAssignableFrom01.class;
        }
        if (i == 6) {
            source = Object[].class;
        }
        return int.class.isAssignableFrom(source);
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

    @Test
    public void run7() throws Throwable {
        runTest("test", 7);
    }

}
