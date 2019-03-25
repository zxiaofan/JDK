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


package org.graalvm.compiler.jtt.optimize;

import org.junit.Test;

import org.graalvm.compiler.jtt.JTTTest;

/*
 */
public class Cmov02 extends JTTTest {

    public static int test(double a, double b, int v1, int v2) {
        return a < b ? v1 : v2;
    }

    @Test
    public void run0() throws Throwable {
        runTest("test", 1.0, 1.1, 1, 2);
    }

    @Test
    public void run1() throws Throwable {
        runTest("test", 1.0, -1.1, 1, 2);
    }

    @Test
    public void run2() throws Throwable {
        runTest("test", 1.0, java.lang.Double.NaN, 1, 2);
    }

}
