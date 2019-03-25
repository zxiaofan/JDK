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
 * Tests constant folding of float operations.
 */
public class Fold_Float01 extends JTTTest {

    public static float test(float arg) {
        if (arg == 0) {
            return add();
        }
        if (arg == 1) {
            return sub();
        }
        if (arg == 2) {
            return mul();
        }
        if (arg == 3) {
            return div();
        }
        if (arg == 4) {
            return mod();
        }
        return 0;
    }

    public static float add() {
        float x = 3;
        return x + 7;
    }

    public static float sub() {
        float x = 15;
        return x - 4;
    }

    public static float mul() {
        float x = 6;
        return x * 2;
    }

    public static float div() {
        float x = 26;
        return x / 2;
    }

    public static float mod() {
        float x = 29;
        return x % 15;
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

    @Test
    public void run4() throws Throwable {
        runTest("test", 4f);
    }

}
