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


package org.graalvm.compiler.jtt.bytecode;

import org.junit.Test;

import org.graalvm.compiler.jtt.JTTTest;

/*
 */
public class BC_tableswitch3 extends JTTTest {

    public static int test(int a) {
        switch (a) {
            case -2:
                return 22;
            case -1:
                return 11;
            case 0:
                return 33;
            case 1:
                return 77;
        }
        return 99;
    }

    @Test
    public void run0() throws Throwable {
        runTest("test", -1);
    }

    @Test
    public void run1() throws Throwable {
        runTest("test", -2);
    }

    @Test
    public void run2() throws Throwable {
        runTest("test", -3);
    }

    @Test
    public void run3() throws Throwable {
        runTest("test", -4);
    }

    @Test
    public void run4() throws Throwable {
        runTest("test", 1);
    }

    @Test
    public void run5() throws Throwable {
        runTest("test", 2);
    }

    @Test
    public void run6() throws Throwable {
        runTest("test", 10);
    }

}
