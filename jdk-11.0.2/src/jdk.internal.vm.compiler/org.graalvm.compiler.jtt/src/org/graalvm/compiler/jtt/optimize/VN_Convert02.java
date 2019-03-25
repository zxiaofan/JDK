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
 * Tests optimization integer conversions.
 */
public class VN_Convert02 extends JTTTest {

    private static boolean cond = true;

    public static int test(int arg) {
        if (arg == 0) {
            return i2b(arg + 10);
        }
        if (arg == 1) {
            return i2s(arg + 10);
        }
        if (arg == 2) {
            return i2c(arg + 10);
        }
        return 0;
    }

    public static int i2b(int arg) {
        int x = (byte) arg;
        if (cond) {
            int y = (byte) arg;
            return x + y;
        }
        return 0;
    }

    public static int i2s(int arg) {
        int x = (short) arg;
        if (cond) {
            int y = (short) arg;
            return x + y;
        }
        return 0;
    }

    public static int i2c(int arg) {
        int x = (char) arg;
        if (cond) {
            int y = (char) arg;
            return x + y;
        }
        return 0;
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
