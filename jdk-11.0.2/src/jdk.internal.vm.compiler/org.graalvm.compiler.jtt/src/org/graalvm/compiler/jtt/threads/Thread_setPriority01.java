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
 */


package org.graalvm.compiler.jtt.threads;

import org.junit.Test;

import org.graalvm.compiler.jtt.JTTTest;

public final class Thread_setPriority01 extends JTTTest {

    public static boolean test(int i) {
        final Thread currentThread = Thread.currentThread();
        final int prev = currentThread.getPriority();
        currentThread.setPriority(i);
        currentThread.setPriority(prev);
        return true;
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
        runTest("test", 5);
    }

    @Test
    public void run3() throws Throwable {
        runTest("test", 10);
    }

    @Test
    public void run4() throws Throwable {
        runTest("test", 11);
    }

}
