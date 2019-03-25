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


package org.graalvm.compiler.jtt.lang;

import org.junit.Test;

import org.graalvm.compiler.jtt.JTTTest;

public final class Object_hashCode01 extends JTTTest {

    public static boolean test() {
        final Object o1 = new Object();
        final Object o2 = new Object();
        return o1.hashCode() != 0 || o2.hashCode() != 0;
    }

    @Test
    public void run0() throws Throwable {
        runTest("test");
    }

}
