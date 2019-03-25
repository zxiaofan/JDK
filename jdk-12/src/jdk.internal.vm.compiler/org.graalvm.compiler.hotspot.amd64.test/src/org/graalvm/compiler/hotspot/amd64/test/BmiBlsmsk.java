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
 * Tests Bit Manipulation Instruction blsmsk pattern matching and result.
 */
public class BmiBlsmsk extends BmiCompilerTest {
    // from Intel manual VEX.NDD.LZ.0F38.W0 F3 /2, example c4e260f2c2
    private final byte[] instrMask = new byte[]{
                    (byte) 0xFF,
                    (byte) 0x1F,
                    (byte) 0x00,
                    (byte) 0xFF,
                    (byte) 0b0011_1000};
    private final byte[] instrPattern = new byte[]{
                    (byte) 0xC4, // prefix for 3-byte VEX instruction
                    (byte) 0x02, // 00010 implied 0F 38 leading opcode bytes
                    (byte) 0x00,
                    (byte) 0xF3,
                    (byte) 0b0001_0000}; // bits 543 == 010 (2)

    public int blsmski(int n1) {
        return (n1 ^ (n1 - 1));
    }

    public long blsmskl(long n1) {
        return (n1 ^ (n1 - 1));
    }

    // Pattern matching check for blsmski
    @Test
    public void test1() {
        Assert.assertTrue(verifyPositive("blsmski", instrMask, instrPattern));
    }

    // Pattern matching check for blsmskl
    @Test
    public void test2() {
        Assert.assertTrue(verifyPositive("blsmskl", instrMask, instrPattern));
    }

    // Result correctness check
    @Test
    public void test3() {
        int n1 = 42;
        test("blsmski", n1);
    }

    @Test
    public void test4() {
        long n1 = 420000000;
        test("blsmskl", n1);
    }
}
