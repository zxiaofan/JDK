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
public class BC_lastore extends JTTTest {

    static long[] array = {0, 0, 0, 0};

    public static long test(int arg, long val) {
        final long[] array2 = arg == -2 ? null : BC_lastore.array;
        array2[arg] = val;
        return array2[arg];
    }

    @Test
    public void run0() throws Throwable {
        runTest("test", 0, 0L);
    }

    @Test
    public void run1() throws Throwable {
        runTest("test", 1, -1L);
    }

    @Test
    public void run2() throws Throwable {
        runTest("test", 2, 11L);
    }

    @Test
    public void run3() throws Throwable {
        runTest("test", 3, -14L);
    }

}
