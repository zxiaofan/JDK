/*
 * Copyright (c) 2015, 2015, Oracle and/or its affiliates. All rights reserved.
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


package org.graalvm.compiler.jtt.loop;

import org.junit.Test;

import org.graalvm.compiler.api.directives.GraalDirectives;
import org.graalvm.compiler.jtt.JTTTest;

/*
 */
public class LoopPhiResolutionTest extends JTTTest {

    public static int test(int count) {
        int i1 = 1;
        int i2 = 2;
        int i3 = 3;
        int i4 = 4;

        for (int i = 0; i < count; i++) {
            i1 = wormhole(i1);
            i2 = wormhole(i2);
            i3 = wormhole(i2);
            i4 = wormhole(i4);
        }
        return i1 + i2 * 10 + i3 * 100 + i4 * 1000;
    }

    private static int wormhole(int x) {
        return (int) GraalDirectives.opaque((long) x);
    }

    @Test
    public void run0() throws Throwable {
        runTest("test", 0);
    }

    @Test
    public void run1() throws Throwable {
        runTest("test", 1);
    }

    @Test
    public void run2() throws Throwable {
        runTest("test", 10);
    }

}
