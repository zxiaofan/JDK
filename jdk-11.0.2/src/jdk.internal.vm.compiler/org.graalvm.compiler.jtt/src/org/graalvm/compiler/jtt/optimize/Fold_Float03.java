/*
 * Copyright (c) 2017, 2017, Oracle and/or its affiliates. All rights reserved.
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


package org.graalvm.compiler.jtt.optimize;

import org.junit.Test;

import org.graalvm.compiler.jtt.JTTTest;

/*
 * Tests constant folding of float operations.
 */
public class Fold_Float03 extends JTTTest {

    // Contrived check whether both arguments are the same kind of zero
    public static boolean test(float x, float y) {
        if (x == 0) {
            if (1 / x == Float.NEGATIVE_INFINITY) {
                return 1 / y == Float.NEGATIVE_INFINITY;
            } else {
                return 1 / y == Float.POSITIVE_INFINITY;
            }
        }
        return false;
    }

    @Test
    public void run0() throws Throwable {
        runTest("test", -0f, -0f);
    }

    @Test
    public void run1() throws Throwable {
        runTest("test", -0f, 0f);
    }

    @Test
    public void run2() throws Throwable {
        runTest("test", 0f, -0f);
    }

    @Test
    public void run3() throws Throwable {
        runTest("test", 0f, 0f);
    }

}
