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


package org.graalvm.compiler.replacements.test;

import org.graalvm.compiler.replacements.ArraysSubstitutions;

import java.util.Arrays;

/**
 * Tests {@link ArraysSubstitutions}.
 */
public class ArraysSubstitutionsTestBase extends MethodSubstitutionTest {

    @SuppressWarnings("all")
    public static boolean arraysEqualsBoolean(boolean[] a, boolean[] b) {
        return Arrays.equals(a, b);
    }

    @SuppressWarnings("all")
    public static boolean arraysEqualsByte(byte[] a, byte[] b) {
        return Arrays.equals(a, b);
    }

    @SuppressWarnings("all")
    public static boolean arraysEqualsChar(char[] a, char[] b) {
        return Arrays.equals(a, b);
    }

    @SuppressWarnings("all")
    public static boolean arraysEqualsShort(short[] a, short[] b) {
        return Arrays.equals(a, b);
    }

    @SuppressWarnings("all")
    public static boolean arraysEqualsInt(int[] a, int[] b) {
        return Arrays.equals(a, b);
    }

    @SuppressWarnings("all")
    public static boolean arraysEqualsLong(long[] a, long[] b) {
        return Arrays.equals(a, b);
    }

    interface ArrayBuilder {
        Object newArray(int length, int firstValue, int lastValue);
    }

    static boolean[] booleanArray(int length, int firstValue, int lastValue) {
        boolean[] arr = new boolean[length];
        for (int i = 0; i < length; i++) {
            arr[i] = (i & 1) == 0;
        }
        if (length > 0) {
            arr[0] = (firstValue & 1) == 0;
        }
        if (length > 1) {
            arr[length - 1] = (lastValue & 1) == 0;
        }
        return arr;
    }

    static byte[] byteArray(int length, int firstValue, int lastValue) {
        byte[] arr = new byte[length];
        for (int i = 0; i < length; i++) {
            arr[i] = (byte) i;
        }
        if (length > 0) {
            arr[0] = (byte) firstValue;
        }
        if (length > 1) {
            arr[length - 1] = (byte) lastValue;
        }
        return arr;
    }

    static char[] charArray(int length, int firstValue, int lastValue) {
        char[] arr = new char[length];
        for (int i = 0; i < length; i++) {
            arr[i] = (char) i;
        }
        if (length > 0) {
            arr[0] = (char) firstValue;
        }
        if (length > 1) {
            arr[length - 1] = (char) lastValue;
        }
        return arr;
    }

    static short[] shortArray(int length, int firstValue, int lastValue) {
        short[] arr = new short[length];
        for (int i = 0; i < length; i++) {
            arr[i] = (short) i;
        }
        if (length > 0) {
            arr[0] = (short) firstValue;
        }
        if (length > 1) {
            arr[length - 1] = (short) lastValue;
        }
        return arr;
    }

    static int[] intArray(int length, int firstValue, int lastValue) {
        int[] arr = new int[length];
        for (int i = 0; i < length; i++) {
            arr[i] = i;
        }
        if (length > 0) {
            arr[0] = firstValue;
        }
        if (length > 1) {
            arr[length - 1] = lastValue;
        }
        return arr;
    }

    static long[] longArray(int length, int firstValue, int lastValue) {
        long[] arr = new long[length];
        for (int i = 0; i < length; i++) {
            arr[i] = i;
        }
        if (length > 0) {
            arr[0] = firstValue;
        }
        if (length > 1) {
            arr[length - 1] = lastValue;
        }
        return arr;
    }
}
