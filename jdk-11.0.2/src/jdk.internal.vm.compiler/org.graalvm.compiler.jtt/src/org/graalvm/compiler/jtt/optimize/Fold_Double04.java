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
 * Tests constant folding of double operations.
 */
public class Fold_Double04 extends JTTTest {

    // Contrived check whether both arguments are the same kind of zero
    public static boolean test(double x, double y) {
        if (x == 0) {
            if (1 / x == Double.NEGATIVE_INFINITY) {
                return 1 / y == Double.NEGATIVE_INFINITY;
            } else {
                return 1 / y == Double.POSITIVE_INFINITY;
            }
        }
        return false;
    }

    @Test
    public void run0() throws Throwable {
        runTest("test", -0d, -0d);
    }

    @Test
    public void run1() throws Throwable {
        runTest("test", -0d, 0d);
    }

    @Test
    public void run2() throws Throwable {
        runTest("test", 0d, -0d);
    }

    @Test
    public void run3() throws Throwable {
        runTest("test", 0d, 0d);
    }

}
