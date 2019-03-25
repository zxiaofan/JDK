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


package org.graalvm.compiler.jtt.loop;

import org.junit.Test;

import org.graalvm.compiler.jtt.JTTTest;

/*
 */

public class LoopPhi extends JTTTest {

    public static int test(int arg) {
        for (int i = 0; i < arg; i++) {
            testHelper(1, 1, 1, 1, 1, 1);
        }
        return testHelper(1, 1, 1, 1, 1, 1);
    }

    public static int testHelper(int j1, int j2, int j3, int j4, int j5, int j6) {
        int i1 = j1;
        int i2 = j2;
        int i3 = j3;
        int i4 = j4;
        int i5 = j5;
        int i6 = j6;

        if (i1 == 0) {
            i1 = 2;
        } else {
            i2 = 2;
        }
        for (int i = 0; i < 10; i++) {
            if (i == 0) {
                i3 = 2;
            } else {
                i4 = 2;
            }

            for (int j = 0; j < 10; j++) {
                if (j == 0) {
                    i5 = 2;
                } else {
                    i6 = 2;
                }
            }
        }

        return i1 + i2 + i3 + i4 + i5 + i6;
    }

    @Test
    public void run0() throws Throwable {
        runTest("test", 50000);
    }

}
