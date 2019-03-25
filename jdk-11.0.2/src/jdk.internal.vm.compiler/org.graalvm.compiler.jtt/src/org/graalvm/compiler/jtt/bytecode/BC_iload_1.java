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


package org.graalvm.compiler.jtt.bytecode;

import org.junit.Test;

import org.graalvm.compiler.jtt.JTTTest;

/*
 */
public class BC_iload_1 extends JTTTest {

    @SuppressWarnings("unused")
    public static int test(int i, int arg) {
        return arg;
    }

    @Test
    public void run0() throws Throwable {
        runTest("test", 1, 0);
    }

    @Test
    public void run1() throws Throwable {
        runTest("test", 1, -1);
    }

    @Test
    public void run2() throws Throwable {
        runTest("test", 1, 2);
    }

    @Test
    public void run3() throws Throwable {
        runTest("test", 1, 1000345);
    }

}
