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
 * Copyright (c) 2007, 2012, Oracle and/or its affiliates. All rights reserved.
 */


package org.graalvm.compiler.jtt.bytecode;

import org.junit.Test;

import org.graalvm.compiler.jtt.JTTTest;

/*
 */
public class BC_aload_1 extends JTTTest {

    @SuppressWarnings("unused")
    public static Object test(int i, Object arg) {
        return arg;
    }

    @Test
    public void run0() throws Throwable {
        runTest("test", 1, null);
    }

    @Test
    public void run1() throws Throwable {
        runTest("test", 1, "x");
    }

}
