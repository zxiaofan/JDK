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
public class BC_d2f extends JTTTest {

    public static float test(double d) {
        return (float) d;
    }

    @Test
    public void run0() throws Throwable {
        runTest("test", 0.0d);
    }

    @Test
    public void run1() throws Throwable {
        runTest("test", 1.0d);
    }

    @Test
    public void run2() throws Throwable {
        runTest("test", -1.06d);
    }

}
