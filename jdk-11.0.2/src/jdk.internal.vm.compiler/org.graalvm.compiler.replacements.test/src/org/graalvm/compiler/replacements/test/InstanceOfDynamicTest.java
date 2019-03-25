/*
 * Copyright (c) 2011, Oracle and/or its affiliates. All rights reserved.
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

import org.junit.Test;

import org.graalvm.compiler.core.test.GraalCompilerTest;
import org.graalvm.compiler.nodes.java.InstanceOfDynamicNode;

/**
 * Tests for {@link InstanceOfDynamicNode}.
 */
public class InstanceOfDynamicTest extends GraalCompilerTest {

    public static int id(int value) {
        return value;
    }

    @Test
    public void test100() {
        final Object nul = null;
        test("isStringDynamic", nul);
        test("isStringDynamic", "object");
        test("isStringDynamic", Object.class);
    }

    @Test
    public void test101() {
        final Object nul = null;
        test("isStringIntDynamic", nul);
        test("isStringIntDynamic", "object");
        test("isStringIntDynamic", Object.class);
    }

    @Test
    public void test103() {
        test("isInstanceDynamic", String.class, null);
        test("isInstanceDynamic", String.class, "object");
        test("isInstanceDynamic", String.class, Object.class);
        test("isInstanceDynamic", int.class, null);
        test("isInstanceDynamic", int.class, "Object");
        test("isInstanceDynamic", int.class, Object.class);
    }

    @Test
    public void test104() {
        test("isInstanceIntDynamic", String.class, null);
        test("isInstanceIntDynamic", String.class, "object");
        test("isInstanceIntDynamic", String.class, Object.class);
        test("isInstanceIntDynamic", int.class, null);
        test("isInstanceIntDynamic", int.class, "Object");
        test("isInstanceIntDynamic", int.class, Object.class);
    }

    public static boolean isStringDynamic(Object o) {
        return String.class.isInstance(o);
    }

    public static int isStringIntDynamic(Object o) {
        if (String.class.isInstance(o)) {
            return o.toString().length();
        }
        return o.getClass().getName().length();
    }

    public static boolean isInstanceDynamic(Class<?> c, Object o) {
        return c.isInstance(o);
    }

    public static int isInstanceIntDynamic(Class<?> c, Object o) {
        if (c.isInstance(o)) {
            return o.toString().length();
        }
        return o.getClass().getName().length();
    }
}
