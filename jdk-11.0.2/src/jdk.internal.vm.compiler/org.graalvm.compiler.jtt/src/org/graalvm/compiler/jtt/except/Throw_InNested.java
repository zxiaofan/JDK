/*
 * Copyright (c) 2010, 2012, Oracle and/or its affiliates. All rights reserved.
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

public class Throw_InNested extends JTTTest {

    public static int test(int i) throws Exception {
        return 42 + test2(i);
    }

    public static int test2(int i) throws Exception {
        try {
            return test3(i);
        } catch (Exception e) {
            return 5;
        }
    }

    private static int test3(int i) {
        if (i == 0) {
            throw new RuntimeException();
        }
        return i;
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
