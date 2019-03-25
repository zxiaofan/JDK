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
public class Catch_Two01 extends JTTTest {

    public static String test(int arg) {
        try {
            throwSomething(arg);
        } catch (NullPointerException e) {
            return e.getClass().getName();
        } catch (ArithmeticException e) {
            return e.getClass().getName();
        }
        return "none";
    }

    private static void throwSomething(int arg) {
        if (arg == 0) {
            throw new NullPointerException();
        }
        if (arg == 1) {
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
