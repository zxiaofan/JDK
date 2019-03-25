/*
 * Copyright (c) 2009, 2012, Oracle and/or its affiliates. All rights reserved.
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

import org.graalvm.compiler.jtt.JTTTest;

/*
 */
public class Loop03 extends JTTTest {

    public static int test(int count) {
        int i1 = 1;
        int i2 = 2;
        int i4 = 4;

        for (int i = 0; i < count; i++) {
            i1 = i2;
            i2 = 7;
            i4 = i1;
        }
        return i1 + i2 * 10 + i4 * 1000;
    }

    @Test
    public void run0() throws Throwable {
        runTest("test", 10);
    }

}
