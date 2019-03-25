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

public final class Thread_getState01 extends JTTTest {

    public static boolean test() {
        return Thread.currentThread().getState() == Thread.State.RUNNABLE;
    }

    @Test
    public void run0() throws Throwable {
        runTest("test");
    }
}
