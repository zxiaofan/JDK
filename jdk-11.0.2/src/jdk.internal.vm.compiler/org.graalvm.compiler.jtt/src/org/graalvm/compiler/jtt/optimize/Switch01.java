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
 * Tests optimization of switches.
 */
public class Switch01 extends JTTTest {

    public static int test(int arg) {
        switch (arg) {
            default:
                return 1;
        }
    }

    @Test
    public void run0() throws Throwable {
        runTest("test", 0);
    }

}
