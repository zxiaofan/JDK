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
public class Finally02 extends JTTTest {

    public static int test() {
        try {
            a();
        } finally {
            b();
        }

        return c();
    }

    static int a() {
        return 0;
    }

    static int b() {
        return -3;
    }

    static int c() {
        return -1;
    }

    @Test
    public void run0() throws Throwable {
        runTest("test");
    }

}
