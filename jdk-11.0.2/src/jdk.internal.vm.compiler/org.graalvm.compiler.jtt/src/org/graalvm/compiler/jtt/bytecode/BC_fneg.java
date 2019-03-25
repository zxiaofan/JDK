/*
 * Copyright (c) 2007, 2016, Oracle and/or its affiliates. All rights reserved.
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
public class BC_fneg extends JTTTest {

    public static float test(float a) {
        return -a;
    }

    @Test
    public void run0() throws Throwable {
        runTest("test", 0.0f);
    }

    @Test
    public void run1() throws Throwable {
        runTest("test", -1.01f);
    }

    @Test
    public void run2() throws Throwable {
        runTest("test", 7263.8734f);
    }

    public static float test2(float a, float b) {
        return -(a - b);
    }

    @Test
    public void run3() throws Throwable {
        runTest("test2", -1.0f, -1.0f);
    }
}
