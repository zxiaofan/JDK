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
public class BC_fadd extends JTTTest {

    public static float test(float a, float b) {
        return a + b;
    }

    @Test
    public void run0() throws Throwable {
        runTest("test", 0.0f, 0.0f);
    }

    @Test
    public void run1() throws Throwable {
        runTest("test", 1.0f, 1.0f);
    }

    @Test
    public void run2() throws Throwable {
        runTest("test", 253.11f, 54.43f);
    }

    @Test
    public void run3() throws Throwable {
        runTest("test", Float.MAX_VALUE, Float.MIN_VALUE);
    }

    @Test
    public void run4() throws Throwable {
        runTest("test", Float.MAX_VALUE / 2, Float.MAX_VALUE / 2);
    }

}
