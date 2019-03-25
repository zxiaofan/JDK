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
 */
public class Narrow_char01 extends JTTTest {

    public static char val;

    public static char test(char b) {
        val = b;
        return val;
    }

    @Test
    public void run0() throws Throwable {
        runTest("test", ((char) 0));
    }

    @Test
    public void run1() throws Throwable {
        runTest("test", ((char) 1));
    }

    @Test
    public void run2() throws Throwable {
        runTest("test", ((char) 255));
    }

    @Test
    public void run3() throws Throwable {
        runTest("test", ((char) 65000));
    }

}
