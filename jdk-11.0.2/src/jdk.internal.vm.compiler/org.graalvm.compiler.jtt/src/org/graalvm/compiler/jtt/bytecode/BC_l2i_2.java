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


package org.graalvm.compiler.jtt.bytecode;

import org.junit.Test;

import org.graalvm.compiler.jtt.JTTTest;

/*
 */
public class BC_l2i_2 extends JTTTest {

    static Object[] array = {null};

    public static Object test(long a) {
        long arg = a;
        arg = arg << 32;
        return array[(int) arg];
    }

    @Test
    public void run0() throws Throwable {
        runTest("test", 1L);
    }

    @Test
    public void run1() throws Throwable {
        runTest("test", 123456789L);
    }

}
