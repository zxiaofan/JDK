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
public class Catch_NPE_05 extends JTTTest {

    private int field = 45;

    public static int test(int a) {
        try {
            return throwNPE(a);
        } catch (NullPointerException npe) {
            return a;
        }
    }

    @SuppressWarnings("all")
    private static int throwNPE(int a) {
        if (a >= 0) {
            final Catch_NPE_05 obj = null;
            return obj.field;
        }
        return -1;
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
        runTest("test", -2);
    }

}
