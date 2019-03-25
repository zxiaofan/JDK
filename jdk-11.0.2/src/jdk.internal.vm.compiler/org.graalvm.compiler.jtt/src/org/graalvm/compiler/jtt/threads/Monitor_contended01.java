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

import org.graalvm.compiler.jtt.JTTTest;
import org.graalvm.compiler.jtt.hotspot.NotOnDebug;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestRule;
import org.junit.rules.Timeout;

public final class Monitor_contended01 extends JTTTest {

    @Rule public TestRule timeout = NotOnDebug.create(Timeout.seconds(20));

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
        initializeForTimeout();
        runTest("test");
    }

}
