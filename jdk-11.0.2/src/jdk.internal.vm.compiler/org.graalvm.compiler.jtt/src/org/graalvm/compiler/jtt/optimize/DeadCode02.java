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


package org.graalvm.compiler.jtt.optimize;

import org.junit.Test;

import org.graalvm.compiler.jtt.JTTTest;

/*
 */
public class DeadCode02 extends JTTTest {

    public static int test() {
        int i = 0;
        while (true) {
            i++;
            if (test2()) {
                break;
            }
        }
        return i;
    }

    public static boolean test2() {
        return true;
    }

    @Test
    public void run0() throws Throwable {
        runTest("test");
    }

}
