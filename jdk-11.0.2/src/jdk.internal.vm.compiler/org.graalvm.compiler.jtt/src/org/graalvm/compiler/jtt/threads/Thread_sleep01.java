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

public final class Thread_sleep01 extends JTTTest {

    @Rule public TestRule timeout = NotOnDebug.create(Timeout.seconds(20));

    public static boolean test(int i) throws InterruptedException {
        final long before = System.currentTimeMillis();
        Thread.sleep(i);
        return System.currentTimeMillis() - before >= i;
    }

    @Test
    public void run0() throws Throwable {
        initializeForTimeout();
        runTest("test", 10);
    }

    @Test
    public void run1() throws Throwable {
        initializeForTimeout();
        runTest("test", 20);
    }

    @Test
    public void run2() throws Throwable {
        initializeForTimeout();
        runTest("test", 100);
    }

}
