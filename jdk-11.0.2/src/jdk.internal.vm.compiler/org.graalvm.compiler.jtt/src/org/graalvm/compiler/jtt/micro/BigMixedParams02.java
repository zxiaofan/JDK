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
 * Copyright (c) 2007, 2012, Oracle and/or its affiliates. All rights reserved.
 */


package org.graalvm.compiler.jtt.micro;

import org.junit.Test;

import org.graalvm.compiler.jtt.JTTTest;

/*
 */
public class BigMixedParams02 extends JTTTest {

    @SuppressWarnings("unused")
    public static float test(int choice, int i0, int i1, int i2, int i3, float p0, float p1, float p2, float p3, int i4, int i5, float p4, float p5, float p6, float p7, float p8) {
        switch (choice) {
            case 0:
                return p0;
            case 1:
                return p1;
            case 2:
                return p2;
            case 3:
                return p3;
            case 4:
                return p4;
            case 5:
                return p5;
            case 6:
                return p6;
            case 7:
                return p7;
            case 8:
                return p8;
        }
        return 42;
    }

    @Test
    public void run0() throws Throwable {
        runTest("test", 0, -1, -1, -1, -1, 1f, 2f, 3f, 4f, -1, -1, 5f, 6f, 7f, 8f, 9f);
    }

    @Test
    public void run1() throws Throwable {
        runTest("test", 1, -1, -1, -1, -1, 1f, 2f, 3f, 4f, -1, -1, 5f, 6f, 7f, 8f, 9f);
    }

    @Test
    public void run2() throws Throwable {
        runTest("test", 2, -1, -1, -1, -1, 1f, 2f, 3f, 4f, -1, -1, 5f, 6f, 7f, 8f, 9f);
    }

    @Test
    public void run3() throws Throwable {
        runTest("test", 3, -1, -1, -1, -1, 1f, 2f, 3f, 4f, -1, -1, 5f, 6f, 7f, 8f, 9f);
    }

    @Test
    public void run4() throws Throwable {
        runTest("test", 4, -1, -1, -1, -1, 1f, 2f, 3f, 4f, -1, -1, 5f, 6f, 7f, 8f, 9f);
    }

    @Test
    public void run5() throws Throwable {
        runTest("test", 5, -1, -1, -1, -1, 1f, 2f, 3f, 4f, -1, -1, 5f, 6f, 7f, 8f, 9f);
    }

    @Test
    public void run6() throws Throwable {
        runTest("test", 6, -1, -1, -1, -1, 1f, 2f, 3f, 4f, -1, -1, 5f, 6f, 7f, 8f, 9f);
    }

    @Test
    public void run7() throws Throwable {
        runTest("test", 7, -1, -1, -1, -1, 1f, 2f, 3f, 4f, -1, -1, 5f, 6f, 7f, 8f, 9f);
    }

    @Test
    public void run8() throws Throwable {
        runTest("test", 8, -1, -1, -1, -1, 1f, 2f, 3f, 4f, -1, -1, 5f, 6f, 7f, 8f, 9f);
    }

}
