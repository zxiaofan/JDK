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
public class ConditionalEliminationTest4 extends ConditionalEliminationTestBase {

    @SuppressWarnings("all")
    public static int reference1Snippet(int a, int b) {
        if (a > b) {
            return 1;
        }
        return 2;
    }

    @SuppressWarnings("all")
    public static int test1Snippet(int a, int b) {
        if (a > b) {
            if (a > b) {
                return 1;
            }
        }
        return 2;
    }

    @Test
    public void test1() {
        testConditionalElimination("test1Snippet", "reference1Snippet");
    }

    @SuppressWarnings("all")
    public static int reference2Snippet(int a, int b) {
        if (a < b) {
            return 1;
        }
        return 2;
    }

    @SuppressWarnings("all")
    public static int test2Snippet(int a, int b) {
        if (a < b) {
            if (a < b) {
                return 1;
            }
        }
        return 2;
    }

    @Test
    public void test2() {
        testConditionalElimination("test2Snippet", "reference2Snippet");
    }
}
