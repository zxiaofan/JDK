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

import org.graalvm.compiler.api.directives.GraalDirectives;
import org.junit.Test;

/**
 * Collection of tests for {@link org.graalvm.compiler.phases.common.ConditionalEliminationPhase}
 * including those that triggered bugs in this phase.
 */
public class ConditionalEliminationTest1 extends ConditionalEliminationTestBase {
    protected static int sink3;

    private static final String REFERENCE_SNIPPET = "referenceSnippet";

    @SuppressWarnings("all")
    public static void referenceSnippet(int a) {
        if (a == 0) {
            sink1 = 1;
        }
        sink0 = 0;
    }

    @Test
    public void test1() {
        testConditionalElimination("test1Snippet", REFERENCE_SNIPPET);
    }

    @SuppressWarnings("all")
    public static void test1Snippet(int a) {
        if (a == 0) {
            if (a == 5) {
                sink2 = 100;
            }
            if (a > 100) {
                if (a == 0) {
                    sink3 = 200;
                }
            }
            if (a != 2) {
                sink1 = 1;
            }
        }
        sink0 = 0;
    }

    @Test
    public void test2() {
        testConditionalElimination("test2Snippet", REFERENCE_SNIPPET);
    }

    @SuppressWarnings("all")
    public static void test2Snippet(int a) {
        if (a == 0) {
            if (a > 100) {
                if (a == 0) {
                    sink3 = 200;
                }
            }
            if (a != 2) {
                sink1 = 1;
            }
        }
        sink0 = 0;
    }

    @Test
    public void test3() {
        testConditionalElimination("test3Snippet", REFERENCE_SNIPPET);
    }

    @SuppressWarnings("all")
    public static void test3Snippet(int a) {
        if (a == 0) {
            if (a < 1) {
                if (a < 2) {
                    if (a < 3) {
                        if (a > -1) {
                            if (a > -2) {
                                if (a > -3) {
                                    if (a == 1) {
                                        sink2 = 42;
                                    } else {
                                        sink1 = 1;
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        sink0 = 0;
    }

    @SuppressWarnings("all")
    public static void test4Snippet(int a, int b) {
        if (b < 1) {
            GraalDirectives.controlFlowAnchor();
            if (b < 0) {
                sink1 = 1;
            }
        }
        sink0 = 0;
    }

    @Test
    public void test4() {
        testConditionalElimination("test4Snippet", "test4Snippet");
    }

    @SuppressWarnings("all")
    public static void test5Snippet(int a, int b) {
        if ((b & 3) == 0) {
            GraalDirectives.controlFlowAnchor();
            if ((b & 7) == 0) {
                GraalDirectives.controlFlowAnchor();
                sink1 = 1;
            }
        } else {
            GraalDirectives.controlFlowAnchor();
            if ((b & 1) == 0) {
                GraalDirectives.controlFlowAnchor();
                sink2 = 2;
            }
        }
        sink0 = 0;
    }

    @Test
    public void test5() {
        testConditionalElimination("test5Snippet", "test5Snippet");
    }
}
