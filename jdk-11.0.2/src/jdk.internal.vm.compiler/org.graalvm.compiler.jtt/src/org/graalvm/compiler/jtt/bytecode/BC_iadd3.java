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
public class BC_iadd3 extends JTTTest {

    public static int test(short a, short b) {
        return a + b;
    }

    @Test
    public void run0() throws Throwable {
        runTest("test", ((short) 1), ((short) 2));
    }

    @Test
    public void run1() throws Throwable {
        runTest("test", ((short) 0), ((short) -1));
    }

    @Test
    public void run2() throws Throwable {
        runTest("test", ((short) 33), ((short) 67));
    }

    @Test
    public void run3() throws Throwable {
        runTest("test", ((short) 1), ((short) -1));
    }

    @Test
    public void run4() throws Throwable {
        runTest("test", ((short) -128), ((short) 1));
    }

    @Test
    public void run5() throws Throwable {
        runTest("test", ((short) 127), ((short) 1));
    }

    @Test
    public void run6() throws Throwable {
        runTest("test", ((short) -32768), ((short) 1));
    }

    @Test
    public void run7() throws Throwable {
        runTest("test", ((short) 32767), ((short) 1));
    }

}
