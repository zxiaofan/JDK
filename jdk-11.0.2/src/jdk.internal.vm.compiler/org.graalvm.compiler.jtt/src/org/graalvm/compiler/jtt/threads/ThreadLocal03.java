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


package org.graalvm.compiler.jtt.threads;

import org.junit.Test;

import org.graalvm.compiler.jtt.JTTTest;

/*
 */
public class ThreadLocal03 extends JTTTest {

    static final ThreadLocal<Integer> local = new ThreadLocal<>();

    public static int test(int i) {
        int sum = 0;
        for (int j = 0; j < i; j++) {
            TThread t = new TThread();
            t.input = 10 + j;
            t.run();
            try {
                t.join();
            } catch (InterruptedException e) {
                return -1;
            }
            sum += t.output;
        }
        return sum;
    }

    private static class TThread extends Thread {

        int input;
        int output;

        @Override
        public void run() {
            local.set(input + 5);
            output = local.get();
        }
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
