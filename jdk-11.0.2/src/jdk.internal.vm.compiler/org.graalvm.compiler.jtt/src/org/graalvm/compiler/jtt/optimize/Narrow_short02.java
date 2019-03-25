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
public class Narrow_short02 extends JTTTest {

    static class Short {

        short foo;
    }

    static Short val = new Short();

    public static short test(short b) {
        val.foo = b;
        return val.foo;
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
