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
public class BC_newarray extends JTTTest {

    @SuppressWarnings("all")
    public static int test(int a) {
        if (new boolean[3] == null) {
            return -1;
        }
        if (new char[3] == null) {
            return -1;
        }
        if (new float[3] == null) {
            return -1;
        }
        if (new double[3] == null) {
            return -1;
        }
        if (new byte[3] == null) {
            return -1;
        }
        if (new short[3] == null) {
            return -1;
        }
        if (new int[3] == null) {
            return -1;
        }
        if (new long[3] == null) {
            return -1;
        }

        return a;
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
