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


package org.graalvm.compiler.jtt.bytecode;

import org.junit.Test;

import org.graalvm.compiler.jtt.JTTTest;

/*
 */
public class BC_lcmp extends JTTTest {

    public static boolean test(long a, long b) {
        return a < b;
    }

    @Test
    public void run0() throws Throwable {
        runTest("test", 0L, -1L);
    }

    @Test
    public void run1() throws Throwable {
        runTest("test", 77L, 78L);
    }

    @Test
    public void run2() throws Throwable {
        runTest("test", -1L, 0L);
    }

    /**
     * Test with ugly numbers (which probably does not fit into one instruction.
     *
     * @throws Throwable
     */
    @Test
    public void run3() throws Throwable {
        runTest("test", 293521900824L, 97726785831L);
    }

    /**
     * Test with big numbers where it makes difference if the value is handled with 64 bits.
     *
     * @throws Throwable
     */
    @Test
    public void run4() throws Throwable {
        runTest("test", -1L, Long.MIN_VALUE);
    }

}
