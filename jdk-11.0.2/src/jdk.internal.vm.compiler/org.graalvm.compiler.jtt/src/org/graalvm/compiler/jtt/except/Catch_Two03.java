/*
 * Copyright (c) 2009, 2012, Oracle and/or its affiliates. All rights reserved.
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


package org.graalvm.compiler.jtt.except;

import org.junit.Test;

import org.graalvm.compiler.jtt.JTTTest;

/*
 */
public class Catch_Two03 extends JTTTest {

    public static String test(int arg) {
        int r = 0;
        try {
            r = 1;
            throwSomething(r + arg);
            r = 2;
            throwSomething(r + arg);
            r = 3;
            throwSomething(r + arg);
            r = 4;
        } catch (NullPointerException e) {
            return e.getClass().getName() + r;
        } catch (ArithmeticException e) {
            return e.getClass().getName() + r;
        }
        return "none" + r;
    }

    private static void throwSomething(int arg) {
        if (arg == 5) {
            throw new NullPointerException();
        }
        if (arg == 6) {
            throw new ArithmeticException();
        }
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

}
