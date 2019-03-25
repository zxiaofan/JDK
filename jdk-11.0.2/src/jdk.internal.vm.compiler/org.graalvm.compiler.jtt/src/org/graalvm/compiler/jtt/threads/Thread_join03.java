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
 *
 * This test sleeps the joining thread, which should enure that the joinee is
 * terminated by the time the join occurs.
 */


package org.graalvm.compiler.jtt.threads;

import org.graalvm.compiler.jtt.JTTTest;
import org.graalvm.compiler.jtt.hotspot.NotOnDebug;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestRule;
import org.junit.rules.Timeout;

public class Thread_join03 extends JTTTest {

    @Rule public TestRule timeout = NotOnDebug.create(Timeout.seconds(20));

    private static class TestClass implements Runnable {
        @Override
        public void run() {
            cont = false;
        }
    }

    static volatile boolean cont;

    public static boolean test() throws InterruptedException {
        cont = true;
        final Thread thread = new Thread(new TestClass());
        thread.start();
        Thread.sleep(200);
        thread.join();
        return cont;
    }

    @Test
    public void run0() throws Throwable {
        initializeForTimeout();
        runTest("test");
    }

}
