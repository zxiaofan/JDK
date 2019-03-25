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
public class Narrow_short03 extends JTTTest {

    static short[] val = new short[4];

    public static short test(short b) {
        val[0] = b;
        return val[0];
    }

    @Test
    public void run0() throws Throwable {
        runTest("test", ((short) 0));
    }

    @Test
    public void run1() throws Throwable {
        runTest("test", ((short) 1));
    }

    @Test
    public void run2() throws Throwable {
        runTest("test", ((short) -1));
    }

    @Test
    public void run3() throws Throwable {
        runTest("test", ((short) 23110));
    }

}
