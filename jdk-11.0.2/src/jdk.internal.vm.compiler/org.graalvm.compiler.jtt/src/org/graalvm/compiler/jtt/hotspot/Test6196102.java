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

/**
 * @bug 6196102
 * @summary Integer seems to be greater than {@link Integer#MAX_VALUE}.
 *
 * @run main Test6196102
 */
public class Test6196102 extends JTTTest {

    public static String test() {
        int i1 = 0;
        int i2 = Integer.MAX_VALUE;

        while (i1 >= 0) {
            i1++;
            if (i1 > i2) {
                return "E R R O R: " + i1;
            }
        }
        return "ok";
    }

    @Test
    public void run0() throws Throwable {
        runTest("test");
    }

}
