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
 * Tests constant folding of integer operations.
 */
public class Reduce_Int04 extends JTTTest {

    public static int test(int arg) {
        if (arg == 0) {
            return mul0(arg + 10);
        }
        if (arg == 1) {
            return mul1(arg + 9);
        }
        return 0;
    }

    public static int mul0(int x) {
        return x * 4;
    }

    public static int mul1(int x) {
        return x * 65536;
    }

    @Test
    public void run0() throws Throwable {
        runTest("test", 0);
    }

    @Test
    public void run1() throws Throwable {
        runTest("test", 1);
    }

}
