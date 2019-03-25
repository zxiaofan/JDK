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
public class ConditionalEliminationTest8 extends ConditionalEliminationTestBase {

    private static double value;

    @SuppressWarnings("all")
    public static int test1Snippet(int a, Object b) {
        double sum = 0;
        if (!(b instanceof String)) {
            return 42;
        }
        for (int j = 0; j < a; ++j) {
            sum += value;
        }
        return ((String) b).length();
    }

    @Test
    public void test1() {
        // One loop exit is skipped, because the condition dominates also the loop begin.
        testProxies("test1Snippet", 0);
    }
}
