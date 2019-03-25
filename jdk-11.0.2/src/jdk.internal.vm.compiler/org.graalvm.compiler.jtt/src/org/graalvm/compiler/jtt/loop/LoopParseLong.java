/*
 * Copyright (c) 2012, Oracle and/or its affiliates. All rights reserved.
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


package org.graalvm.compiler.jtt.loop;

import org.junit.Test;

import org.graalvm.compiler.jtt.JTTTest;

public class LoopParseLong extends JTTTest {

    @SuppressWarnings("unused")
    public static long testShortened(String s, int radix) throws NumberFormatException {
        long result = 0;
        boolean negative = false;
        int len = s.length();
        char firstChar = s.charAt(0);
        if (firstChar < '0') {
            if (firstChar == '-') {
                negative = true;
            } else if (firstChar != '+') {
                throw new NumberFormatException();
            }
            if (len == 1) {
                throw new NumberFormatException();
            }
        }
        return result;
    }

    public static long test(String s, int radix) throws NumberFormatException {
        if (s == null) {
            throw new NumberFormatException("null");
        }
        if (radix < Character.MIN_RADIX) {
            throw new NumberFormatException("radix " + radix + " less than Character.MIN_RADIX");
        }
        if (radix > Character.MAX_RADIX) {
            throw new NumberFormatException("radix " + radix + " greater than Character.MAX_RADIX");
        }
        long result = 0;
        boolean negative = false;
        int i = 0;
        int len = s.length();
        long limit = -Long.MAX_VALUE;
        long multmin;
        int digit;
        if (len > 0) {
            char firstChar = s.charAt(0);
            if (firstChar < '0') {
                if (firstChar == '-') {
                    negative = true;
                    limit = Long.MIN_VALUE;
                } else if (firstChar != '+') {
                    throw new NumberFormatException();
                }
                if (len == 1) {
                    throw new NumberFormatException();
                }
                i++;
            }
            multmin = limit / radix;
            while (i < len) {
                digit = Character.digit(s.charAt(i++), radix);
                if (digit < 0) {
                    throw new NumberFormatException();
                }
                if (result < multmin) {
                    throw new NumberFormatException();
                }
                result *= radix;
                if (result < limit + digit) {
                    throw new NumberFormatException();
                }
                result -= digit;
            }
        } else {
            throw new NumberFormatException();
        }
        return negative ? result : -result;
    }

    @Test
    public void run0() throws Throwable {
        runTest("testShortened", "7", 10);
    }

    @Test
    public void run1() throws Throwable {
        runTest("testShortened", "-100", 10);
    }

    @Test
    public void run2() throws Throwable {
        runTest("test", "7", 10);
    }

    @Test
    public void run3() throws Throwable {
        runTest("test", "-100", 10);
    }
}
