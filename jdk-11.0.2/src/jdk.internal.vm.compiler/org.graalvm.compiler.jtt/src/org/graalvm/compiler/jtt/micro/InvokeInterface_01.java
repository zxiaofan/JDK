/*
 * Copyright (c) 2014, 2014, Oracle and/or its affiliates. All rights reserved.
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

import org.junit.Before;
import org.junit.Test;

import org.graalvm.compiler.jtt.JTTTest;

/*
 */
public class InvokeInterface_01 extends JTTTest {

    interface I {

        int plus(int a);
    }

    abstract static class A implements I {

        @Override
        public int plus(int a) {
            return a;
        }
    }

    static class C1 extends A {
    }

    static class C2 extends A {
    }

    static class C3 extends A {
    }

    static class C4 extends A {
    }

    static class C5 extends A {
    }

    static class C6 extends A {
    }

    static class C7 extends A {
    }

    static class C8 extends A {
    }

    static class C9 extends A {
    }

    static class C10 extends A {
    }

    static class C11 extends A {
    }

    static class C12 extends A {
    }

    static class C13 extends A {
    }

    static class C14 extends A {
    }

    static class C15 extends A {
    }

    public static int test(I i, int a) {
        return i.plus(a);
    }

    @Before
    public void setUp() {
        I[] x = new I[]{new C1(), new C2(), new C3(), new C4(), new C5(), new C6(), new C7(), new C8(), new C9(), new C10(), new C11(), new C12(), new C13(), new C14(), new C15()};
        int a = 0;
        for (I i : x) {
            i.plus(a++);
        }
    }

    @Test
    public void run0() throws Throwable {
        runTest("test", new C1(), 0);
    }

    @Test
    public void run1() throws Throwable {
        runTest("test", new C2(), 1);
    }

}
