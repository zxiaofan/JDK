/*
 * Copyright (c) 2011, 2013, Oracle and/or its affiliates. All rights reserved.
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


package org.graalvm.compiler.core.common;

// JaCoCo Exclude

import jdk.vm.ci.code.CodeUtil;

/**
 * A collection of static utility functions that check ranges of numbers.
 */
public class NumUtil {

    public static boolean isShiftCount(int x) {
        return 0 <= x && x < 32;
    }

    /**
     * Determines if a given {@code int} value is the range of unsigned byte values.
     */
    public static boolean isUByte(int x) {
        return (x & 0xff) == x;
    }

    /**
     * Determines if a given {@code int} value is the range of signed byte values.
     */
    public static boolean isByte(int x) {
        return (byte) x == x;
    }

    /**
     * Determines if a given {@code long} value is the range of unsigned byte values.
     */
    public static boolean isUByte(long x) {
        return (x & 0xffL) == x;
    }

    /**
     * Determines if a given {@code long} value is the range of signed byte values.
     */
    public static boolean isByte(long l) {
        return (byte) l == l;
    }

    /**
     * Determines if a given {@code long} value is the range of unsigned int values.
     */
    public static boolean isUInt(long x) {
        return (x & 0xffffffffL) == x;
    }

    /**
     * Determines if a given {@code long} value is the range of signed int values.
     */
    public static boolean isInt(long l) {
        return (int) l == l;
    }

    /**
     * Determines if a given {@code int} value is the range of signed short values.
     */
    public static boolean isShort(int x) {
        return (short) x == x;
    }

    /**
     * Determines if a given {@code long} value is the range of signed short values.
     */
    public static boolean isShort(long x) {
        return (short) x == x;
    }

    public static boolean isUShort(int s) {
        return s == (s & 0xFFFF);
    }

    public static boolean isUShort(long s) {
        return s == (s & 0xFFFF);
    }

    public static boolean is32bit(long x) {
        return -0x80000000L <= x && x < 0x80000000L;
    }

    public static short safeToShort(int v) {
        assert isShort(v);
        return (short) v;
    }

    public static int roundUp(int number, int mod) {
        return ((number + mod - 1) / mod) * mod;
    }

    public static long roundUp(long number, long mod) {
        return ((number + mod - 1L) / mod) * mod;
    }

    public static int roundDown(int number, int mod) {
        return number / mod * mod;
    }

    public static long roundDown(long number, long mod) {
        return number / mod * mod;
    }

    public static int log2Ceil(int val) {
        int x = 1;
        int log2 = 0;
        while (x < val) {
            log2++;
            x *= 2;
        }
        return log2;
    }

    public static boolean isUnsignedNbit(int n, int value) {
        assert n > 0 && n < 32;
        return 32 - Integer.numberOfLeadingZeros(value) <= n;
    }

    public static boolean isUnsignedNbit(int n, long value) {
        assert n > 0 && n < 64;
        return 64 - Long.numberOfLeadingZeros(value) <= n;
    }

    public static boolean isSignedNbit(int n, int value) {
        assert n > 0 && n < 32;
        int min = -(1 << (n - 1));
        int max = (1 << (n - 1)) - 1;
        return value >= min && value <= max;
    }

    public static boolean isSignedNbit(int n, long value) {
        assert n > 0 && n < 64;
        long min = -(1L << (n - 1));
        long max = (1L << (n - 1)) - 1;
        return value >= min && value <= max;
    }

    /**
     *
     * @param n Number of bits that should be set to 1. Must be between 0 and 32 (inclusive).
     * @return A number with n bits set to 1.
     */
    public static int getNbitNumberInt(int n) {
        assert n >= 0 && n <= 32 : "0 <= n <= 32; instead: " + n;
        if (n < 32) {
            return (1 << n) - 1;
        } else {
            return 0xFFFFFFFF;
        }
    }

    /**
     *
     * @param n Number of bits that should be set to 1. Must be between 0 and 64 (inclusive).
     * @return A number with n bits set to 1.
     */
    public static long getNbitNumberLong(int n) {
        assert n >= 0 && n <= 64;
        if (n < 64) {
            return (1L << n) - 1;
        } else {
            return 0xFFFFFFFFFFFFFFFFL;
        }
    }

    /**
     * Get the minimum value representable in a {@code bits} bit signed integer.
     */
    public static long minValue(int bits) {
        return CodeUtil.minValue(bits);
    }

    /**
     * Get the maximum value representable in a {@code bits} bit signed integer.
     */
    public static long maxValue(int bits) {
        return CodeUtil.maxValue(bits);
    }

    /**
     * Get the maximum value representable in a {@code bits} bit unsigned integer.
     */
    public static long maxValueUnsigned(int bits) {
        return getNbitNumberLong(bits);
    }

    public static long maxUnsigned(long a, long b) {
        if (Long.compareUnsigned(a, b) > 0) {
            return b;
        }
        return a;
    }

    public static long minUnsigned(long a, long b) {
        if (Long.compareUnsigned(a, b) > 0) {
            return a;
        }
        return b;
    }

    public static boolean sameSign(long a, long b) {
        return a < 0 == b < 0;
    }
}
