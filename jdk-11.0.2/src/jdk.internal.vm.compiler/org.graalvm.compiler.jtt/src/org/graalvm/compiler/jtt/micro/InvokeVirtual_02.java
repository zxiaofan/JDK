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
/*
 */


package org.graalvm.compiler.jtt.micro;

import org.junit.Test;

import org.graalvm.compiler.jtt.JTTTest;

public class InvokeVirtual_02 extends JTTTest {

    static class A {

        long plus(long a) {
            return a;
        }
    }

    static class B extends A {

        @Override
        long plus(long a) {
            return a + 10;
        }
    }

    static class C extends A {

        @Override
        long plus(long a) {
            return a + 20;
        }
    }

    static A objectA = new A();
    static A objectB = new B();
    static A objectC = new C();

    public static long test(long a) {
        if (a == 0) {
            return objectA.plus(a);
        }
        if (a == 1) {
            return objectB.plus(a);
        }
        if (a == 2) {
            return objectC.plus(a);
        }
        return 42;
    }

    @Test
    public void run0() throws Throwable {
        runTest("test", 0L);
    }

    @Test
    public void run1() throws Throwable {
        runTest("test", 1L);
    }

    @Test
    public void run2() throws Throwable {
        runTest("test", 2L);
    }

    @Test
    public void run3() throws Throwable {
        runTest("test", 3L);
    }

}
