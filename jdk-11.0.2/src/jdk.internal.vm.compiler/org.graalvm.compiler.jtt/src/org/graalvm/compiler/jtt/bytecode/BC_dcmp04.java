/*
 * Copyright (c) 2008, 2012, Oracle and/or its affiliates. All rights reserved.
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
public class BC_dcmp04 extends JTTTest {

    public static boolean test(double a) {
        return (a / a) <= 0.0;
    }

    @Test
    public void run0() throws Throwable {
        runTest("test", -1.0d);
    }

    @Test
    public void run1() throws Throwable {
        runTest("test", 1.0d);
    }

    @Test
    public void run2() throws Throwable {
        runTest("test", 0.0d);
    }

    @Test
    public void run3() throws Throwable {
        runTest("test", -0.0d);
    }

}
