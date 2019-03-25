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
public class BC_getfield extends JTTTest {

    private static BC_getfield object = new BC_getfield();

    private int field = 13;

    public static int test() {
        return object.field;
    }

    @Test
    public void run0() throws Throwable {
        runTest("test");
    }

}
