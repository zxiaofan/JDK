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
public class BC_monitorenter extends JTTTest {

    static DummyTestClass object = new DummyTestClass();

    public static boolean test(boolean arg) {
        final Object o = arg ? object : null;
        synchronized (o) {
            return arg;
        }
    }

    @Test
    public void run0() throws Throwable {
        runTest("test", true);
    }

    @Test
    public void run1() throws Throwable {
        runTest("test", false);
    }

}
