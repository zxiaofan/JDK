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


package org.graalvm.compiler.jtt.lang;

import org.junit.Test;

import org.graalvm.compiler.jtt.JTTTest;

public final class Long_greaterEqual02 extends JTTTest {

    public static boolean test(long i) {
        if (i >= 5L) {
            return true;
        }
        return false;
    }

    @Test
    public void run0() throws Throwable {
        runTest("test", -9223372036854775808L);
    }

    @Test
    public void run1() throws Throwable {
        runTest("test", -2L);
    }

    @Test
    public void run2() throws Throwable {
        runTest("test", -1L);
    }

    @Test
    public void run3() throws Throwable {
        runTest("test", 0L);
    }

    @Test
    public void run4() throws Throwable {
        runTest("test", 1L);
    }

    @Test
    public void run5() throws Throwable {
        runTest("test", 4L);
    }

    @Test
    public void run6() throws Throwable {
        runTest("test", 5L);
    }

    @Test
    public void run7() throws Throwable {
        runTest("test", 6L);
    }

    @Test
    public void run8() throws Throwable {
        runTest("test", 9223372036854775807L);
    }

}
