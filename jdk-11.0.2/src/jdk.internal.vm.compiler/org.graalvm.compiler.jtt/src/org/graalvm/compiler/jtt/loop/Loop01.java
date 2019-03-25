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
public class Loop01 extends JTTTest {

    public static boolean test() {
        int x = 1;

        for (int i = 0; i < 10; i++) {
            int y = m();
            if (x == 1) {
                return true;
            }
            x = y;
        }
        return false;
    }

    private static int m() {
        return 2;
    }

    @Test
    public void run0() throws Throwable {
        runTest("test");
    }

}
