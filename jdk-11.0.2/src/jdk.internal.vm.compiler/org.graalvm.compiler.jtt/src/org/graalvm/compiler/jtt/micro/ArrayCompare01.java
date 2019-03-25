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
public class ArrayCompare01 extends JTTTest {

    static final long[] a1 = {1, 2, 3, -5};
    static final long[] a2 = {1, 2, 3, -5};
    static final long[] a3 = {1, 2, 4, -5};

    public static boolean test(int arg) {
        if (arg == 0) {
            return compare(a1, a2);
        }
        if (arg == 1) {
            return compare(a1, a3);
        }
        return false;
    }

    static boolean compare(long[] a, long[] b) {
        if (a.length == b.length) {
            for (int i = 0; i < a.length; i++) {
                if (a[i] != b[i]) {
                    return false;
                }
            }
            return true;
        }
        return false;
    }

    @Test
    public void run0() throws Throwable {
        runTest("test", 0);
    }

    @Test
    public void run1() throws Throwable {
        runTest("test", 1);
    }

}
