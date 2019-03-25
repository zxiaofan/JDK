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

public final class Thread_sleep01 extends JTTTest {

    @Rule public TestRule timeout = createTimeoutSeconds(20);

    public static boolean test(int i) throws InterruptedException {
        final long before = System.currentTimeMillis();
        Thread.sleep(i);
        return System.currentTimeMillis() - before >= i;
    }

    @Test
    public void run0() throws Throwable {
        runTest("test", 10);
    }

    @Test
    public void run1() throws Throwable {
        runTest("test", 20);
    }

    @Test
    public void run2() throws Throwable {
        runTest("test", 100);
    }

}
