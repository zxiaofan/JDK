/*
 * Copyright (c) 2013, 2013, Oracle and/or its affiliates. All rights reserved.
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

public class ConvertCompare extends JTTTest {
    public static boolean test(int a, float d) {
        return a == (double) d;
    }

    @Test
    public void run0() throws Throwable {
        runTest("test", 0, 2.87f);
    }

    public static boolean testChar42(int x) {
        return ((char) x) == 42;
    }

    @Test
    public void run1() {
        runTest("testChar42", 42);
    }

    @Test
    public void run2() {
        runTest("testChar42", (int) Character.MAX_VALUE);
    }

    public static boolean testCharMax(int x) {
        return ((char) x) == Character.MAX_VALUE;
    }

    @Test
    public void run3() {
        runTest("testCharMax", 42);
    }

    @Test
    public void run4() {
        runTest("testCharMax", (int) Character.MAX_VALUE);
    }
}
