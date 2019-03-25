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



package org.graalvm.compiler.jtt.except;

import org.junit.Test;

import org.graalvm.compiler.jtt.JTTTest;

/*
 */
public class Catch_NPE_07 extends JTTTest {

    @SuppressWarnings("serial")
    public static class MyThrowable extends Throwable {
    }

    @SuppressWarnings("unused")
    public static int foo(Throwable t) {
        try {
            throw t;
        } catch (Throwable t1) {
            if (t1 == null) {
                return -1;
            }
            if (t1 instanceof NullPointerException) {
                return 0;
            }
            if (t1 instanceof MyThrowable) {
                return 1;
            }
            return -2;
        }
    }

    public static int test(int i) {
        Throwable t = (i == 0) ? null : new MyThrowable();
        try {
            return foo(t);
        } catch (Throwable t1) {
            return -3;
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

}
