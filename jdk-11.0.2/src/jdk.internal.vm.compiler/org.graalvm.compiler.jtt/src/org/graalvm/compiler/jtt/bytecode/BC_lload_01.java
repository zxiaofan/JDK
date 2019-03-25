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
@SuppressWarnings("unused")
public class BC_lload_01 extends JTTTest {

    public static long test(int i) {
        return test1(null);
    }

    public static int test1(Object o0) {
        long x = 1;
        return 0;
    }

    @Test
    public void run0() throws Throwable {
        runTest("test", 1);
    }

    @Test
    public void run1() throws Throwable {
        runTest("test", -3);
    }

    @Test
    public void run2() throws Throwable {
        runTest("test", 100);
    }

}
