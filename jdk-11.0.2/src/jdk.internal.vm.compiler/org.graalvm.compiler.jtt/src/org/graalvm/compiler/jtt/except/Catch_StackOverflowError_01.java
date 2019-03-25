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
public class Catch_StackOverflowError_01 extends JTTTest {

    private static void recurse() {
        recurse();
    }

    public static int test() throws StackOverflowError {
        recurse();
        return -1;
    }

    @Test
    public void run0() throws Throwable {
        runTest("test");
    }

}
