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


package org.graalvm.compiler.jtt.jdk;

import org.junit.Test;

import org.graalvm.compiler.jtt.JTTTest;

/*
 */
public class System_nanoTime02 extends JTTTest {

    public static boolean test() {
        long minDelta = Long.MAX_VALUE;

        // the first call to System.nanoTime might take a long time due to call resolution
        for (int c = 0; c < 10; c++) {
            long start = System.nanoTime();
            long delta = 0;
            int i;
            for (i = 0; delta == 0 && i < 50000; i++) {
                delta = System.nanoTime() - start;
                // do nothing.
            }
            if (delta < minDelta) {
                minDelta = delta;
            }
        }

        // better get at least 30 microsecond resolution.
        return minDelta > 1 && minDelta < 30000;
    }

    @Test
    public void run0() throws Throwable {
        runTest("test");
    }

}
