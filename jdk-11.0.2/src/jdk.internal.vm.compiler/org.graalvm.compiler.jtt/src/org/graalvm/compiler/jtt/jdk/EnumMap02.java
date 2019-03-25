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


package org.graalvm.compiler.jtt.jdk;

import java.util.EnumMap;

import org.junit.Test;

import org.graalvm.compiler.jtt.JTTTest;

/*
 */
public class EnumMap02 extends JTTTest {

    public static String test(int i) {
        EnumMap<Enum, String> map = new EnumMap<>(Enum.class);
        map.put(Enum.A, "A");
        map.put(Enum.B, "B");
        map.put(Enum.C, "C");
        return map.get(Enum.values()[i]);
    }

    private enum Enum {
        A,
        B,
        C
    }

    @Test
    public void run0() throws Throwable {
        runTest("test", 0);
    }

    @Test
    public void run1() throws Throwable {
        runTest("test", 1);
    }

    @Test
    public void run2() throws Throwable {
        runTest("test", 2);
    }

}
