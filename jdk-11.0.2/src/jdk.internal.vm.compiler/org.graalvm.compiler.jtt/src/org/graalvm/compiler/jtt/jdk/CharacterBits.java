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

public class CharacterBits extends JTTTest {
    @SuppressWarnings("unused") private static char init = Character.reverseBytes((char) 42);
    private static char original = 0x1708;

    public static char test(char o) {
        return Character.reverseBytes(o);
    }

    @Test
    public void run0() {
        runTest("test", original);
    }

    @Test
    public void run1() {
        runTest("test", (char) 0x1708L);
    }

    @Test
    public void run2() {
        runTest("test", (char) 0);
        runTest("test", (char) 1);
        runTest("test", (char) -1);
        runTest("test", (char) 0x00ff);
        runTest("test", (char) 0xff00);
        runTest("test", (char) 0xffff);
        runTest("test", (char) 0x3fff);
    }
}
