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

public class InvokeVirtual_01 extends JTTTest {

    static class A {

        int plus(int a) {
            return a;
        }
    }

    static class B extends A {

        @Override
        int plus(int a) {
            return a + 10;
        }
    }

    static class C extends A {

        @Override
        int plus(int a) {
            return a + 20;
        }
    }

    static A aObject = new A();
    static A bObject = new B();
    static A cObject = new C();

    public static int test(int a) {
        if (a == 0) {
            return aObject.plus(a);
        }
        if (a == 1) {
            return bObject.plus(a);
        }
        if (a == 2) {
            return cObject.plus(a);
        }
        return 42;
    }

    @Test
    public void run0() throws Throwable {
        runTest("test", 0);
    }

    @Test
    public void run1() throws Throwable {
        runTest("test", 1);
    }

    @Test
    public void run2() throws Throwable {
        runTest("test", 2);
    }

    @Test
    public void run3() throws Throwable {
        runTest("test", 3);
    }

}
