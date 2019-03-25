/*
 * Copyright (c) 2009, 2012, Oracle and/or its affiliates. All rights reserved.
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
 * Tests optimization of float operations.
 */
public class VN_Float02 extends JTTTest {

    private static boolean cond = true;

    public static float test(float arg) {
        if (arg == 0) {
            return add(arg + 10);
        }
        if (arg == 1) {
            return sub(arg + 10);
        }
        if (arg == 2) {
            return mul(arg + 10);
        }
        if (arg == 3) {
            return div(arg + 10);
        }
        return 0;
    }

    public static float add(float x) {
        float c = 1.0f;
        float t = x + c;
        if (cond) {
            float u = x + c;
            return t + u;
        }
        return 1.0f;
    }

    public static float sub(float x) {
        float c = 1.0f;
        float t = x - c;
        if (cond) {
            float u = x - c;
            return t - u;
        }
        return 1.0f;
    }

    public static float mul(float x) {
        float c = 1.0f;
        float t = x * c;
        if (cond) {
            float u = x * c;
            return t * u;
        }
        return 1.0f;
    }

    public static float div(float x) {
        float c = 1.0f;
        float t = x / c;
        if (cond) {
            float u = x / c;
            return t / u;
        }
        return 1.0f;
    }

    @Test
    public void run0() throws Throwable {
        runTest("test", 0f);
    }

    @Test
    public void run1() throws Throwable {
        runTest("test", 1f);
    }

    @Test
    public void run2() throws Throwable {
        runTest("test", 2f);
    }

    @Test
    public void run3() throws Throwable {
        runTest("test", 3f);
    }

}
