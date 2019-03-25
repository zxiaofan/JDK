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
public class BC_dreturn extends JTTTest {

    public static double test(double a) {
        return a;
    }

    @Test
    public void run0() throws Throwable {
        runTest("test", 0.0d);
    }

    @Test
    public void run1() throws Throwable {
        runTest("test", 1.1d);
    }

    @Test
    public void run2() throws Throwable {
        runTest("test", -1.4d);
    }

    @Test
    public void run3() throws Throwable {
        runTest("test", 256.33d);
    }

    @Test
    public void run4() throws Throwable {
        runTest("test", 1000.001d);
    }

}
