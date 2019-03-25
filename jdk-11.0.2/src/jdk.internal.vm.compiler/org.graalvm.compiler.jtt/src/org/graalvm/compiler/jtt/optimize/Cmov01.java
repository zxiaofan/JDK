/*
 * Copyright (c) 2010, 2012, Oracle and/or its affiliates. All rights reserved.
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
 */
public class Cmov01 extends JTTTest {

    public static boolean test(int a, int b) {
        boolean result = a < b || a == b;
        return result;
    }

    @Test
    public void run0() throws Throwable {
        runTest("test", -1, -1);
    }

    @Test
    public void run1() throws Throwable {
        runTest("test", 1, 10);
    }

    @Test
    public void run2() throws Throwable {
        runTest("test", 1, 0);
    }

}
