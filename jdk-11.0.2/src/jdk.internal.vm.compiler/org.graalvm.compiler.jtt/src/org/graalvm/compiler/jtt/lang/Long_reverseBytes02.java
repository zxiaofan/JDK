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


package org.graalvm.compiler.jtt.lang;

import org.junit.Test;

import org.graalvm.compiler.jtt.JTTTest;

/*
 */
public class Long_reverseBytes02 extends JTTTest {

    public static long test(long val) {
        return (((val >> 56) & 0xff) << 0) | (((val >> 48) & 0xff) << 8) | (((val >> 40) & 0xff) << 16) | (((val >> 32) & 0xff) << 24) | (((val >> 24) & 0xff) << 32) | (((val >> 16) & 0xff) << 40) |
                        (((val >> 8) & 0xff) << 48) | (((val >> 0) & 0xff) << 56);
    }

    @Test
    public void run0() throws Throwable {
        runTest("test", 0x1122334455667708L);
    }

}
