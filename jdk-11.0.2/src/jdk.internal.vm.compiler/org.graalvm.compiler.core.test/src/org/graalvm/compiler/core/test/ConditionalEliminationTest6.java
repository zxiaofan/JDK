/*
 * Copyright (c) 2015, 2015, Oracle and/or its affiliates. All rights reserved.
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


package org.graalvm.compiler.core.test;

import org.junit.Test;

/**
 * Collection of tests for {@link org.graalvm.compiler.phases.common.ConditionalEliminationPhase}
 * including those that triggered bugs in this phase.
 */
public class ConditionalEliminationTest6 extends ConditionalEliminationTestBase {

    public static final A constA = new A();
    public static final B constB = new B();

    static class A {
    }

    static class B {
    }

    @SuppressWarnings("all")
    public static B reference1Snippet(Object a, B b) {
        if (a == constA) {
            return b;
        }
        return null;
    }

    @SuppressWarnings("all")
    public static B test1Snippet(Object a, B b) {
        if (a == constA) {
            if (a == null) {
                return null;
            } else {
                return b;
            }
        }
        return null;
    }

    @Test
    public void test1() {
        testConditionalElimination("test1Snippet", "reference1Snippet");
    }

    @SuppressWarnings("all")
    public static B test2Snippet(Object a, B b) {
        if (a == constA) {
            if (a == constB) {
                return null;
            } else {
                return b;
            }
        }
        return null;
    }

    @Test
    public void test2() {
        testConditionalElimination("test2Snippet", "reference1Snippet");
    }

    @SuppressWarnings("all")
    public static B test3Snippet(Object a, B b) {
        if (a == constA) {
            if (a == b) {
                return null;
            } else {
                return b;
            }
        }
        return null;
    }

    @Test
    public void test3() {
        testConditionalElimination("test3Snippet", "reference1Snippet");
    }
}
