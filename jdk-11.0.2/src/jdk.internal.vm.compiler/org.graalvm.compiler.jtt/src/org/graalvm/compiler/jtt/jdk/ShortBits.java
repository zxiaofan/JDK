/*
 * Copyright (c) 2014, Oracle and/or its affiliates. All rights reserved.
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


package org.graalvm.compiler.jtt.jdk;

import org.junit.Test;

import org.graalvm.compiler.jtt.JTTTest;

public class ShortBits extends JTTTest {
    @SuppressWarnings("unused") private static short init = Short.reverseBytes((short) 42);
    private static short original = 0x1708;

    public static short test(short o) {
        return Short.reverseBytes(o);
    }

    @Test
    public void run0() {
        runTest("test", original);
    }

    @Test
    public void run1() {
        runTest("test", (short) 0x1708L);
    }

    @Test
    public void run2() {
        runTest("test", (short) 0);
        runTest("test", (short) 1);
        runTest("test", (short) -1);
        runTest("test", (short) 0x00ff);
        runTest("test", (short) 0xff00);
        runTest("test", (short) 0xffff);
        runTest("test", (short) 0x3fff);
    }
}
