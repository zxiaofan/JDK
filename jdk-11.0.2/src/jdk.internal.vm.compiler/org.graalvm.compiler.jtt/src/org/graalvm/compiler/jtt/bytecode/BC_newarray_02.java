/*
 * Copyright (c) 2016, 2016, Oracle and/or its affiliates. All rights reserved.
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


package org.graalvm.compiler.jtt.bytecode;

import org.graalvm.compiler.jtt.JTTTest;
import org.junit.Test;

public class BC_newarray_02 extends JTTTest {
    public static byte[] test(int l) {
        return new byte[l];
    }

    @Test
    public void testZero() {
        runTest("test", 0);
    }

    @Test
    public void testOne() {
        runTest("test", 1);
    }

    @Test
    public void testNegative() {
        runTest("test", -1);
    }

    @Test
    public void testLarge() {
        runTest("test", 17 * 1024 * 1024);
    }
}
