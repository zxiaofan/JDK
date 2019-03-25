/*
 * Copyright (c) 2010, 2012, Oracle and/or its affiliates. All rights reserved.
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

import java.io.Serializable;

import org.junit.Test;

import org.graalvm.compiler.jtt.JTTTest;

public final class Class_getModifiers01 extends JTTTest {

    private static class PrivateStatic {
    }

    private static final class PrivateStaticFinal {
    }

    private static class Private {
    }

    public static int test(Class<?> c) {
        return c.getModifiers();
    }

    @Test
    public void run0() throws Throwable {
        runTest("test", Object.class);
        runTest("test", Object[].class);
    }

    @Test
    public void run1() throws Throwable {
        runTest("test", Serializable.class);
        runTest("test", Serializable[].class);
    }

    @Test
    public void run2() throws Throwable {
        runTest("test", void.class);
    }

    @Test
    public void run3() throws Throwable {
        runTest("test", int.class);
        runTest("test", int[].class);
    }

    @Test
    public void run4() throws Throwable {
        runTest("test", Private.class);
        runTest("test", Private[].class);
    }

    @Test
    public void run5() throws Throwable {
        runTest("test", PrivateStatic.class);
        runTest("test", PrivateStatic[].class);
    }

    @Test
    public void run6() throws Throwable {
        runTest("test", PrivateStaticFinal.class);
        runTest("test", PrivateStaticFinal[].class);
    }
}
