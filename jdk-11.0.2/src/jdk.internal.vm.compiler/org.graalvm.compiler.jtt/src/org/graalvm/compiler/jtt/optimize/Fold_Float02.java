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
 * Tests constant folding of integer comparisons.
 */
public class Fold_Float02 extends JTTTest {

    public static boolean test(int arg) {
        if (arg == 0) {
            return equ();
        }
        if (arg == 1) {
            return neq();
        }
        if (arg == 2) {
            return geq();
        }
        if (arg == 3) {
            return ge();
        }
        if (arg == 4) {
            return ltq();
        }
        if (arg == 5) {
            return lt();
        }
        return false;
    }

    static boolean equ() {
        float x = 34;
        return x == 34;
    }

    static boolean neq() {
        float x = 34;
        return x != 33;
    }

    static boolean geq() {
        float x = 34;
        return x >= 33;
    }

    static boolean ge() {
        float x = 34;
        return x > 35;
    }

    static boolean ltq() {
        float x = 34;
        return x <= 32;
    }

    static boolean lt() {
        float x = 34;
        return x < 31;
    }

    @Test
    public void run0() throws Throwable {
        runTest("test", 0);
    }

    @Test
    public void run1() throws Throwable {
        runTest("test", 1);
    }

    @Test
    public void run2() throws Throwable {
        runTest("test", 2);
    }

    @Test
    public void run3() throws Throwable {
        runTest("test", 3);
    }

    @Test
    public void run4() throws Throwable {
        runTest("test", 4);
    }

    @Test
    public void run5() throws Throwable {
        runTest("test", 5);
    }

}
