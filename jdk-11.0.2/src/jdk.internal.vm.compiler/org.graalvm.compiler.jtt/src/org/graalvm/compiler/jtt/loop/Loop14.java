/*
 * Copyright (c) 2011, 2012, Oracle and/or its affiliates. All rights reserved.
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


package org.graalvm.compiler.jtt.loop;

import org.junit.Test;

import org.graalvm.compiler.jtt.JTTTest;

/*
 */
public class Loop14 extends JTTTest {

    private static int value;

    public static int test(int arg) {
        return calc(arg);
    }

    public static int calc(int arg) {
        int result = 0;
        for (int k = 0; k < arg; ++k) {
            value = 5;
            for (int i = 0; i < arg; ++i) {
                for (int j = 0; j < arg; ++j) {
                }
                result += value;
            }
        }
        return result;
    }

    @Test
    public void run0() throws Throwable {
        runTest("test", 1);
    }

    @Test
    public void run1() throws Throwable {
        runTest("test", 1);
    }

}
