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


package org.graalvm.compiler.jtt.optimize;

import org.junit.Test;

import org.graalvm.compiler.jtt.JTTTest;

/**
 * inspired by java.security.SecureRandom.longToByteArray(long).
 *
 */
public class LongToSomethingArray01 extends JTTTest {

    public static byte[] longToByteArray(long arg) {
        long l = arg;
        byte[] ret = new byte[8];
        for (int i = 0; i < 8; i++) {
            ret[i] = (byte) (l & 0xff);
            l = l >> 8;
        }
        return ret;
    }

    @Test
    public void runB0() throws Throwable {
        runTest("longToByteArray", 0x1122_3344_5566_7788L);
    }

    public static short[] longToShortArray(long arg) {
        long l = arg;
        short[] ret = new short[4];
        for (int i = 0; i < 4; i++) {
            ret[i] = (short) (l & 0xffff);
            l = l >> 16;
        }
        return ret;
    }

    @Test
    public void runS0() throws Throwable {
        runTest("longToShortArray", 0x1122_3344_5566_7788L);
    }

    public static int[] longToIntArray(long arg) {
        long l = arg;
        int[] ret = new int[2];
        for (int i = 0; i < 2; i++) {
            ret[i] = (int) (l & 0xffff_ffff);
            l = l >> 32;
        }
        return ret;
    }

    @Test
    public void runI0() throws Throwable {
        runTest("longToIntArray", 0x1122_3344_5566_7788L);
    }

    public static long[] longToLongArray(long arg) {
        long l = arg;
        long[] ret = new long[1];
        for (int i = 0; i < 1; i++) {
            ret[i] = l & 0xffff_ffff_ffff_ffffL;
            l = l >> 64;
        }
        return ret;
    }

    @Test
    public void runL0() throws Throwable {
        runTest("longToLongArray", 0x1122_3344_5566_7788L);
    }
}
