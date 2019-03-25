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


package org.graalvm.compiler.jtt.threads;

import org.junit.Test;

import org.graalvm.compiler.jtt.JTTTest;

/*
 */

// Interrupted while running, do nothing, just set the flag and continue
// (thomaswue) This test will exercise deoptimization on HotSpot, because a volatile unloaded field is accessed.
// (thomaswue) The temporary result variable is needed, because in order to query the isInterrupted flag, the thread must be alive.
public class Thread_isInterrupted04 extends JTTTest {

    public static boolean test() throws InterruptedException {
        final Thread1 thread = new Thread1();
        thread.start();
        while (!thread.running) {
            Thread.sleep(10);
        }
        Thread.sleep(100);
        thread.interrupt();
        boolean result = thread.isInterrupted();
        thread.setStop(true);
        return result;
    }

    public static class Thread1 extends java.lang.Thread {

        private volatile boolean stop = false;
        public volatile boolean running = false;
        public long i = 0;

        @Override
        public void run() {
            running = true;
            while (!stop) {
                i++;
            }
        }

        public void setStop(boolean value) {
            stop = value;
        }

    }

    @Test
    public void run0() throws Throwable {
        runTest("test");
    }

}
