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
/*
 */


package org.graalvm.compiler.jtt.except;

import org.junit.Test;

import org.graalvm.compiler.jtt.JTTTest;

public class BC_faload extends JTTTest {

    static float[] arr = {0.0f, -1.1f, 4.32f, 6.06f};

    public static float test(int arg) {
        final float[] array = arg == -2 ? null : arr;
        return array[arg];
    }

    @Test
    public void run0() throws Throwable {
        runTest("test", -2);
    }

    @Test
    public void run1() throws Throwable {
        runTest("test", -1);
    }

    @Test
    public void run2() throws Throwable {
        runTest("test", 0);
    }

    @Test
    public void run3() throws Throwable {
        runTest("test", 4);
    }

}
