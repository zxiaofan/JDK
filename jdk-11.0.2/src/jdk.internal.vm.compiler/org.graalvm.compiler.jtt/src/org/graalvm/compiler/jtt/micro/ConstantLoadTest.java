/*
 * Copyright (c) 2015, 2015, Oracle and/or its affiliates. All rights reserved.
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


package org.graalvm.compiler.jtt.micro;

import org.junit.Test;

import org.graalvm.compiler.jtt.JTTTest;

public class ConstantLoadTest extends JTTTest {

    private static final class MyClass {
        public long a;
        public long b;

        MyClass(long a, long b) {
            this.a = a;
            this.b = b;
        }
    }

    private static final MyClass myClass = new MyClass(Long.MIN_VALUE, Long.MAX_VALUE);
    private static final long myLong = Long.MAX_VALUE;

    public static long test(int arg) {
        if (arg == 0) {
            return myClass.a / arg + myLong;
        }
        if (arg == 1) {
            return myClass.b - arg + myLong;
        }
        long r = 1;
        for (int i = 0; i < arg; i++) {
            r *= i;
        }
        return r;
    }

    @Test
    public void run0() throws Throwable {
        runTest("test", 0);
    }

    @Test
    public void run1() throws Throwable {
        runTest("test", -1);
    }

    @Test
    public void run2() throws Throwable {
        runTest("test", 1);
    }

    @Test
    public void run3() throws Throwable {
        runTest("test", 2);
    }

}
