/*
 * Copyright (c) 2011, 2012, Oracle and/or its affiliates. All rights reserved.
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


package org.graalvm.compiler.jtt.bytecode;

import org.junit.Test;

import org.graalvm.compiler.jtt.JTTTest;

/*
 */
public class BC_dsub2 extends JTTTest {

    public static double test(double a) {
        return 1.0 / (0.0 - a);
    }

    @Test
    public void run0() throws Throwable {
        runTest("test", 0.0d);
    }

    public static double test2(double a) {
        return a - a;
    }

    @Test
    public void run1() {
        runTest("test2", 17.3);
    }

    @Test
    public void run2() {
        runTest("test2", Double.NaN);
    }
}
