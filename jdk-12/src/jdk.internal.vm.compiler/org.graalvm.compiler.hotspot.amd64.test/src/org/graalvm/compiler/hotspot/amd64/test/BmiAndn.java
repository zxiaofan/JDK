/*
 * Copyright (c) 2018, Oracle and/or its affiliates. All rights reserved.
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


package org.graalvm.compiler.hotspot.amd64.test;

import org.junit.Test;
import org.junit.Assert;

/**
 * Tests Bit Manipulation Instruction andn pattern matching and result.
 */
public class BmiAndn extends BmiCompilerTest {
    // from Intel manual VEX.NDS.LZ.0F38.W0 F2 /r, example c4e260f2c2
    private final byte[] instrMask = new byte[]{
                    (byte) 0xFF,
                    (byte) 0x1F,
                    (byte) 0x00,
                    (byte) 0xFF};
    private final byte[] instrPattern = new byte[]{
                    (byte) 0xC4, // prefix for 3-byte VEX instruction
                    (byte) 0x02, // 00010 implied 0F 38 leading opcode bytes
                    (byte) 0x00,
                    (byte) 0xF2};

    public int andni(int n1, int n2) {
        return (n1 & (~n2));
    }

    public long andnl(long n1, long n2) {
        return (n1 & (~n2));
    }

    // Pattern matching check for andni
    @Test
    public void test1() {
        Assert.assertTrue(verifyPositive("andni", instrMask, instrPattern));
    }

    // Pattern matching check for andnl
    @Test
    public void test2() {
        Assert.assertTrue(verifyPositive("andnl", instrMask, instrPattern));
    }

    // Result correctness check
    @Test
    public void test3() {
        int n1 = 42;
        int n2 = 100;
        test("andni", n1, n2);
    }

    @Test
    public void test4() {
        long n1 = 420000000;
        long n2 = 1000000000;
        test("andnl", n1, n2);
    }
}
