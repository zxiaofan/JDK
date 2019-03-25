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

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import org.junit.Test;

import org.graalvm.compiler.jtt.JTTTest;

/*
 */
public class Invoke_main03 extends JTTTest {

    public static class TestClass {
        public static void main(String[] args) {
            field = args[0];
        }
    }

    static String field;

    public static String test(String input) throws IllegalAccessException, InvocationTargetException {
        field = null;
        final String[] args = {input};
        for (Method m : TestClass.class.getDeclaredMethods()) {
            if ("main".equals(m.getName())) {
                m.invoke(null, new Object[]{args});
            }
        }
        return field;
    }

    @Test
    public void run0() throws Throwable {
        runTest("test", "test1");
    }

    @Test
    public void run1() throws Throwable {
        runTest("test", "test2");
    }

}
