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
public class BC_dcmp01 extends JTTTest {

    public static boolean test(double a, double b) {
        return a < b;
    }

    @Test
    public void run0() throws Throwable {
        runTest("test", 0d, -0.1d);
    }

    @Test
    public void run1() throws Throwable {
        runTest("test", 78.00d, 78.001d);
    }

}
