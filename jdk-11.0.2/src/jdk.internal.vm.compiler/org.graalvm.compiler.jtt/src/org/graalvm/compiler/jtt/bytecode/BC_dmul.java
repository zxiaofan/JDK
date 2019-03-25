/*
 * Copyright (c) 2007, 2012, Oracle and/or its affiliates. All rights reserved.
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
public class BC_dmul extends JTTTest {

    public static double test(double a, double b) {
        return a * b;
    }

    @Test
    public void run0() throws Throwable {
        runTest("test", 311.0D, 10D);
    }

    @Test
    public void run1() throws Throwable {
        runTest("test", 11.2D, 2.0D);
    }

}
