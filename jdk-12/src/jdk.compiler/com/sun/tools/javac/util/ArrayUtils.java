/*
 * Copyright (c) 1999, 2013, Oracle and/or its affiliates. All rights reserved.
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
 *
 *
 */

package com.sun.tools.javac.util;

import java.lang.reflect.Array;

/** <p><b>This is NOT part of any supported API.
 *  If you write code that depends on this, you do so at your own risk.
 *  This code and its internal interfaces are subject to change or
 *  deletion without notice.</b>
 */
public class ArrayUtils {

    private static int calculateNewLength(int currentLength, int maxIndex) {
        while (currentLength < maxIndex + 1)
            currentLength = currentLength * 2;
        return currentLength;
    }

    public static <T> T[] ensureCapacity(T[] array, int maxIndex) {
        if (maxIndex < array.length) {
            return array;
        } else {
            int newLength = calculateNewLength(array.length, maxIndex);
            @SuppressWarnings("unchecked")
            T[] result = (T[]) Array.newInstance(array.getClass().getComponentType(), newLength);
            System.arraycopy(array, 0, result, 0, array.length);
            return result;
        }
    }

    public static byte[] ensureCapacity(byte[] array, int maxIndex) {
        if (maxIndex < array.length) {
            return array;
        } else {
            int newLength = calculateNewLength(array.length, maxIndex);
            byte[] result = new byte[newLength];
            System.arraycopy(array, 0, result, 0, array.length);
            return result;
        }
    }

    public static char[] ensureCapacity(char[] array, int maxIndex) {
        if (maxIndex < array.length) {
            return array;
        } else {
            int newLength = calculateNewLength(array.length, maxIndex);
            char[] result = new char[newLength];
            System.arraycopy(array, 0, result, 0, array.length);
            return result;
        }
    }

    public static int[] ensureCapacity(int[] array, int maxIndex) {
        if (maxIndex < array.length) {
            return array;
        } else {
            int newLength = calculateNewLength(array.length, maxIndex);
            int[] result = new int[newLength];
            System.arraycopy(array, 0, result, 0, array.length);
            return result;
        }
    }

}
