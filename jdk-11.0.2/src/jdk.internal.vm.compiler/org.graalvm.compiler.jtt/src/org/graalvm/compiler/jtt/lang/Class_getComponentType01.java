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

public final class Class_getComponentType01 extends JTTTest {

    public static String test(int i) {
        Class<?> cl = Object.class;
        if (i == 0) {
            cl = int.class;
        } else if (i == 1) {
            cl = int[].class;
        } else if (i == 2) {
            cl = Object.class;
        } else if (i == 3) {
            cl = Object[].class;
        } else if (i == 4) {
            cl = Class_getComponentType01.class;
        } else if (i == 5) {
            cl = Cloneable.class;
        } else if (i == 6) {
            cl = Object[][].class;
        } else if (i == 7) {
            cl = void.class;
        }
        cl = cl.getComponentType();
        if (cl == null) {
            return null;
        }
        return cl.getName();
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

    @Test
    public void run8() throws Throwable {
        runTest("test", 8);
    }

}
