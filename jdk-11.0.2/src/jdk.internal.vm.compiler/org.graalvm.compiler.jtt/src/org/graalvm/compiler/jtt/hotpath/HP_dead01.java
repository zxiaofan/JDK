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
// Checkstyle: stop


package org.graalvm.compiler.jtt.hotpath;

import org.junit.Test;

import org.graalvm.compiler.jtt.JTTTest;

/*
 */
public class HP_dead01 extends JTTTest {

    public static int test(int count) {
        int sum = 0;
        for (int i = 0; i <= count; i++) {
            int a = i + i;
            int b = i / 2 * i - 10;
            @SuppressWarnings("unused")
            int c = a + b;
            int d = a;
            sum += d;
        }
        return sum;
    }

    @Test
    public void run0() throws Throwable {
        runTest("test", 10);
    }

    @Test
    public void run1() throws Throwable {
        runTest("test", 20);
    }

    @Test
    public void run2() throws Throwable {
        runTest("test", 30);
    }

    @Test
    public void run3() throws Throwable {
        runTest("test", 40);
    }

}
