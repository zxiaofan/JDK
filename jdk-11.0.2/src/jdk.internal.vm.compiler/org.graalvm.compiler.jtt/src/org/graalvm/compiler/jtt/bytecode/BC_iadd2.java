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
public class BC_iadd2 extends JTTTest {

    public static int test(byte a, byte b) {
        return a + b;
    }

    @Test
    public void run0() throws Throwable {
        runTest("test", ((byte) 1), ((byte) 2));
    }

    @Test
    public void run1() throws Throwable {
        runTest("test", ((byte) 0), ((byte) -1));
    }

    @Test
    public void run2() throws Throwable {
        runTest("test", ((byte) 33), ((byte) 67));
    }

    @Test
    public void run3() throws Throwable {
        runTest("test", ((byte) 1), ((byte) -1));
    }

    @Test
    public void run4() throws Throwable {
        runTest("test", ((byte) -128), ((byte) 1));
    }

    @Test
    public void run5() throws Throwable {
        runTest("test", ((byte) 127), ((byte) 1));
    }

}
