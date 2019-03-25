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
public class System_currentTimeMillis02 extends JTTTest {

    static void m(long[] times) {
        times[1] = System.currentTimeMillis() - times[0];
    }

    public static boolean test() {
        long[] times = new long[2];  // { start, delta }
        times[0] = System.currentTimeMillis();
        times[1] = 0;
        // force compilation:
        for (int i = 0; i < 5000; i++) {
            m(times);
        }
        times[0] = System.currentTimeMillis();
        times[1] = 0;
        for (int i = 0; times[1] == 0 && i < 5000000; i++) {
            m(times);
            // do nothing.
        }
        // better get at least 100 millisecond resolution.
        return times[1] >= 1 && times[1] < 100;
    }

    @Test
    public void run0() throws Throwable {
        runTest("test");
    }

}
