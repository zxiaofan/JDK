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
public class BC_multianewarray extends JTTTest {

    @SuppressWarnings("unused")
    public static int test(int a, int b) {
        final DummyTestClass[][] v = new DummyTestClass[a][b];
        if (v != null) {
            return a;
        }
        return -1;
    }

    @Test
    public void run0() throws Throwable {
        runTest("test", 0, 0);
    }

    @Test
    public void run1() throws Throwable {
        runTest("test", 1, 1);
    }

    @Test
    public void run2() throws Throwable {
        runTest("test", -1, 0);
    }

    @Test
    public void run3() throws Throwable {
        runTest("test", 0, -1);
    }

}
