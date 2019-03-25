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

import org.junit.Ignore;
import org.junit.Test;

/**
 * Collection of tests for {@link org.graalvm.compiler.phases.common.ConditionalEliminationPhase}
 * including those that triggered bugs in this phase.
 */
@Ignore
public class ConditionalEliminationTest3 extends ConditionalEliminationTestBase {

    private static final String REFERENCE_SNIPPET = "referenceSnippet";

    @SuppressWarnings("all")
    public static int referenceSnippet(int a, int b) {
        int sum = 0;
        outer: for (int i = 0;; ++i) {
            if (b > 100) {
                inner: for (int j = 0;; ++j) {
                    ++sum;
                    if (sum == 100) {
                        break inner;
                    }
                    if (sum == 1000 && b < 1000) {
                        break outer;
                    }
                }
            }
        }
        return sum;
    }

    @Test
    public void test1() {
        testConditionalElimination("test1Snippet", REFERENCE_SNIPPET);
    }

    @SuppressWarnings("all")
    public static int test1Snippet(int a, int b) {
        int sum = 0;
        outer: for (int i = 0;; ++i) {
            if (b > 100) {
                inner: for (int j = 0;; ++j) {
                    ++sum;
                    if (sum == 100) {
                        break inner;
                    }
                    if (sum == 1000 && b < 1000) {
                        break outer;
                    }
                }
            }
        }
        if (b >= 1000) {
            return 5;
        }
        return sum;
    }

    @Test
    public void test2() {
        testConditionalElimination("test2Snippet", REFERENCE_SNIPPET);
    }

    @SuppressWarnings("all")
    public static int test2Snippet(int a, int b) {
        int sum = 0;
        outer: for (int i = 0;; ++i) {
            if (b > 100) {
                inner: for (int j = 0;; ++j) {
                    ++sum;
                    if (sum == 100) {
                        break inner;
                    }
                    if (sum == 1000 && b < 1000) {
                        break outer;
                    }
                }
                if (sum != 100) {
                    return 42;
                }
            }
        }
        return sum;
    }
}
