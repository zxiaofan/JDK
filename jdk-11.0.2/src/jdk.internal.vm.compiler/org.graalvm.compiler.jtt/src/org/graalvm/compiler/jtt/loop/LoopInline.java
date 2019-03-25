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

public class LoopInline extends JTTTest {

    public static int test(int arg) {
        int count = 0;
        for (int i = 0; i < arg; i++) {
            count += foo(i);
            if (count > 15) {
                count -= foo(3);
                break;
            }
        }
        return count;
    }

    public static int foo(int t) {
        int sum = 0;
        for (int i = 0; i < t; i++) {
            sum += i;
            if (i == 4) {
                sum += foo2(sum);
                break;
            }
        }
        return sum;
    }

    public static int foo2(int i) {
        int j = i;
        int sum = 0;
        while (j > 0) {
            sum += j * j;
            j--;
        }
        return sum;
    }

    @Test
    public void run0() throws Throwable {
        runTest("test", 0);
    }

    @Test
    public void run1() throws Throwable {
        runTest("test", 10);
    }

}
