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
@SuppressWarnings("unused")
public class Method_getParameterTypes01 extends JTTTest {

    public static int test(int arg) throws NoSuchMethodException {
        if (arg == 0) {
            return Method_getParameterTypes01.class.getMethod("method1").getParameterTypes().length;
        } else if (arg == 1) {
            return Method_getParameterTypes01.class.getMethod("method2", int.class).getParameterTypes().length;
        } else if (arg == 2) {
            return Method_getParameterTypes01.class.getMethod("method3", int.class, Object.class).getParameterTypes().length;
        }
        return -1;
    }

    public int method1() {
        return 0;
    }

    public void method2(int arg1) {
    }

    public void method3(int arg1, Object arg2) {
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
