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
public class Long_reverseBytes01 extends JTTTest {

    public static long test(long val) {
        return Long.reverseBytes(val);
    }

    @Test
    public void run0() throws Throwable {
        runTest("test", 0x1122334455667708L);
    }

}
