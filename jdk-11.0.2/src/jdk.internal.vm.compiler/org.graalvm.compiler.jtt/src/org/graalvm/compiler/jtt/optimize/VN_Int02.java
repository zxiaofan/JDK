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
 * Tests optimization of integer operations.
 */
public class VN_Int02 extends JTTTest {

    public static int test(int arg) {
        if (arg == 0) {
            return shift0(arg + 10);
        }
        if (arg == 1) {
            return shift1(arg + 10);
        }
        if (arg == 2) {
            return shift2(arg + 10);
        }
        return 0;
    }

    public static int shift0(int x) {
        int c = 1;
        int t = x >> c;
        int u = x >> c;
        return t + u;
    }

    public static int shift1(int x) {
        int c = 1;
        int t = x >>> c;
        int u = x >>> c;
        return t + u;
    }

    public static int shift2(int x) {
        int c = 1;
        int t = x << c;
        int u = x << c;
        return t + u;
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

}
