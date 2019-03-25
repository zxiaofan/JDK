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

public final class Thread_yield01 extends JTTTest {

    @Rule public TestRule timeout = createTimeoutSeconds(20);

    public static boolean test() {
        Thread.yield();
        return true;
    }

    @Test
    public void run0() throws Throwable {
        runTest("test");
    }

}
