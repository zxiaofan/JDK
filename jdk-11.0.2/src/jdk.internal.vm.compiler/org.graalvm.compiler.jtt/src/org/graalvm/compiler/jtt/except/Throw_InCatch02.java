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


package org.graalvm.compiler.jtt.except;

import org.junit.Test;

import org.graalvm.compiler.jtt.JTTTest;

public class Throw_InCatch02 extends JTTTest {

    public static boolean test(int i) throws Exception {
        if (i == 0) {
            return true;
        }
        try {
            throwE();
        } catch (Exception e) {
            throwE(e);
        }
        return false;
    }

    private static void throwE(Exception e) throws Exception {
        throw e;
    }

    private static void throwE() throws Exception {
        throw new Exception();
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
