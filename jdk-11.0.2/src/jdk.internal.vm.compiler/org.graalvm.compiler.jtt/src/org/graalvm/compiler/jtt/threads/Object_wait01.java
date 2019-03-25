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

public class Object_wait01 extends JTTTest {

    @Rule public TestRule timeout = NotOnDebug.create(Timeout.seconds(20));

    private static class TestClass implements Runnable {
        @Override
        public void run() {
            int i = 0;
            while (i++ < 1000000 && !done) {
                synchronized (object) {
                    count++;
                    object.notifyAll();
                }
            }
        }
    }

    static volatile int count = 0;
    static volatile boolean done;
    static final Object object = new Object();

    public static boolean test(int i) throws InterruptedException {
        count = 0;
        done = false;
        new Thread(new TestClass()).start();
        synchronized (object) {
            while (count < i) {
                object.wait();
            }
            done = true;
            return count >= i;
        }
    }

    @Test
    public void run0() throws Throwable {
        initializeForTimeout();
        runTest("test", 0);
    }

    @Test
    public void run1() throws Throwable {
        initializeForTimeout();
        runTest("test", 1);
    }

    @Test
    public void run2() throws Throwable {
        initializeForTimeout();
        runTest("test", 3);
    }

    @Test
    public void run3() throws Throwable {
        initializeForTimeout();
        runTest("test", 15);
    }

}
