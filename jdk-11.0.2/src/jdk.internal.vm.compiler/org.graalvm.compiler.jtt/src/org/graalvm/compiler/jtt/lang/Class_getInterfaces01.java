/*
 * Copyright (c) 2010, 2014, Oracle and/or its affiliates. All rights reserved.
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


package org.graalvm.compiler.jtt.lang;

import org.junit.Test;

import org.graalvm.compiler.jtt.JTTTest;

/*
 */
public final class Class_getInterfaces01 extends JTTTest {

    public static Class<?>[] test(Class<?> clazz) {
        return clazz.getInterfaces();
    }

    interface I1 {

    }

    interface I2 extends I1 {

    }

    static class C1 implements I1 {

    }

    static class C2 implements I2 {

    }

    static class C12 implements I1, I2 {

    }

    @Test
    public void run0() throws Throwable {
        runTest("test", I1.class);
    }

    @Test
    public void run1() throws Throwable {
        runTest("test", I2.class);
    }

    @Test
    public void run2() throws Throwable {
        runTest("test", C1.class);
    }

    @Test
    public void run3() throws Throwable {
        runTest("test", C2.class);
    }

    @Test
    public void run4() throws Throwable {
        runTest("test", C12.class);
    }
}
