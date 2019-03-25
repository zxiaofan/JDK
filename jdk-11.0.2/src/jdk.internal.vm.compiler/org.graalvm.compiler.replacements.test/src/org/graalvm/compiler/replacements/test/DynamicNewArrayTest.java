/*
 * Copyright (c) 2013, Oracle and/or its affiliates. All rights reserved.
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


package org.graalvm.compiler.replacements.test;

import java.lang.reflect.Array;

import org.junit.Test;

import org.graalvm.compiler.core.test.GraalCompilerTest;

import jdk.vm.ci.meta.ResolvedJavaMethod;

/**
 * Tests the implementation of Array.createInstance.
 */
public class DynamicNewArrayTest extends GraalCompilerTest {

    private class Element {
    }

    @Test
    public void test1() {
        test("test1snippet");
    }

    @Test
    public void test2() {
        test("test2snippet");
    }

    @Test
    public void test3() {
        test("dynamic", Long.class, 7);
    }

    @Test
    public void test4() {
        test("dynamic", Boolean.class, -7);
        test("dynamicSynchronized", Boolean.class, -7);
    }

    @Test
    public void test5() {
        test("dynamic", byte.class, 7);
    }

    @Test
    public void test6() {
        test("dynamic", null, 5);
    }

    @Test
    public void test7() {
        test("dynamic", void.class, 5);
    }

    @Test
    public void testStub() {
        ResolvedJavaMethod method = getResolvedJavaMethod("dynamic");
        // this will use the stub call because Element[] is not loaded
        Result actual1 = executeActual(method, null, Element.class, 7);
        // this call will use the fast path
        Result actual2 = executeActual(method, null, Element.class, 7);
        Result expected = executeExpected(method, null, Element.class, 7);
        assertEquals(actual1, expected);
        assertEquals(actual2, expected);
    }

    public static Object test1snippet() {
        return Array.newInstance(Integer.class, 7);
    }

    public static Object test2snippet() {
        return Array.newInstance(char.class, 7);
    }

    public static Object dynamic(Class<?> elementType, int length) {
        return Array.newInstance(elementType, length);
    }

    public static synchronized Object dynamicSynchronized(Class<?> elementType, int length) {
        return Array.newInstance(elementType, length);
    }
}
