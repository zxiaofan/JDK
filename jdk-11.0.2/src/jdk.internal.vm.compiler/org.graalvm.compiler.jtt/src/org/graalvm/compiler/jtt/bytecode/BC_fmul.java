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
public class BC_fmul extends JTTTest {

    public static float test(float a, float b) {
        return a * b;
    }

    @Test
    public void run0() throws Throwable {
        runTest("test", 311.0f, 10f);
    }

    @Test
    public void run1() throws Throwable {
        runTest("test", 11.2f, 2.0f);
    }

}
