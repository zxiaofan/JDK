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


package org.graalvm.compiler.jtt.hotpath;

import org.junit.Test;

import org.graalvm.compiler.jtt.JTTTest;

/*
 */
public class HP_control01 extends JTTTest {

    public static int test(int count) {
        int i1 = 1;
        int i2 = 2;
        int i3 = 3;
        int i4 = 4;

        for (int i = 0; i < count; i++) {
            i1 = i2;
            i2 = i3;
            i3 = i4;
            i4 = i1;

            i1 = i2;
            i2 = i3;
            i3 = i4;
            i4 = i1;

            i1 = i2;
            i2 = i3;
            i3 = i4;
            i4 = i1;

            i1 = i2;
            i2 = i3;
            i3 = i4;
            i4 = i1;
        }

        return i1 + i2 * 10 + i3 * 100 + i4 * 1000;
    }

    @Test
    public void run0() throws Throwable {
        runTest("test", 40);
    }

    @Test
    public void run1() throws Throwable {
        runTest("test", 80);
    }

}
