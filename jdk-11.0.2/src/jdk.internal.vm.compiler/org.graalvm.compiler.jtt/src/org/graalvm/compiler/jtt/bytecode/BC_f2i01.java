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


package org.graalvm.compiler.jtt.bytecode;

import org.junit.Test;

import org.graalvm.compiler.jtt.JTTTest;

/*
 */
public class BC_f2i01 extends JTTTest {

    public static int test(float d) {
        return (int) d;
    }

    @Test
    public void run0() throws Throwable {
        runTest("test", 0.0f);
    }

    @Test
    public void run1() throws Throwable {
        runTest("test", 1.0f);
    }

    @Test
    public void run2() throws Throwable {
        runTest("test", -1.06f);
    }

    @Test
    public void run3() throws Throwable {
        runTest("test", -156.82743f);
    }

}
