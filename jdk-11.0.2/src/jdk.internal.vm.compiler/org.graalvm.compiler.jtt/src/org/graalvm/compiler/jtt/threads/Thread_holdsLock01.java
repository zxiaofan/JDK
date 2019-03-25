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

public final class Thread_holdsLock01 extends JTTTest {

    static final Object monitor = new Object();

    public static boolean test(int i) {
        if (i == 0) {
            synchronized (monitor) {
                return Thread.holdsLock(monitor);
            }
        } else if (i == 1) {
            synchronized (monitor) {
                // do nothing.
            }
            return Thread.holdsLock(monitor);
        } else if (i == 2) {
            return Thread.holdsLock(null);
        }
        return Thread.holdsLock(monitor);
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
