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
 * Copyright (c) 2007, 2012, Oracle and/or its affiliates. All rights reserved.
 */


package org.graalvm.compiler.jtt.except;

import org.junit.Test;

import org.graalvm.compiler.jtt.JTTTest;

/*
 */
public class BC_newarray extends JTTTest {

    @SuppressWarnings("all")
    public static int test(int a) {
        if (new boolean[a] == null) {
            return -1;
        }
        if (new char[a] == null) {
            return -1;
        }
        if (new float[a] == null) {
            return -1;
        }
        if (new double[a] == null) {
            return -1;
        }
        if (new byte[a] == null) {
            return -1;
        }
        if (new short[a] == null) {
            return -1;
        }
        if (new int[a] == null) {
            return -1;
        }
        if (new long[a] == null) {
            return -1;
        }

        return a;
    }

    @Test
    public void run0() throws Throwable {
        runTest("test", -1);
    }

    @Test
    public void run1() throws Throwable {
        runTest("test", 0);
    }

    @Test
    public void run2() throws Throwable {
        runTest("test", 1);
    }

}
