/*
 * Copyright (c) 2011, 2012, Oracle and/or its affiliates. All rights reserved.
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


package org.graalvm.compiler.jtt.hotspot;

import org.junit.Test;

import org.graalvm.compiler.jtt.JTTTest;

//@formatter:off

/**
 * @test
 * @bug 6850611
 * @summary int / long arithmetic seems to be broken in 1.6.0_14 HotSpot Server VM (Win XP)
 *
 * @run main Test6850611
 */

public class Test6850611 extends JTTTest {

    public static int test() {
        // for (int j = 0; j < 5; ++j) {
        long x = 0;
        for (int i = Integer.MIN_VALUE; i < Integer.MAX_VALUE; ++i) {
            x += i;
        }
        if (x != -4294967295L) {
            return 97;
        }
        // }
        return 95;
    }

    @Test
    public void run0() throws Throwable {
        runTest("test");
    }

}
