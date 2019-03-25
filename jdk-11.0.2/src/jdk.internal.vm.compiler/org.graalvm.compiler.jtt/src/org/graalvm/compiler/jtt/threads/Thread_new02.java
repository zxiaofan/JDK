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

public class Thread_new02 extends JTTTest {

    private static class TestClass implements Runnable {
        @Override
        public void run() {
            // do nothing.
        }
    }

    static final TestClass thisObject = new TestClass();

    public static boolean test(int i) {
        if (i == 0) {
            return new Thread() != null;
        }
        if (i == 1) {
            return new Thread("Thread_new01") != null;
        }
        if (i == 2) {
            return new Thread(thisObject) != null;
        }
        if (i == 3) {
            return new Thread(thisObject, "Thread_new01") != null;
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
