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
public class Method_getReturnType01 extends JTTTest {

    public static String test(int arg) throws NoSuchMethodException {
        if (arg == 0) {
            return Method_getReturnType01.class.getMethod("method1").getReturnType().getName();
        } else if (arg == 1) {
            return Method_getReturnType01.class.getMethod("method2").getReturnType().getName();
        } else if (arg == 2) {
            return Method_getReturnType01.class.getMethod("method3").getReturnType().getName();
        }
        return null;
    }

    public int method1() {
        return 0;
    }

    public String method2() {
        return null;
    }

    public void method3() {
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

}
