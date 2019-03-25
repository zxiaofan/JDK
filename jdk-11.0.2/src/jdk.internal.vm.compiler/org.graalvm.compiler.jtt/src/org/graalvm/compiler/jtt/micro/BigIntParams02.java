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



package org.graalvm.compiler.jtt.micro;

import org.junit.Test;

import org.graalvm.compiler.jtt.JTTTest;

/*
 */
public class BigIntParams02 extends JTTTest {

    public static int test(int choice, int p0, int p1, int p2, int p3, int p4, int p5, int p6, int p7, int p8) {
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
        runTest("test", 0, 1, 2, 3, 4, 5, 6, 7, -8, -9);
    }

    @Test
    public void run1() throws Throwable {
        runTest("test", 1, 1, 2, 3, 4, 5, 6, 7, -8, -9);
    }

    @Test
    public void run2() throws Throwable {
        runTest("test", 2, 1, 2, 3, 4, 5, 6, 7, -8, -9);
    }

    @Test
    public void run3() throws Throwable {
        runTest("test", 3, 1, 2, 3, 4, 5, 6, 7, -8, -9);
    }

    @Test
    public void run4() throws Throwable {
        runTest("test", 4, 1, 2, 3, 4, 5, 6, 7, -8, -9);
    }

    @Test
    public void run5() throws Throwable {
        runTest("test", 5, 1, 2, 3, 4, 5, 6, 7, -8, -9);
    }

    @Test
    public void run6() throws Throwable {
        runTest("test", 6, 1, 2, 3, 4, 5, 6, 7, -8, -9);
    }

    @Test
    public void run7() throws Throwable {
        runTest("test", 7, 1, 2, 3, 4, 5, 6, 7, -8, -9);
    }

    @Test
    public void run8() throws Throwable {
        runTest("test", 8, 1, 2, 3, 4, 5, 6, 7, -8, -9);
    }

}
