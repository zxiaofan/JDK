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
/*
 */


package org.graalvm.compiler.jtt.except;

import org.junit.Test;

import org.graalvm.compiler.jtt.JTTTest;

public class Except_Locals extends JTTTest {

    public static int test(String a, String b) {
        int x = 0;
        try {
            x = 1;
            a.toString();
            x = 2;
            b.toString();
        } catch (NullPointerException e) {
            return x;
        }
        return -1;
    }

    @Test
    public void run0() throws Throwable {
        runTest("test", null, null);
    }

    @Test
    public void run1() throws Throwable {
        runTest("test", "", null);
    }

    @Test
    public void run2() throws Throwable {
        runTest("test", "", "");
    }

}
