/*
 * Copyright (c) 2009, 2012, Oracle and/or its affiliates. All rights reserved.
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

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import org.junit.Test;

import org.graalvm.compiler.jtt.JTTTest;

/*
 */
public class Invoke_except01 extends JTTTest {

    public static class TestClass {
        public static int method(int[] arg) {
            return arg.length;
        }
    }

    public static int test(int arg) throws IllegalAccessException, InvocationTargetException {
        Object[] args;
        if (arg == 0) {
            args = new Object[]{new int[0]};
        } else if (arg == 1) {
            args = new Object[]{new int[3]};
        } else if (arg == 2) {
            args = new Object[]{null};
        } else if (arg == 3) {
            args = new Object[]{new char[3]};
        } else {
            args = null;
        }
        for (Method m : TestClass.class.getDeclaredMethods()) {
            if ("method".equals(m.getName())) {
                return (Integer) m.invoke(null, args);
            }
        }
        return 42;
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

}
