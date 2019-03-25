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
public class Catch_Two02 extends JTTTest {

    public static String test(int arg) {
        try {
            throwSomething(arg + 10);
        } catch (NullPointerException e) {
            return e.getClass().getName();
        } catch (ArithmeticException e) {
            return e.getClass().getName();
        }
        return "none" + (arg + 10);
    }

    private static void throwSomething(int arg) {
        if (arg == 10) {
            throw new NullPointerException();
        }
        if (arg == 11) {
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
        runTest("test", 3);
    }

}
