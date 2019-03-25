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
import org.graalvm.compiler.phases.common.AbstractInliningPhase;

/**
 * Tests the implementation of the snippets for lowering the INVOKE* instructions.
 */
public class InvokeTest extends GraalCompilerTest {

    public InvokeTest() {
        createSuites(getInitialOptions()).getHighTier().findPhase(AbstractInliningPhase.class).remove();
    }

    public interface I {

        String virtualMethod(String s);
    }

    public static class A implements I {

        final String name = "A";

        @Override
        public String virtualMethod(String s) {
            return name + s;
        }
    }

    @SuppressWarnings("static-method")
    private String privateMethod(String s) {
        return s;
    }

    @Test
    public void test1() {
        test("invokestatic", "a string");
        test("invokespecialConstructor", "a string");
        test("invokespecial", this, "a string");
        test("invokevirtual", new A(), "a string");
        test("invokevirtual2", new A(), "a string");
        test("invokeinterface", new A(), "a string");
        Object[] args = {null};
        test("invokestatic", args);
        test("invokespecialConstructor", args);
        test("invokespecial", null, null);
        test("invokevirtual", null, null);
        test("invokevirtual2", null, null);
        test("invokeinterface", null, null);
    }

    public static String invokestatic(String s) {
        return staticMethod(s);
    }

    public static String staticMethod(String s) {
        return s;
    }

    public static String invokespecialConstructor(String s) {
        return new A().virtualMethod(s);
    }

    public static String invokespecial(InvokeTest a, String s) {
        return a.privateMethod(s);
    }

    public static String invokevirtual(A a, String s) {
        return a.virtualMethod(s);
    }

    public static String invokevirtual2(A a, String s) {
        a.virtualMethod(s);
        return a.virtualMethod(s);
    }

    public static String invokeinterface(I i, String s) {
        return i.virtualMethod(s);
    }
}
