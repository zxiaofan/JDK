/*
 * Copyright (c) 2008, 2012, Oracle and/or its affiliates. All rights reserved.
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
public class BC_fcmp01 extends JTTTest {

    public static boolean test(float a, float b) {
        return a < b;
    }

    @Test
    public void run0() throws Throwable {
        runTest("test", 0f, -0.1f);
    }

    @Test
    public void run1() throws Throwable {
        runTest("test", 78.00f, 78.001f);
    }

}
