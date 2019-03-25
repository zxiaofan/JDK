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
public class Narrow_byte02 extends JTTTest {

    static class Byte {

        byte foo;
    }

    static Byte val = new Byte();

    public static byte test(byte b) {
        val.foo = b;
        return val.foo;
    }

    @Test
    public void run0() throws Throwable {
        runTest("test", ((byte) 0));
    }

    @Test
    public void run1() throws Throwable {
        runTest("test", ((byte) 1));
    }

    @Test
    public void run2() throws Throwable {
        runTest("test", ((byte) -1));
    }

    @Test
    public void run3() throws Throwable {
        runTest("test", ((byte) 110));
    }

}
