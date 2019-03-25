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
 */


package org.graalvm.compiler.jtt.except;

import org.junit.Test;

import org.graalvm.compiler.jtt.JTTTest;

public class BC_baload extends JTTTest {

    static boolean[] arr = {true, false, true, false};

    public static boolean test(int arg) {
        final boolean[] array = arg == -2 ? null : arr;
        return array[arg];
    }

    @Test
    public void run0() throws Throwable {
        runTest("test", -2);
    }

    @Test
    public void run1() throws Throwable {
        runTest("test", -1);
    }

    @Test
    public void run2() throws Throwable {
        runTest("test", 0);
    }

    @Test
    public void run3() throws Throwable {
        runTest("test", 4);
    }

}
