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


package org.graalvm.compiler.jtt.micro;

import org.junit.Test;

import org.graalvm.compiler.jtt.JTTTest;

/*
 */
public class ArrayCompare02 extends JTTTest {

    static final long[] a1 = {1, 1, 1, 1, 1, 1};
    static final long[] a2 = {1, 1, 1, 2, 1, 1};
    static final long[] a3 = {1, 1, 2, 2, 3, 3};

    public static boolean test(int arg) {
        if (arg == 0) {
            return compare(a1);
        }
        if (arg == 1) {
            return compare(a2);
        }
        if (arg == 2) {
            return compare(a3);
        }
        return false;
    }

    static boolean compare(long[] a) {
        return a[0] == a[1] & a[2] == a[3] & a[4] == a[5];
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

}
