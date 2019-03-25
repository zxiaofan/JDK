/*
 * Copyright (c) 2007, 2018, Oracle and/or its affiliates. All rights reserved.
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

import org.graalvm.compiler.jtt.JTTTest;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestRule;

public final class Monitor_contended01 extends JTTTest {

    @Rule public TestRule timeout = createTimeoutSeconds(20);

    private static class TestClass implements Runnable {
        boolean started = false;
        boolean acquired = false;

        @Override
        public void run() {
            // signal that we have started up so first thread will release lock
            synchronized (cond) {
                started = true;
                cond.notifyAll();
            }
            synchronized (obj) {

            }
            // signal that we have successfully acquired and released the monitor
            synchronized (cond) {
                acquired = true;
                cond.notifyAll();
            }
        }
    }

    static final Object cond = new Object();
    static final Object obj = new Object();

    public static boolean test() throws InterruptedException {
        // test contention for monitor
        final TestClass object = new TestClass();
        synchronized (obj) {
            new Thread(object).start();
            // wait for other thread to startup and contend
            synchronized (cond) {
                cond.wait(1000);
                if (!object.started) {
                    return false;
                }
            }
        }
        // wait for other thread to acquire monitor and then exit
        synchronized (cond) {
            cond.wait(1000);
        }
        return object.acquired;
    }

    @Test
    public void run0() throws Throwable {
        runTest("test");
    }

}
