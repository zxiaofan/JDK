/*
 * Copyright (c) 2009, 2012, Oracle and/or its affiliates. All rights reserved.
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
 * Tests constant folding of float conversions
 */
public class Fold_Convert03 extends JTTTest {

    public static float test(float arg) {
        if (arg == 0) {
            return i2f();
        }
        if (arg == 1) {
            return l2f();
        }
        if (arg == 2) {
            return d2f();
        }
        return 0;
    }

    public static float i2f() {
        int x = 1024;
        return x;
    }

    public static float l2f() {
        long x = -33;
        return x;
    }

    public static float d2f() {
        double x = -78.1d;
        return (float) x;
    }

    @Test
    public void run0() throws Throwable {
        runTest("test", 0.0F);
    }

    @Test
    public void run1() throws Throwable {
        runTest("test", 1.0F);
    }

    @Test
    public void run2() throws Throwable {
        runTest("test", 2.0F);
    }

}
