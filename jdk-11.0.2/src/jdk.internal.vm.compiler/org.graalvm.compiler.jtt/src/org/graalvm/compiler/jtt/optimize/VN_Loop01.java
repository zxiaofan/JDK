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


package org.graalvm.compiler.jtt.optimize;

import org.junit.Test;

import org.graalvm.compiler.jtt.JTTTest;

/*
 * Tests value numbering of integer operations.
 */
public class VN_Loop01 extends JTTTest {

    private static boolean cond1 = true;
    private static boolean cond2 = true;

    public static int test(int arg) {
        if (arg == 0) {
            return test1(arg);
        }
        if (arg == 1) {
            return test2(arg);
        }
        if (arg == 2) {
            return test3(arg);
        }
        if (arg == 3) {
            return test4(arg);
        }
        return 0;
    }

    public static int test1(int x) {
        int c = 3;
        int t = x + c;
        while (cond1) {
            if (cond2) {
                int u = x + c; // GVN should recognize u == t
                return t + u;
            }
        }
        return 3; // GVN should recognize 3 == 3
    }

    public static int test2(int x) {
        int c = 3;
        while (cond1) {
            int t = x + c;
            if (cond2) {
                int u = x + c; // GVN should recognize u == t
                return t + u;
            }
        }
        return 3;
    }

    public static int test3(int x) {
        int c = 3;
        int t = x + c;
        while (cond1) {
            if (cond2) {
                int u = x + c; // GVN should recognize u == t
                return t + u;
            }
            int u = x + c; // GVN should recognize u == t
            return t + u;
        }
        return 3; // GVN should recognize 3 == 3
    }

    public static int test4(int x) {
        int c = 3;
        int t = x + c;
        while (cond1) {
            if (!cond2) {
                int u = x + c;
                return t + u;
            }
            int u = x + c;
            return t + u;
        }
        return 3;
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

    @Test
    public void run3() throws Throwable {
        runTest("test", 3);
    }

    @Test
    public void run4() throws Throwable {
        runTest("test", 4);
    }

}
