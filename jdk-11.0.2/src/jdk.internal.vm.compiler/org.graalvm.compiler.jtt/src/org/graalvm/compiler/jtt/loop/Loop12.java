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
public class Loop12 extends JTTTest {

    private static int[] source = new int[]{10, 15, 20, 25, 30};

    public static int test(int arg) {
        int i = 0;
        if (source[i] != arg) {
            while (++i <= 5 && source[i] != arg) {
                // nothing
            }
        }
        return i;
    }

    @Test
    public void run0() throws Throwable {
        runTest("test", 10);
    }

    @Test
    public void run1() throws Throwable {
        runTest("test", 15);
    }

    @Test
    public void run2() throws Throwable {
        runTest("test", 30);
    }

}
