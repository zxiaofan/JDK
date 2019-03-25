/*
 * Copyright (c) 2013, Oracle and/or its affiliates. All rights reserved.
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

/**
 * Inspired by {@code com.sun.media.sound.DirectAudioDevice$DirectDL.drain()}.
 *
 * Two loop exits hold a monitor while merging.
 *
 */
public final class SynchronizedLoopExit01 extends JTTTest {

    @Rule public TestRule timeout = NotOnDebug.create(Timeout.seconds(20));

    protected Object object = new Object();
    protected volatile boolean drained = false;
    protected volatile boolean someBoolean = true;

    public boolean test() {
        boolean b = true;
        while (!drained) {
            synchronized (object) {
                boolean c = b = someBoolean;
                if (c || drained) {
                    break;
                }
            }
        }
        return b;
    }

    @Test
    public void run0() throws Throwable {
        initializeForTimeout();
        runTest("test");
    }

}
