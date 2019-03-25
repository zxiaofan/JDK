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
public class System_nanoTime01 extends JTTTest {

    public static int test() {
        long start = System.nanoTime();
        for (int i = 0; i < 10000000; i++) {
            if (System.nanoTime() - start > 0) {
                return 1;
            }
        }
        return 0;
    }

    @Test
    public void run0() throws Throwable {
        runTest("test");
    }

}
