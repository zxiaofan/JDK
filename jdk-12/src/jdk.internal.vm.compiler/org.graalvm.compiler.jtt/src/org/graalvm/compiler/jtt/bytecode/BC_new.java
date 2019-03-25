/*
 * Copyright (c) 2007, 2018, Oracle and/or its affiliates. All rights reserved.
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


package org.graalvm.compiler.jtt.bytecode;

import org.junit.Test;

import org.graalvm.compiler.jtt.JTTTest;

/*
 */
public class BC_new extends JTTTest {

    @SuppressWarnings("unused")
    public static int test(int a) {
        new DummyTestClass();
        return a;
    }

    @Test
    public void run0() throws Throwable {
        runTest("test", 0);
    }

}
