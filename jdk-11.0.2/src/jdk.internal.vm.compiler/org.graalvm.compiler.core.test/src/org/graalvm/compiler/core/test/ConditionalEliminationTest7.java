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
public class ConditionalEliminationTest7 extends ConditionalEliminationTestBase {

    @SuppressWarnings("all")
    public static int test1Snippet(int a, Object b) {
        int sum = 0;
        for (int j = 0;; ++j) {
            ++sum;
            if (b instanceof String) {
                if (sum == 100) {
                    break;
                }
            }
        }
        String s = (String) b;
        return s.length() + sum;
    }

    @Test
    public void test1() {
        // One loop exit is skipped.
        testProxies("test1Snippet", 1);
    }

    @SuppressWarnings("all")
    public static int test2Snippet(int a, Object b) {
        int sum = 0;
        for (int j = 0;; ++j) {
            ++sum;
            if (b instanceof String) {
                break;
            }
        }
        String s = (String) b;
        return s.length() + sum;
    }

    @Test
    public void test2() {
        // The loop exit is the anchor => no proxy necessary.
        testProxies("test2Snippet", 0);
    }

    @SuppressWarnings("all")
    public static int test3Snippet(int a, Object b) {
        int sum = a;
        outer: while (true) {
            sum++;
            while (sum++ != 20) {
                while (sum++ != 30) {
                    while (sum++ != 40) {
                        while (sum++ != 50) {
                            if (b instanceof String) {
                                break outer;
                            }
                        }
                    }
                }
            }
        }
        String s = (String) b;
        return s.length() + sum;
    }

    @Test
    public void test3() {
        // The break skips over 4 other loops.
        testProxies("test3Snippet", 4);
    }
}
