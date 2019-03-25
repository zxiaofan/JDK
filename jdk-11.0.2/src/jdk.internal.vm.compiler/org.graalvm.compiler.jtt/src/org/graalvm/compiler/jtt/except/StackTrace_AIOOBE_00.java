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


package org.graalvm.compiler.jtt.except;

import org.junit.Test;

import org.graalvm.compiler.jtt.JTTTest;

/*
 */
public class StackTrace_AIOOBE_00 extends JTTTest {

    private static int[] array = new int[3];

    public static int test(int a) {
        try {
            return array[a];
        } catch (ArrayIndexOutOfBoundsException npe) {
            for (StackTraceElement e : npe.getStackTrace()) {
                if (e.getClassName().equals(StackTrace_AIOOBE_00.class.getName()) && e.getMethodName().equals("test")) {
                    return -1;
                }
            }
        }
        return -2;
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
        runTest("test", -2);
    }

    @Test
    public void run3() throws Throwable {
        runTest("test", 3);
    }

}
